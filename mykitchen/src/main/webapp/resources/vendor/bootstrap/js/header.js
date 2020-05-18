$(document).ready(function(){
    $(".dropbtn, #dropdown").hover(function(){
        $("#dropdown").show();
    }, function(){
        $("#dropdown").hide();
    });

    $(document).scroll(function(){
        console.log(window.pageYOffset);
        if(window.pageYOffset>120){
            $("nav").css({"position":"fixed", "top":"0px"});
            //$("#dropdown").css({"position":"fixed", "top":"50px", "left":"0"})
            
            $(".swiper-1").animate({
                opacity : '0.4'
            });
            
        }else{
            $("nav").css({"position":"absolute", "top":"120px"});
            //$("#dropdown").css({"position":"absolute", "top":window.pageYOffset+170+"px"});
            
            $(".swiper-1").stop(true);
            $(".swiper-1").css({"opacity":"1"});
            
        }
    });
});
