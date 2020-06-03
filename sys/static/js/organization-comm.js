//组织架构树
Vue.component('organization-comm',{
    template:`
    <div style="width: 350px;display: flex; flex-direction: column;" v-if="isAdmin">
        <div @click="loadIndexDataOfParent(item)"
             :class="item.id==organizationId? 'button-over':'button-style'"
             v-for="item in organizationList">{{item.name}}
        </div>
    </div>
    `,
    data () {
        return {
            isAdmin:null,
            organizationList:[],
            organizationId:"",
            organizationName:"",
        }
    },
    props:{
        indexId:null,
        loadAllData:{
            type:Function,
            default:null
        },
        loadIndexData:{
            type:Function,
            default:null
        }
    },
    created(){
        
    },
    watch:{
        indexId(){
            if(this.indexId){
                this.organizationId = this.indexId;
            }
        }
    },

    //虚拟DOM挂在后再调用
    mounted() {
        this.pageInit();
    },
     
    methods: {
        /**
         * 控制组织树
         * returnData： 返回的数据
         * loadAllData：全部加载
         * loadIndexData：加载某个数据
         */ 
        pageInit(){
            //TODO
            let auth = Auth.getAuthValueArr();
            App.getBaseListApi(global_api_url+"organization",data=> {
                this.organizationList = data;
                console.log("找-----》",auth.indexOf(Auth.ADMIN));
                //不是管理员账号
                if(auth.indexOf(Auth.ADMIN)==-1){
                    //只显示本人所属的组织
                    this.organizationList = this.organizationList.filter(item=>item.id == Auth.getOrganizationId());
                    //根据条件查询
                    //加载某个组织架构下数据
                    this.loadIndexDataOfParent(this.organizationList[0]);
                }else{
                    this.isAdmin = true;
                    if(this.loadAllData){
                        //如果是ADMIN的话，初始化查询
                        this.loadAllData();
                    }
                }
            });
        },
         /**
         * 加载右边数据
         */ 
        loadIndexDataOfParent(item){
            this.organizationId = item.id;
            this.organizationName = item.name;
            if(this.loadIndexData){
              this.loadIndexData(item);  
            }
            
        },
    }
});