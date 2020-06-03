/**
 * @type {{setAuth(*=): void, _getVal(*): (*|null), getAuth(): *, _getAuth(): void, getToken(): *, authObj: null, getUserName(): *, delAuth(): void, gotoLogin(*=): void, USER_AUTH_KEY: string, managerCenter(*=): void}}
 */

let Auth = {

    USER_AUTH_KEY: "Authorization",

    //高级管理员的标识符，并不是改了这个就成为高级管理员了，仅仅是一个标识符。
    ADMIN : "ADMIN",

    authObj:null,

    /**
     * 登录
     */
    login(user) {
        if(this._verify(user)) {
            // PART 2 、3
            axios.post(global_api_url+"login", user).then(rs => {
                if (rs.data.code == 0) {
                    //登录成功
                    let userAuth = rs.data.data;
                    //存用户权限信息
                    this.setAuth(userAuth);
                    //决定是否跳转
                    this.gotoManagerCenter(userAuth.token);
                } else {
                    alert(rs.data.msg);
                }
            }).catch(err => {
                alert(err);
            });
        }
    },

    /**
     * 退出
     */
    logout() {
        axios.get(global_api_url+"logout").then(rs=>{
            if(rs.data.code ==0 ) {
                this.deleteAuth();
                document.location.reload();
            }else{
                alert(rs.data.msg);
            }
        }).catch(err=>{
            alert(err)
        });
    },

    /**
     * 保存用户基本权限信息
     * @param auth
     */
    setAuth(auth) {
        if (auth) {
            let authString = JSON.stringify(auth);
            window.sessionStorage.setItem(this.USER_AUTH_KEY, authString);
        }
    },
    /**
     * 清除sessionStorage中的userAuth
     */
    deleteAuth(){
        window.sessionStorage.removeItem(this.USER_AUTH_KEY);
    },

    /**
     * 可以直接调用此方法获得当前登录人
     * @returns {null}
     */
    getUserName() {
        return this._getVal("username");
    },

    /**
     * 可以直接调用此方法获得角色名称
     * @returns {string}
     */
    getAuth(){
        return this._getVal("auth");
    },

    //获得组织ID
    getOrganizationId(){
        return this._getVal("organizationid");
    },

    //获得组织名称
    getOrganizationname(){
        return this._getVal("organizationname");
    },

    //以字符串返回，且转换了ADMIN为超级管理员。
    getAuthValueString() {
        let arr =  this.getAuthValueArr()
        let str = arr.map(item=> (item == Auth.ADMIN)? "超级管理员" : item );
        return str.toString();
    },

    //以数组返回,且过滤了"ROLE_"
    getAuthValueArr() {
        let arr =  this.getAuth();
        let str = [];
        arr.forEach(item =>{
            str.push(item.authority.replace("ROLE_",""));
        });
        return str;
    },


    /**
     * 可以直接调用此方法获得该用户的菜单
     * @returns {null}
     */
    getMenus() {
        return this._getVal("menus");
    },


    /**
     * 可以直接调用此方法获得token，一般不需要调用
     * 在checkIsLogin.js中已经设置到全局的headers中
     * 访问后台API时，自动携带了token，无须每次都设置
     * @returns {null}
     */
    getToken(){
        return this._getVal("token");
    },

    /**
     * 进入管理中心
     * @param token
     */
    gotoManagerCenter(token) {
        if(token) {
            document.location.href = this._getProjectPath()+"/index.html";
        }
    },

    /**
     * 进入登录页面
     * @param token
     */
    gotoLogin(token) {
        if(!token) {
            document.location.href = this._getProjectPath()+"/login.html";
        }
    },

    /**
     * 查找项目路径
     * @returns {string}
     * @private
     */
    _getProjectPath(){
        let requestPath = window.document.location.href;

        let length = requestPath.indexOf(htmlPath);
        if(length <0){
            length = requestPath.lastIndexOf("/");
            if(length>0) length -=length;
        }else{
            length +=htmlPath.length;
        }

        return requestPath.substr(0,length);
    },

    _getAuth() {
       let authString =  window.sessionStorage.getItem(this.USER_AUTH_KEY);
       if(authString) {
           this.authObj = JSON.parse(authString);
       }
    },
    _getVal(val){
        if(this.authObj == null){
            //console.log("加载sessionStorage中的userAuth信息......");
            this._getAuth();
        }
        return  this.authObj? this.authObj[val] : null;
    },

    //登录验证
    _verify(user) {
        let errArr = [];
        //做一个简单的验证
        if (user.username == null || user.username =="") {
            errArr.push("请输入账号！");
        }else if(user.password == null || user.password ==""){
            errArr.push("请输入密码！");
        }else if(user.password.length<6 || user.password.length>20){
            errArr.push("密码范围是6~20位数！");
        }
        if(errArr.length>0){
            alert(errArr);
        }else {
            return true;
        }
        return false;
    }
}