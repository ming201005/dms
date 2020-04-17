Vue.component('item', {
    template: '#item-template',
    props: {
        model: Object
    },
    data: function() {

    },
    computed: {

    },
    methods: {
        toggle(e){
            let li = e.target.nodeName == 'I' ? e.target.parentNode.parentNode : e.target.parentNode,
                clas = li.classList,
                bool = clas.contains('on');

            for( let _li of li.parentNode.children ){
                _li.classList.remove('on');
            }

            bool ? clas.remove('on') : clas.add('on');

            if( !bool ){
                const child = li.querySelectorAll('li');
                for( let _child of child ){
                    _child.classList.remove('on');
                }
            }

            tutorial.show( this.model );
            tutorial.toggleNav( this.model.id.value, this.model.parentid.value );

            e.stopPropagation();
        }
    }
});

let tutorial = new Vue({
    el: '#tutorial',
    data: {
        treeData: [], //所有数据
        current: null, // 当前查看数据

        title: '', // 标题
        gif: '', // 动图
        attention: '', // 注意事项,
        functional: '', // 内容

        isSearch: false, // 是否搜索
        searchList: [],

        prev: null, // 上一项
        next: null // 下一项
    },
    created() {
        this.getList();
    },
    methods: {
        getList() {
            this.$http
                .get('./api.php', {
                    params: {
                        url: '/App/Course/index?is_tree=1&website=1&order=createtime&by=0',
                        method: 'get',
                    }
                })
                .then(res => {
                    try {
                        const data = res.json();
                        if (data.code == 200 && data.data.list) {
                            this.treeData = data.data.list;
                            this.show( this.treeData[0] );

                            setTimeout(()=>{

                                //默认选中第一个
                                document.querySelector('ul.tutorial-ul > li:nth-child(1)').classList.add('on');

                                // 默认设置下一个
                                this.next = this.treeData[0]._child ? this.treeData[0]._child[0] : this.treeData[1];

                                // 初始化滚动条
                                $(".public-custom-scrollbar").mCustomScrollbar({
                                    autoHideScrollbar:true,
                                    theme:"minimal-dark"
                                });

                                this.getParam();

                                this.$el.classList.remove('hidden');

                            },1);
                        }

                    }catch( err ){
                        console.log(err);
                    }

                }, res => {

                });
        },

        show( data ){

            this.current = data;

            this.title = data.title.showvalue;
            this.gif = data.imguploadtsillau.value != "" ? data.imguploadtsillau.value[0].domain : '';
            this.attention = data.attention.value;
            this.functional = data.functional.value;
        },

        viewImage(){
            const   div = document.createElement('div'),
                    image = document.createElement('img'),
                    close = () => {
                        document.body.removeChild(div);
                    };

            div.className = 'mask pulse animated';

            image.className = 'mask-image';
            image.src = this.current.imguploadtsillau.value[0].domain;

            div.appendChild(image);
            document.body.appendChild(div);

            div.addEventListener('click', function(){
                close();
            }, false);
        },

        search(e){

            if( e.target.value.length > 0 ){

                this.searchList = [];

                const   that = this,
                        items = $(`ul.tutorial-ul span:contains(${e.target.value})`);

                $.each( items, function(){
                    that.searchList.push({
                        id: $(this).parent().data('id'),
                        pid: $(this).parent().parents('li').data('id'),
                        name: $(this).text()
                    });
                });

                this.isSearch = true;
            }else{
                this.isSearch = false;
            }
        },

        togglePage(e){
            const   el = e.target,
                    id = el.dataset.id,
                    pid = el.dataset.pid;

            this.toggleNav( id, pid );
        },

        toggleNav(id, pid){
            const   nav = [],
                    loops = ( child ) => {
                        for( let item of child ){
                            nav.push( item );
                            if( item._child ){
                                loops( item._child );
                            }
                        }
                    };
            loops( this.treeData );


            for( let i = 0; i < nav.length; i++ ){
                if( nav[i].id.value == id ){

                    this.show( nav[i] );
                    this.prev = i < 0 ? null : nav[i-1];
                    this.next = i > nav.length -1 ? null : nav[i+1];

                    $('li[data-id='+ id +']').addClass('on').siblings().removeClass('on');

                    // 一级菜单的时候删除同级样式
                    if( pid == 0){
                        $('li[data-id='+ id +']').find('li').removeClass('on');
                    }

                    if( pid > 0 ){
                        $('li[data-id='+ pid +']').addClass('on').siblings().removeClass('on');
                        $('li[data-id='+ pid +']').parents('li').addClass('on').siblings().removeClass('on');
                        $('li[data-id='+ id +']').find('li').removeClass('on');
                    }

                    break;
                }
            }

            this.isSearch = false;
        },

        getParam(){
            const search = location.search;
            if( search != '' ){
                const   params = search.replace('?','').split('&'),
                        id = params[0].split('=')[1],
                        pid = params[1].split('=')[1];
                this.toggleNav( id, pid );
            }
        }
    }
});