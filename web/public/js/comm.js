//API访问地址
const GLOBAL_API_URL = "http://niudao.cn:84/web/";
//图片所在地址,用nginx配置一个资源服务器，指向资源路径
const BASE_IMG_URL = "http://niudao.cn:83/images/";

comm = {
    /**
     * 基础列表形式，无分页 api
     */
    getBaseListApi(apiName, returnData) {
        let apiUrl = apiName + "?size=1000";
        this.getFormDataById(apiUrl, data=>returnData(data.records));
    },

    /**
     * 枚举列表形式 api
     */
    getEnumListApi(enumName, returnData) {
        let apiUrl = enumName;
        this.getFormDataById(apiUrl, data=> returnData(data));
    },

    /**
     * 通过id取表单数据
     * @param apiName
     * @param returnData
     */
    getFormDataById(apiName,returnData){
        let apiUrl = apiName;
        axios.get(apiUrl).then(rs => {
            console.log("getFormDataById==>", rs);
            if (rs.data.code == 0) {
                rs = rs.data;
                returnData(rs.data);
            } else {
                alert(rs.data.msg);
            }
        }).catch(e => {
            alert(e);
        });
    },



    /**
     * 取参数
     * @param name
     * @returns {string}
     */
    getParameter:function(name) {
        let query = window.location.search;
        // console.log("getParameter===>",query);
        let iLen = name.length;
        let iStart = query.indexOf(name);
        //参数名称不存在
        if(iStart == -1){
            return "";
        }else{
            //参数存在
            iStart += iLen + 1;
            //寻找结尾标识符 &
            let iEnd = query.indexOf("&", iStart);
            return (iEnd == -1)? query.substring(iStart) : query.substring(iStart,iEnd);
        }
    },

    /**
     * 设置URL参数
     * @param paramName
     * @param value
     */
    setUrlParam(name, value) {
        let url = new URL(window.location.href);
        //console.log("set url===>",url);
        //如果还没有参数，追加参数
        if(!this.getParameter(name)){
            url.searchParams.append(name,value);
        }else {
            //如果有这个参数，修改这个参数
            url.searchParams.set(name,value);
        }
        //更改URL上的地址，但不刷新页面。防止之后刷新页面跳回首页
        history.pushState({}, null, url.href);
    },

    /**
     * url 目标url
     * arg 需要替换的参数名称
     * arg_val 替换后的参数的值
     * return url 参数替换后的url
     */
    changeURLArg:function(url,arg,arg_val) {
        var pattern=arg+'=([^&]*)';
        var replaceText=arg+'='+arg_val;
        if(url.match(pattern)){
            var tmp='/('+ arg+'=)([^&]*)/gi';
            tmp=url.replace(eval(tmp),replaceText);
            return tmp;
        }else{
            if(url.match('[\?]')){
                return url+'&'+replaceText;
            }else{
                return url+'?'+replaceText;
            }
        }
        return url+'\n'+arg+'\n'+arg_val;
    },

    /**
     * json转换key1=val1&key2=val2
     * @param json
     * @returns {string}
     */
    jsonToParams:function (json) {
        var str = "";
        var value = "";
        for (var key in json) {
            value = json[key];

            //str = str+ "&" + key + "=" + value;
            if(!value || value=="undefined" || value=="null" ){
                continue;
            }else{
                str = str + "&" + key + "=" + value;
            }
        }
        return str;
    },

    /**
     * 随机
     * @returns {number}
     */
    random() {
        let lower = 1000;
        let upper = 100000;
        return Math.floor(Math.random() * (upper - lower)) + lower;
    },

    /**
     * 时间戳格式化为正常的时间
     * @param date
     * @param fmt
     * @returns {*}
     */
    dateFormat(d,fmt) {
        let date = new Date(d);
        let ret;
        const opt = {
            "Y+": date.getFullYear().toString(),        // 年
            "m+": (date.getMonth() + 1).toString(),     // 月
            "d+": date.getDate().toString(),            // 日
            "H+": date.getHours().toString(),           // 时
            "M+": date.getMinutes().toString(),         // 分
            "S+": date.getSeconds().toString()          // 秒
            // 有其他格式化字符需求可以继续添加，必须转化成字符串
        };
        for (let k in opt) {
            ret = new RegExp("(" + k + ")").exec(fmt);
            if (ret) {
                fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
            };
        };
        return fmt;
    },

    padLeftZero:function(str) {
        return ('00' + str).substr(str.length);
    }
};

$(function(){
    // 初始化滚动条
    $(".public-custom-scrollbar:not(.do-animate)").mCustomScrollbar({
        autoHideScrollbar:true,
        theme:"minimal-dark",
        callbacks:{
            whileScrolling:function(){
                if(this.mcs.top < -100){
                    $(".fixed-back-top").removeClass("hide");
                } else {
                    $(".fixed-back-top").addClass("hide");
                }
            }
        }
    });

    // 登录成功后
    $('.logined').on('click', function(){
        let $this = $(this),
            $ul = $this.find('ul');
        $ul.hasClass('active') ? $ul.removeClass('active') : $ul.addClass('active');
    });
});



// 通用选项卡切换,首页切换屏幕使用
const TAB_TOGGLE = function(){
    return {
        init( { key = '' }){
            if( '' != key ){
                const el = document.querySelector( key );
                if( !el ){
                    return;
                }
                this.el = el;
                this.header = this.el.children[0];
                this.items = this.el.children[1].children;
                this.timeout = null;
                this.index = 0;
                this._bind();
                this._auto();
            }
            return this;
        },

        _bind(){
            this.header.addEventListener('mouseup', ( e ) => {
                clearTimeout( this.timeout );
                const el = e.target.nodeName == 'I' || e.target.nodeName == 'SPAN' ? e.target.parentNode : e.target;

                if( el.dataset.index <= this.items.length - 1 ){

                    for( let item of this.items ){
                        item.classList.remove('active');
                    }

                    for( let item of this.header.children ){
                        item.classList.remove('active');
                    }

                    el.classList.add('active');
                    this.items[ el.dataset.index ].classList.add('active');
                    this.index = el.dataset.index;
                }
            }, false);

            this.header.addEventListener('mouseover', ( e ) => {
                clearTimeout( this.timeout );
            });

            this.header.addEventListener('mouseout', ( e ) => {
                this._auto();
            });
        },

        _auto(){
            clearTimeout( this.timeout );
            this.timeout = setTimeout( () => {

                this.index > this.items.length - 1 ? this.index = 0 : null;

                for( let item of this.header.children ){
                    item.classList.remove('active');
                }

                for( let item of this.items ){
                    item.classList.remove('active');
                }

                this.header.children[ this.index ].classList.add('active');
                this.items[ this.index ].classList.add('active');

                this.index++;
                this._auto();
            }, 3000);
        }
    }
};

// 首页第二屏 tab 切换
const INDEX_TAB = new TAB_TOGGLE().init({
    key: '.screen2-tab'
});