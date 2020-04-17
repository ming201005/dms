/**
 * Created by Administrator on 2016/4/28.
 */

TweenMax.selector = $;

function effect(){
    var s = $(".screen").eq(1), imgs = s.find(".gallery img");

    var angle = 360 / (imgs.length - 1), a = 0, x = 0, y = 0, r = 170;
    TweenMax.staggerTo(imgs.slice(0, imgs.length - 1), 0.3, {
        cycle:{
            left: function(i){
                return -(x + Math.sin(2 * Math.PI / 360 * i * angle) * r);
            },
            top: function(i){
                return -(y + Math.cos(2 * Math.PI / 360 * i * angle) * r);
            }
        }
    }, 0.08);
}

function completeHandler(idx){
    if (idx == 1){
        $('.earth_img').addClass('cilr_ring');
        $('.content_earth .conmg').addClass('debris_show');
        $('.content_earth .min_icon').addClass('debris_show');
        $('.screen_scroll2 .map_line').addClass('debris_show');
    }else if (idx == 2){
        $('.mobile_temp').addClass('anim_tele');
        $('.screen_scroll3 .bor_cilr1').addClass('animate_circulbig');
        $('.screen_scroll3 .bor_cilr').addClass('animate_circulbig');
        $('.screen_scroll3 .bor_cilr1 .cont,.screen_scroll3 .bor_cilr .cont').addClass('debris_show');
        $('.screen_scroll3 .cont_cilr').addClass('debris_show');
     }else if (idx ==4) {
    }else if (idx ==3) {
        $('.expert_descr .te_se').addClass('anim_tele');
        $('.shows_leal .imggshadow').addClass('anim_shadow');
        $('.per_tou').addClass('anim_tele');
       
       
     
    }else if (idx ==5) {
       
    }
}
function initEvents(){
    var screenWrap = $(".screen_wrap"),
        screens = screenWrap.find(".screen"),
        screenControl = $(".screen_control"),
        controls = screenControl.find("li"),
        arrow = $(".arrow"),
        wrap = $(".wrap"),
        tMax = null,
        offsetonw = $('.screen_scroll2');
  
    // 全屏滚动切换效果
    $(document).on("mousewheel", function(e){
        if (tMax && tMax.isActive()) return false;

        var active = screenWrap.find("> .active"),
            prev = active.prev(),
            next = active.next();

        if (e.deltaY > 0){
            if (prev.length){
                active.removeClass("active");
                prev.addClass("active");
                controls.removeClass("active").eq(prev.index()).addClass("active");
                tMax = TweenMax.to(".screen_wrap", 0.8, {top: "+=100%", ease:Expo.easeOut, onComplete: function(){
                completeHandler(prev.index());
                }});
            }
          
        }else{
            if (next.length){
                active.removeClass("active");
                next.addClass("active");
                controls.removeClass("active").eq(next.index()).addClass("active");
                tMax = TweenMax.to(".screen_wrap", 0.8, {top: "-=100%", ease:Expo.easeOut, onComplete: function(){
                    completeHandler(next.index());
                }});
            }
            
        }
    });
    screenControl.on("click", "li", function(e){
        var idx = $(this).index(),
            top = -(idx * 100) + "%";
        screens.removeClass("active").eq(idx).addClass("active");
        controls.removeClass("active");
        $(this).addClass("active");
        tMax = TweenMax.to(".screen_wrap", 0.8, {top: top, ease:Expo.easeOut, onComplete: function(){
            completeHandler(idx);
        }});
       
    });

    arrow.on("click", function(){
        if (tMax && tMax.isActive()) return false;

        var active = wrap.find(".active"),
            node = active.next(),
            idx = wrap.find(".wall").index(node);

        console.log(active, node, idx);

        tMax = TweenMax.to(wrap, 0.8, {right: -(idx * 100) + "%", ease:Expo.easeOut});
    });
}

$(function(){
    initEvents();

    $(".wall").each(function(){
        var wall = new Freewall(this);
        wall.reset({
            selector: ".item",
            cellW: 380,
            cellH: 570,
            gutterX: 20,
            gutterY: 20,
            onResize: function() {
                wall.fitWidth();
            }
        });
        wall.fitWidth();
    });
    //wall.fitWidth();
});