Vue.component('header-comm', {
    template:   `
                  <div class="web-header-wrap">
                    <a href="/" style="display:flex;flex-direction: column;width: 310px; ">
                        <span style="color:#FFF;font-size:26px;margin-left:20px;">
                        牛刀知识共享平台
                        </span> 
                        <span class="web-header-logo" style="color:#f8aa08;font-size:18px;">
                        niudao.cn &#183; 能学到真本领
                        </span>
                    </a>
                    <ul class="web-nav-list">
                        <li :class="{active: index == 0 }"><a href="/">首页</a></li>
                        <li :class="{active: index == 1 }"><a href="course">课程</a></li>
                        <li :class="{active: index == 2 }"><a href="#">阅读</a></li>
                        <li :class="{active: index == 3 }"><a href="#">开源</a></li>
                        <li :class="{active: index == 4 }"><a href="#">圈子</a></li>
					</ul>
                    <div class="niudao-online">
                        <div class="logined ">
                            <img src="./assets/img/develop/teacher.jpg" alt=""> 
                            <span class="username">小明哥</span>
                            <i class="tml-icon tml-angle-down"></i>
                            <ul class="top-setting-list">
                                <li>
                                    <a :href="accountUrl">用户中心</a>
                                </li>
                                <li>
                                    <a class="loginout_user" href="javascript:void(0);">退出</a>
                                </li>
                            </ul>
                        </div>
                        <a class="niudao-online-link login_user hidden" href="#">登录</a> 
                    </div>
                </div>`,
    props: {
        //当前页号
        index:null
    },
    data() {
        return{
            accountUrl: null
        }
    },
    created() {
       this.init();
    },
    methods: {
        init(){
            this.accountUrl = null;
            //页面标题
            //let titles = ['首页-知识共享平台', '课程-课程学习', '阅读-书籍在线阅读', '开源-开源项目推荐', '圈子-提问、分享、讨论'];
            //根据index设置对应的页面标题
            //document.title = titles[this.index];
        }
    }
});