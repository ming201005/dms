Vue.component('page-comm',{
    template:`
    <div class="pagination">
            <li v-show="current != 1" @click="current-- && goto(current)">
                <a href="#">上一页</a>
            </li>
            <li v-for="index in pages" @click="goto(index)" :class="{'active':current == index}" :key="index">
                <a href="#">{{index}}</a>
            </li>
            <li v-show="allpage != current && allpage != 0 " @click="current++ && goto(current++)">
                <a href="#">下一页</a>
            </li>
        </div>
    `,
    data () {
        return {
            // 最少显示5个页码
            showItem: 5
        }
    },
    props:{
        current: 1,    // 当前页码
        allpage: null, // 总共的
        size:null,
        total:null,
        //当前页数据
        indexPageData:{
            type:Function,
            default:null
        }
    },
    computed: {
        pages () {
            let pag = [];
            //如果当前的激活的项 小于要显示的条数
            if (this.current < this.showItem) {
                //总页数和要显示的条数那个大就显示多少条
                let i = Math.min(this.showItem, this.allpage);
                while (i) {
                    pag.unshift(i--);
                }
            } else {
                //当前页数大于显示页数了
                //从哪里开始
                let middle = this.current - Math.floor(this.showItem / 2);
                let i = this.showItem;
                if (middle > (this.allpage - this.showItem)) {
                    middle = (this.allpage - this.showItem) + 1
                }
                while (i--) {
                    pag.push(middle++);
                }
            }
            return pag
        }
    },
    methods: {
        goto (index) {

            if (index == this.current) return;
            //this.current = index;
            if(this.indexPageData){
                this.indexPageData(index);
            }
        }
    }
});