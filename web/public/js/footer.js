Vue.component('footer-item', {
    template:   `<div class="web-footer-wrap">
                    <span>
                        <span>版权所属 </span>
                        <span><a style="color: rgba(255,255,255,0.5);" target="_blank"
                                 href="http://www.miitbeian.gov.cn">渝ICP备17015243号-2</a></span>
                    </span>
                   
                    <div class="fixed-tips" :class="{ hide: isTop == 0 }">
                        <div class="tips-item">
                            <i class="tml-icon tml-QR-code"></i>
                            <div class="qr-box">
                                <img src="assets/img/help/wx.png" alt="小明哥微信">
                                <p>小明哥微信</p>
                            </div>
                        </div>
                        <div class="tips-item">
                            <a href="http://wpa.qq.com/msgrd?v=3&uin=272038088&site=qq&menu=yes" target="blank" class="tml-icon tml-Contact-cooperation"></a>
                        </div>
                        <div class="tips-item fixed-back-top hide">
                            <a class="tml-icon tml-Back-top"></a>
                        </div>
                    </div>
                </div>`,
    props: {
		isTop:null
	},
    data: {}
});

let footer = new Vue({
created(){
	const body = document.body,
		scripts = document.createElement('script');
		scripts.innerHTML = `
				var _hmt = _hmt || [];
				(function() {
				  var hm = document.createElement("script");
				  hm.src = "https://hm.baidu.com";
				  var s = document.getElementsByTagName("script")[0]; 
				  s.parentNode.insertBefore(hm, s);
				  console.log(hm)
				})();
				`;
		body.appendChild(scripts);
}
});