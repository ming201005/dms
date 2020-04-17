/**
 * 组件名称：img-up
 * 作用：图片上传组件
 */
Vue.component("img-up-comm", {
    template: `
     <el-form-item label="添加图片" prop="productWeight">
                        <div class="imgBox" v-if="isCheckImgList">
                            <!--循环显示图片-->
                            <div class="imgItem" v-for="(item,index) in isCheckImgList">
                                <!--图片显示，用背景图的方式显示-->
                                <div class="imageShow"
                                     :style="{'backgroundImage': 'url(' + BASE_IMG_URL+item.resourceName + ')'}">
                                    <!--当被选中时，上边出现阴影遮住效果-->
                                    <div>
                                        <div style="height: 20px;">
                                            <span size="mini" @click="App.delFileByIndex(index,isCheckImgList)"
                                                  class="el-icon-delete showHide"></span>
                                            <!--<span size="mini" @click="viewImg(BASE_IMG_URL+item.resourceName)" class="el-icon-view showHide"></span>-->
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <!--添加图片的按钮-->
                            <div class="newFile" v-if="checkNumberMax>isCheckImgList.length" @click="openWin">
                                <span class="addNewFile el-icon-plus">
                                    <p style="font-size: 12px;">添加图片</p>
                                </span>
                            </div>
                        </div>
                        <!--弹窗选择图片-->
                        <el-dialog title="选择图片"
                                   width="80%"
                                   top="25px"
                                   center
                                   :visible.sync="dialogFormVisible">

                                  <!--弹窗，调用资源组件-->
                                  <template>
                                  <resource-comm ref="myResource" :from-page="fromPage" 
                                                 :check-number-max="checkNumberMax" 
                                                 :hash-check-num="hashCheckNum"
                                                 :dialog-form-visible="dialogFormVisible"
                                                 :on-selected-img="onSelectedImg"
                                                 @close-win="closeWin">
                                  </resource-comm>
                                  </template>
                        </el-dialog>
                    </el-form-item>
    
    `,
    data(){
        return {
            //打开选择图片的窗口地址
            imgUrl: "../resource/index.html?fromPage=windows",
            //商品图片窗口是否被打开、关闭
            dialogFormVisible: false,
            //已选张数
            hashCheckNum:0
        }
    },
    //支持的参数
    props:{
        //页面来源
        fromPage:null,
        //最多允许选中图片张数
        checkNumberMax: 1,
        //已经选中的图片列表
        isCheckImgList: [],

        onSelect:{
            type:Function,
            default:null
        }
    },

    //数据初始化
    watch:{
        //监听isCheckImgList是否有变化，如果有变化，让hashCheckNum取到值
        isCheckImgList(){
            console.log("hashCheckNum被监听：", this.isCheckImgList)
            this.hashCheckNum = this.isCheckImgList? this.isCheckImgList.length : 0;
        }
    },
    //定义的一些方法
    methods: {

        /**
         * 打开窗口
         */
        openWin() {
            this.dialogFormVisible = true;
        },

        /**
         * 关闭窗口
         */
        closeWin(){
            this.dialogFormVisible = false;
        },

        /**
         * 选择图片
         */
        onSelectedImg(imgData) {
            this.dialogFormVisible = false;

            if (imgData && imgData.length > 0) {
                //合并选择
                this.isCheckImgList = this.isCheckImgList.concat(imgData);
            }
            console.log("重选后：",this.isCheckImgList);
            if(this.onSelect) {
                return this.onSelect(this.isCheckImgList);
            }
        }
    }

});