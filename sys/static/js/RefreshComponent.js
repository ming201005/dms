//模板
const TEMPLATE_HTML =
`
<span class="el-refresh"  @click='pageReload'>
   <el-tooltip content="刷新" placement="bottom" effect="light">
      <i class="el-icon-refresh"></i>
   </el-tooltip>
</span>
`;

/**
 * 刷新组件
 */
Vue.component('refresh-comm', {
    template: TEMPLATE_HTML,
    methods:{
        pageReload() {
            console.log("刷新页面！")
            window.location.reload();
        }
    }
});