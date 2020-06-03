/**
 * 组件名称：resource-comm
 * 作用：资源管理组件
 *
 */

Vue.component('resource-comm', {
    template: `
    <div  v-loading="loading">
       <div style="display: flex;">
            <div class="leftCel">
                <div style="width: 180px;">  </div>
                <div class="tree">
                    <el-input  popper-class="my-autocomplete" class="treeButton" placeholder="搜索" v-model="searchImgName" clearable></el-input>
                    <el-button class="treeButton" slot="reference">所有类型</el-button>
                    <el-button class="treeButton" v-for="(item,index) in resourceTypeData" slot="reference">{{item.resourceGroup}}</el-button>
                </div>
            </div>
            <div :class="rightCelClass">
                <div class="imgBox">
                    <!--循环显示图片-->
                    <div class="imgItem" v-for="(item,index) in imgList"
                         @mouseenter="enter(index)" @mouseleave="leave()">
                        <!--图片显示，用背景图的方式显示-->
                        <div class="imageShow"  @click="chooseData(index,item)"
                             :style="{'backgroundImage': 'url(' + BASE_IMG_URL+item.resourceName + ')'}">
                            <!--当被选中时，上边出现阴影遮住效果-->
                            <div :class="item.check?'selectCheck':''">
                                <div style="height: 20px;">
                                    <span   size="mini" @click="del(item)" class="el-icon-delete showHide" v-show="seen&&index==selectIndex"  ></span>
                                    <span   size="mini" @click="viewImg(BASE_IMG_URL+item.resourceName)" class="el-icon-view showHide" v-show="seen&&index==selectIndex" ></span>
                                </div>
                                <div class="nameSpan">{{item.resourceName}}</div>
                                <!--选中打钩效果-->
                                <div v-if="item.check==true">
                                    <img src="../../static/img/selectImg.png" style="position:absolute;top:50px;left:45px;">
                                </div>
                            </div>
                        </div>
                    </div>
        
                    <div v-if="page.current < page.pages && page.pages>1" style="width: 100%;height: 30px;line-height: 30px; text-align: center;cursor: pointer;">
                        <span @click="moreImg()">加载更多</span>
                    </div>
                </div>
            </div>
        </div>
        <div>
             <template>
                    <el-form :model="form" class="upFile">
                        <el-form-item  label="上传图片" :label-width="formLabelWidth">
                            <el-upload
                                    ref="upload"
                                    :action="upFileApiUrl"
                                    accept="image/png,image/gif,image/jpg,image/jpeg"
                                    :limit=limitNum
                                    multiple="true"
                                    show-file-list="false"
                                    :auto-upload="true"
                                    :on-exceed="handleExceed"
                                    :before-upload="handleBeforeUpload"
                                    :headers="token"
                                    :on-success="success">
                                <i class="el-icon-plus"></i>
                            </el-upload>
                            <el-dialog :visible.sync="dialogVisible">
                                <img width="100%" :src="dialogImageUrl" alt="">
                            </el-dialog>
                        </el-form-item>
        
                        <el-form-item v-if="fromPage" class="up_file_text">
                            <span class="text">还可以选 {{checkNumberMax-isCheckImgListLen}} 张, {{isCheckImgListLen}} / {{checkNumberMax}}</span>
                            <span style="margin-left: 50px;">
                            <el-badge :value="isCheckImgListLen" :max="checkNumberMax">
                                <el-button style="margin-bottom: 5px;"  type="primary" size="small" @click="selectedImg(isCheckImgList)">确定</el-button>
                            </el-badge>
                            <el-button size="small"  @click="close">取消</el-button>
                            </span>
                        </el-form-item>
                    </el-form>
                 </template>
            </div>
    </div>
     
    `,
    props: {
        //显示
        dialogFormVisible: false,
        //页面来源
        fromPage: null,
        //允许选中章数
        checkNumberMax: 1,
        //已经选中的张数
        hashCheckNum: 0,
        //选中后
        onSelectedImg: {
            type: Function,
            default: null
        }
    },
    data() {
        return {
            //设置token，因为el-upload设置token方式不一样。
            token: {[Auth.USER_AUTH_KEY]: token},
            fromPage: "",
            //数据加载
            loading: true,
            //上传相关
            dialogImageUrl: '',
            dialogVisible: false,
            formLabelWidth: '80px',
            //默认的样式
            rightCelClass:["rightCel","rightCelHeightInPage"],
            //限制每次上传张数
            limitNum: 10,
            form: {},
            //上传附件提交地址（上传附件api）
            upFileApiUrl: global_api_url + "resource/upload",
            //图片显示
            imgList: [],
            //图片类型
            resourceTypeData: [],

            seen: true,

            //搜索关键字
            searchImgName: "",

            //分页相关,默认
            page: {
                current: 1,
                pages: 0,
                size: 24,
            },

            //
            selectIndex: 0,
            //已经选中的图片列表
            isCheckImgList: [],
            //初始化已选图片个数
            isCheckImgListLen: 0

        }
    },

    //初始加载数据
    created() {
        if (this.dialogFormVisible) {
            console.log("created............")
            this.imgList = [];
            this.loadData();
        }
    },

    //监听如果窗口被打开，再去重新加载数据
    watch: {
        //监听dialogFormVisible的值，如果有编号，且属于打开状态，则重新去加载数据。
        dialogFormVisible() {
            if (this.dialogFormVisible) {
                this.imgList = [];
                console.log("watch............")
                this.loadData();
            }
        },
    },

    methods: {


        /**
         * 初始化
         */
        loadData() {

            console.log("load Data.........", "this.fromPage===>", this.fromPage);
            //加载商品分类
            App.getBaseListApi(global_api_url + "resourceType", data => this.resourceTypeData = data);

            //如果是通过按钮弹窗来的。
            if (this.fromPage) {
                //超过窗体出现滚动
                this.rightCelClass = ["rightCel","rightCelHeightInWin"];
                //
                this.selectIndex = 0
                this.isCheckImgListLen = 0;
                //已经选中的图片列表(在父窗口也定义了一个这样的变量)
                this.isCheckImgList = []

                //初始化已选图片个数
                if (this.hashCheckNum> 0) {
                    this.isCheckImgListLen = this.hashCheckNum;
                }

                this.page.size = 12;
            }

            //默认加载文件
            this.getPicList();

        },

        /**
         * 查询图片
         */
        getPicList() {

            let apiURL = global_api_url + "resource?size=" + this.page.size + "&current=" + this.page.current;

            //调用ajax取数据
            axios.get(apiURL).then(rs => {
                //结果
                console.log("getPicList==>", rs);
                //
                if (rs.data.code == 0) {
                    rs = rs.data;
                    //列表
                    let fileData = rs.data.records;

                    //_this.imgList = fileData;
                    //合并
                    this.imgList = this.imgList.concat(fileData);
                    //分页
                    this.page = {
                        current: rs.data.current,
                        pages: rs.data.pages,
                        size: rs.data.size,
                        total: rs.data.total
                    };
                    //加载完毕
                    this.loading = false;
                } else {
                    this.$message.error("错误消息：" + rs.data.msg);
                }
            }).catch(e => {
                alert(e);
            });

        },

        /**
         * 加载更多照片
         */
        moreImg() {
            //如果页数还可以翻，就可以点
            console.log("more被点击===>", this.page);
            //当前页要小于总页数
            if (this.page.current < this.page.pages) {
                //页数+1
                this.page = {
                    current: this.page.current + 1,
                    pages: this.page.pages,
                    size: this.page.size
                };

                //加载数据
                this.getPicList();
            } else {
                console.log("已经翻到底了");
            }
        },

        /**
         * 选择图片
         */
        chooseData(index, row) {
            //如果独立打开，不做图片选择操作。
            if (this.fromPage==undefined) return;

            //选中了
            if (!row.check) {
                //允许选择的范围内，继续选择
                if (this.isCheckImgListLen < this.checkNumberMax) {
                    row.check = true;
                    //更新图片列表数组数据
                    this.imgList.splice(index, 1, row);
                    //新增到选中的图片
                    this.isCheckImgList.push(row);
                    this.isCheckImgListLen++;
                } else {
                    this.$message.error("最多只允许选[" + this.checkNumberMax + "]张");
                }
            } else {
                //更新图片列表数组数据
                row.check = false;
                this.imgList.splice(index, 1, row);
                //根据id删掉
                App.delFileById(row, this.isCheckImgList);
                this.isCheckImgListLen--;
            }
            console.log("已选中：", this.isCheckImgList);
        },

        /**
         * 鼠标进入图上方
         */
        enter(index) {
            console.log("enter....")
            this.seen = true;
            this.selectIndex = index;
        },

        /**
         * 鼠标离开
         */
        leave() {
            console.log("leave....")
            this.seen = false;
            this.selectIndex = null;
        },

        /**
         * 上传文件之前的钩子
         */
        handleBeforeUpload(file) {
            console.log('before');
            //文件大小
            let size = file.size / 1024 / 1024 / 2;
            let imgType = ['image/png', 'image/gif', 'image/jpg', 'image/jpeg'];
            //查找并返回true/false
            let f = imgType.find(item => item === file.type);
            if (!f) {
                //提示
                this.$notify.warning({
                    title: '警告',
                    message: `请上传格式为"${imgType.toString()}"的图片`
                });
            }

            //控制大小
            if (size > 10) {
                this.$notify.warning({
                    title: '警告',
                    message: '图片大小必须小于10M'
                });
            }
        },

        /**
         *文件超出个数限制时的钩子
         */
        handleExceed(files, fileList) {
            //let that = this;
            this.$notify.warning({
                title: '警告',
                message: '已经超出了(' + this.limitNum + ')张图片!'
            });
        },

        /**
         * 文件上传成功，更新图片列表
         */
        success(response, file, fileList) {
            console.log(response, file, fileList, this.imgList);
            if (response != "") {
                console.log("success....");
                this.imgList.push(response);
            } else {
                console.log("err....");
            }
        },

        /**
         * 删除图片
         */
        del(row) {
            let delFile = row;
            let id = delFile.id;
            let fileName = delFile.resourceName;

            //console.log(delFile,id, fileName);
            //apiURL
            let apiURL = global_api_url + "resource/deleteFile?idList=" + id + "&fileName=" + fileName;
            //删除服务端数据
            axios.delete(apiURL).then(rs => {
                rs = rs.data();
                if (rs.data.code == 0) {
                    //查找并返回下标
                    let findIndex = this.imgList.findIndex(item => item.id === id);
                    // 然后删除
                    App.delFileById(findIndex, this.imgList);
                    this.$message.success("删除成功！");

                    //方案2：遍历查找并删除客户端的数据
                    /*
                    for (let index  in this.imgList) {
                        //删除
                        if (this.imgList[index].id==id) {
                            this.imgList.splice(index, 1);
                            App.delFileById(this.imgList[index], this.imgList);
                            this.$message.success("删除成功！");
                            break;
                        }
                    }
                    */
                } else {
                    this.$message.error("错误消息：" + rs.message);
                }
            }).catch(e => {
                alert(e);
            });
        },

        //显示大图
        viewImg(itemPath) {
            document.location.href = itemPath;
        },

        /**
         * 选中图片后的处理
         * @param imgList
         */
        selectedImg(imgList) {

            if (this.onSelectedImg) {
                this.onSelectedImg(imgList);
            }
        },

        /**
         * 关闭窗口
         */
        close() {
            //让父组件执行关闭
            this.$emit('close-win');
        }
    }
})