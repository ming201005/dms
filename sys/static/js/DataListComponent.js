/**
 * 列表组件
 */
Vue.component('data-list-comm', {
    //模板
    template: `
<div class="model_list">
    <div class="button_group line" v-if="opentionshow==true">
        <div class="buttons">
            <button v-if="onAddNewForm" @click="addNewForm" >新建</button>
            <!-- 未来扩展批量删除、等功能，可以对其设置开启、关闭的控制参数-->
            <slot name="bts">
               
            </slot>
        </div>
        <slot name="page"><div class="page"></div></slot>
    </div>
    <table width="100%" border="0" cellspacing="1" cellpadding="0">
        <!--支持外部加入数据填充-->
        <slot name="dataHead">
            <tr class="h">
                 <td v-for="attrItem in modelAttr" :width="attrItem.width">
                 <div style="text-align: center;">{{attrItem.display}}</div>
                 </td>
                 <td v-if="option" style="text-align: center;">操作</td>
            </tr>
        </slot>
        
        <!--列表展现-->
        <!--支持外部加入数据填充-->
        <slot>
            <tr v-for="item in modelList">
                 <td v-for="attrItem in modelAttr">
                    <div style="width: 100%; text-align: center;">
                      <img v-if="attrItem.img" 
                         :src="BASE_IMG_URL+item[attrItem.attribute]" 
                         style="border-radius: 5px;"
                         onload="App.autoResizeImage(this,60,60)">
                      <div v-if="!attrItem.img" style="text-align: left;" >{{HTMLEncode(item[attrItem.attribute])}}</div>
                      
                    </div>
                 </td>
                 
                 <td v-if="option"  style="text-align: center;">
                    <button v-if="onEditForm" @click="editForm(item)" >编辑</button>
                    <button v-if="deleteApiUrl" @click="del(item)" >删除</button>
                 </td>
            </tr>
        </slot>
    </table>
</div>
<div>
</div>
`,
    //组件内数据
    data() {
        return {
            modelList: []
        }
    },
    //接收父组件的值
    //注意参数传入时，是支持驼峰命名
    //listAipUrl是list-api-url
    props: {
        opentions:null,
        //查询列表的API URL
        listApiUrl: null,
        //行ID
        rowIdKey: null,
        //删除当前行记录的API URL
        deleteApiUrl: null,
        //表单头
        modelAttr: [],
        //新建表单
        onAddNewForm: {
            type: Function,
            default: null
        },
        //编辑表单获得数据
        onEditForm: {
            type: Function,
            default: null
        },
        //是否需要操作
        optionShow: true,
        //是否有分页
        isPage: true,
        onPage:{
            type: Function,
            default: null
        },
        //是否把查询方法执行权交给父组件
        refParent: true
    },
    created() {
        //如果没有设置父组件执行权，在组件内执行
        if (!this.refParent) {
            this.getModelList();
        }
        
    },
    computed: {
        //默认情况下有操作事件
        option() {
            //console.log(this.optionShow);
            if (this.optionShow == null) {
                return true;
            } else {
                return this.optionShow;
            }
        },
        //是否显示头部操作
        opentionshow(){
            if(this.opentions == undefined || this.opentions == null){
                return true; 
            }else{
                return this.opentions;
            }
        }
    },

    methods: {

        HTMLEncode(value) {
            if(value !=null){
                var temp = document.createElement("div");
                temp.innerHTML = value;
                var output = temp.innerText || temp.textContent;
                temp = null;
                return output;
            }
            return "";
        },

        /**
         * 查询列表数据，此方法必须用async修饰，在父组件中才能取到。
         * @returns {Promise<void>}
         */
        async getModelList(url,dataParams) {
            console.log("正在执行 getModelList。。。。。。。。")
            if(url){
                this.listApiUrl = url;
            }
            console.log("listApiUrl========",this.listApiUrl)
            console.log("dataParams========",dataParams)

            if (this.listApiUrl != null && this.listApiUrl != "") {
                //设置等待
                await axios.get(this.listApiUrl,dataParams).then(rs => {

                    if (rs.data.code == 0) {
                        console.log("原始数据==》",rs.data.data.records);
                        //如果是后台已经分页返回来的值
                        if (this.isPage) {
                            this.modelList = rs.data.data.records;
                            //如果需要分页对象
                            if(this.onPage){
                                //返回分页对象
                                let page = {
                                    current : rs.data.data.current,
                                    pages   : rs.data.data.pages,
                                    total   : rs.data.data.total,
                                    size    : rs.data.data.size
                                }
                                this.onPage(page);
                            }
                        } else {
                            this.modelList = rs.data.data;
                        }
                    } else {
                        this.$message.error("错误："+rs.data.msg);
                    }
                }).catch(err => {
                    this.$message.error("错误："+err);
                });

            } else {
                this.$message.error("列表需要请求API地址参数。");
            }
        },

        /**
         * 新建表单
         */
        addNewForm() {
            if (this.onAddNewForm) {
                this.onAddNewForm();
            } else {
                console.log("需要自定义挂载方法。");
            }
        },

        /**
         * 编辑表单获得数据
         */
        editForm(row) {
            if (this.onEditForm) {
                this.onEditForm(row);
            } else {
                console.log("需要自定义挂载方法，当前要编辑的数据是：", row);
            }
        },


        /**
         * 删除,如果要做批量删除。请传多个frontendMenuId，或者
         * 传“,”分开的id，例如：id=1,2,3,5,6。后端接收参数idList
         * @param row
         */
        del(row,params) {
            if (this.deleteApiUrl != null && this.deleteApiUrl != "") {
                if (confirm('一旦删除，不可恢复,且关联的子表也一起删除，请确认。')) {
                    //删除单条
                     
                    let url = this.deleteApiUrl ;
                    if(params){
                        url += params;
                    }else{
                        if(this.rowIdKey){
                            url += "?idList=" + row[this.rowIdKey];
                        }else{
                            this.$message.error("行主键没有指定！");
                        }
                    }
                
                    //删除多条，预留功能
                    //TODO
                    console.log("DEL URL===>>", url)
                    axios.delete(url).then(rs => {
                        if (rs.data.code == 0) {
                            if (this.refParent) {
                                //如果是父组件调用
                                this.$emit("on-delete-success");
                            } else {
                                this.getModelList();
                            }
                        } else {
                            this.$message.error("错误："+rs.data.msg);
                        }
                    }).catch(err => {
                        this.$message.error("错误："+err);
                    });
                }
            } else {
                this.$message.error("缺少删除数据的API地址参数。");
            }
        }
    }
});