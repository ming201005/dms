Vue.component('video-list-comm',{
    template:`
       <div class="develop-video-content">
            <div v-if="!search" class="public-content-header">
                <div class="public-content-header-left" v-if="title">
                    <p class="header-name on" :order-text="tabText">{{title}}</p>
                </div>
                <div class="public-content-header-right flex">
                    <p class="header-class">共<span class="orange">{{total}}</span>个课程</p>
                    <slot></slot>
                    <p class="gray-9"><a :href="moreUrl">查看更多课程>></a></p>
                </div>
            </div>
            <div class="develop-video-list" :style="small?{width:'280px'}:{}">
                <div class="list-item" v-for="item in list">
                    <div class="item-img" @click="jump(item.courseId)">
                        <img v-if="item.courseImg" :src="BASE_IMG_URL+item.courseImg" alt="">
                        <img v-else src="./assets/img/defaultimg.jpg" alt="">
                        <div class="item-img-modal">
                            <img style="border-radius: 5px;" src="./assets/img/develop/develop-play.png"
                                 :alt="item.courseTypeName +'-'+item.courseName">
                        </div>
                        <p class="video-time">{{item.createTime | dateFormat}}</p>
                    </div>
                    <p class="item-name" style="color: #909399;">{{item.courseTypeName}} </p>
                    <p class="item-name">{{item.courseName}}</p>
                    <p class="item-study">
                        <!--<span v-if="item.price>0" class="item-price"><s>￥{{item.price}}</s></span>-->
                        <span class="item-free">免费</span>
                        <span v-if="item.studyNumber==0"></span>
                        <span v-else>{{item.studyNumber | number}}人已学习</span>
                    </p>
                </div>
            </div>
        </div>
    `,
    props:{
        title :null,   //标题
        tabText:null,  //tab显示
        params:null,   //参数
        search:null,   //是否是在搜索列表页面调用
        small:null,    //允许在详情页调用，显示单列。
        loadSuccess:{  //加载完毕，让父组件的loadSuccess方法处理结果集
            type:Function,
            default:null
        }
    },
    data(){
        return {
            list: [],
            total:0,
            url: null,
            //TODO
            //带优化，需要设置参数，进入课程页面后，自动搜索到此类课程。
            moreUrl : "course"
        }
    },
    created: function () {
        this.init();
    },
    filters: {
        dateFormat(value) {
            //console.log(value);
            return comm.dateFormat(value, 'YYYY-mm-dd');
        },
        number(value) {
            console.log(value);
            return value == undefined ? comm.random() : value;
        }
    },

    methods: {
        init() {
            this.getData();
        },

        //获取页面数据,支持直接传参数
        getData(params) {
            if(params){
                this.url = GLOBAL_API_URL + "course" + params;
            }else{
                if(this.params == undefined) {
                    this.url = GLOBAL_API_URL + "course?size = 8";
                }else {
                    this.url = GLOBAL_API_URL + "course" + this.params;
                }
            }
            console.log("video-list-comm组件内，请求API的URL：：：",this.url);
            axios.get(this.url).then(rs => {
                rs = rs.data;
                if (rs.code == 0) {
                   this.list  = rs.data.records;
                   this.total = rs.data.total;
                   //返回结果集给父组件
                   if(this.loadSuccess) {
                       this.loadSuccess(rs.data);
                   }
                } else {
                    alert(rs.msg);
                }
            }).catch(e => {
                alert(e);
            });
        },

        //详情页跳转
        jump: function (vid) {
            window.open("courseDetail?vid=" + vid);
        }
    }

})