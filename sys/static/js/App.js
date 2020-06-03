//api访问地址，可修改,这里用了nginx做了反向代理指向
const global_api_url = "http://localhost:8080/";
//图片所在地址,用nginx配置一个资源服务器，指向资源路径
// const BASE_IMG_URL = "http://localhost:89/";
//后端项目名称
const htmlPath = "sys";
//系统名称，动态
const SYS_NAME = "资料管理系统(DMS-V1.0)";

/**
 * App
 * 封装一些常用的方法，和业务无关，其他项目也可以使用
 * 含private_的方法是提供本类内部调用
 * 其他可通用调用
 */
let App =
    {

        getSysName(){
            let sysNmae = SYS_NAME;
            let auth = Auth.getAuthValueArr();
            //非高级管理员
            if(auth.indexOf(Auth.ADMIN)==-1){
                sysNmae = SYS_NAME+"——"+Auth.getOrganizationname(); 
            }
            return sysNmae;
            
        },

        /**
         * 基础列表形式，无分页 api
         */
        getBaseListApi(apiName, returnData,ispage=true) {
            let find = apiName.indexOf("?");
            if(find == -1) apiName += "?size=1000";
            else apiName += "&size=1000";
            this.getFormDataById(apiName, data=>{
                if(ispage){
                    returnData(data.records);
                }else{
                    returnData(data);
                }
                
            });
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
                return null;
            }else{
                //参数存在
                iStart += iLen + 1;
                //寻找结尾标识符 &
                let iEnd = query.indexOf("&", iStart);
                let rs = (iEnd == -1)? query.substring(iStart) : query.substring(iStart,iEnd);
                return decodeURIComponent(rs);
            }
        },

        /**
         * url 目标url
         * arg 需要替换的参数名称
         * arg_val 替换后的参数的值
         * return url 参数替换后的url
         */
        changeURLArg(url, arg, arg_val) {
            var pattern = arg + '=([^&]*)';
            var replaceText = arg + '=' + arg_val;
            if (url.match(pattern)) {
                var tmp = '/(' + arg + '=)([^&]*)/gi';
                tmp = url.replace(eval(tmp), replaceText);
                return tmp;
            } else {
                if (url.match('[\?]')) {
                    return url + '&' + replaceText;
                } else {
                    return url + '?' + replaceText;
                }
            }
            return url + '\n' + arg + '\n' + arg_val;
        },

        /**
         * json转换key1=val1&key2=val2
         * @param json
         * @returns {string}
         */
        jsonToParams(json) {
            var str = "";
            var value = "";
            for (var key in json) {
                value = json[key];

                //str = str+ "&" + key + "=" + value;
                if (!value || value == "undefined" || value == "null") {
                    continue;
                } else {
                    str = str + "&" + key + "=" + value;
                }
            }
            return str;
        },

        /**
         * 时间戳格式化为正常的时间
         * @param date
         * @param fmt
         * @returns {*}
         */
        formatDate(date, fmt) {
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
            }
            let o = {
                'M+': date.getMonth() + 1,
                'd+': date.getDate(),
                'h+': date.getHours(),
                'm+': date.getMinutes(),
                's+': date.getSeconds()
            };
            for (let k in o) {
                if (new RegExp(`(${k})`).test(fmt)) {
                    let str = o[k] + '';
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : this.padLeftZero(str));
                }
            }
            return fmt;
        },

        padLeftZero: function (str) {
            return ('00' + str).substr(str.length);
        },

        //删除选中的图片(唯一id删除)
        delFileById(row, list) {
            //从到选中的图片中删除
            for (let itemIndex in list) {
                //通过id查找，找到后删除立马跳出循环
                if (list[itemIndex].id == row.id) {
                    //从原来的选中图中删掉
                    list.splice(itemIndex, 1);
                    break;
                }
            }
        },

        //删除选中的图片（下标删除）
        delFileByIndex(index, list) {
            //从到选中的图片中删除
            for (let itemIndex in list) {
                //通过id查找，找到后删除立马跳出循环
                if (itemIndex == index) {
                    //从原来的选中图中删掉
                    list.splice(itemIndex, 1);
                    break;
                }
            }
        },

        /**
         * 检查双精度的数字类型（如：销售价）
         */
        isDouble: (rule, value, callback) => {
            let expStr = /^\d+$|^\d+[.]?\d+$/
            if (!expStr.test(value)) {
                callback(new Error('销售价是数字类型。'))
            } else {
                callback()
            }
        },

        /**
         * 左侧高度
         * @returns {number}
         */
        getLeftMenuHeight() {
            //浏览器打开高度
            let clientHeight = document.documentElement.clientHeight;
            //左侧高度
            return clientHeight - 60;
        },

        /**
         * 左侧高度
         * @returns {number}
         */
        getIfmAutoHeight() {
            //设置iframe自适高度
            return this.getLeftMenuHeight() - 65;
        },

        /**
         * 设置图片自适应
         * @param maxWidth
         * @param maxHeight
         * @param objImg
         */
        autoResizeImage(objImg,maxWidth, maxHeight) {
            var img = new Image();
            img.src = objImg.src;
            var hRatio;
            var wRatio;
            var Ratio = 1;
            var w = img.width;
            var h = img.height;
            wRatio = maxWidth / w;
            hRatio = maxHeight / h;
            if (maxWidth == 0 && maxHeight == 0) {
                Ratio = 1;
            } else if (maxWidth == 0) {//
                if (hRatio < 1) Ratio = hRatio;
            } else if (maxHeight == 0) {
                if (wRatio < 1) Ratio = wRatio;
            } else if (wRatio < 1 || hRatio < 1) {
                Ratio = (wRatio <= hRatio ? wRatio : hRatio);
            }
            if (Ratio < 1) {
                w = w * Ratio;
                h = h * Ratio;
            }
            objImg.height = h;
            objImg.width = w;
        },

        /**
         * 功能：富文本对象
         * 使用时必须引入ckEditor富文本插件
         * ckEditorDom 富文本dom的ID
         * ckEditor 富文本对象，以及相关方法
         * doCall 带回处理
         * value 富文本值
         */
          initEditor(ckEditorDom,value,ckEditor,doCall) {
            if(ckEditor == null ) {
                 ClassicEditor
                    .create(document.querySelector(`#${ckEditorDom}`))
                    .then(editor => {
                        //设置值
                        let fun = editor;
                        fun.setData(value);
                        doCall(fun);
                    })
                    .catch(error => {
                        console.error(error);
                    });

            }else{
                //设置值
                ckEditor.setData(value);
                //其他业务的处理
                doCall(ckEditor);
            }
            
            
        }
    };