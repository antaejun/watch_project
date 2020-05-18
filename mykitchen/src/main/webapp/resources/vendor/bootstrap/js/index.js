$(document).ready(function(){
    
    //Swiper 생성
    var mySwiper = new Swiper('.swiper-1', {
        //파라미터
        speed: 400,
        loop: true,
        cssMode: false,
        autoplay: {
            delay: 3000,
            disableOnInteraction: false,
        },
        
        //페이지네이션
        pagination: {
            el: '.swiper-1 .swiper-pagination',
            clickable: true,
        },
        //네비게이션
        navigation: {
            nextEl: '.swiper-1 .swiper-button-next',
            prevEl: '.swiper-1 .swiper-button-prev',
        },
        //스크롤바
        /*
        scrollbar: {
            el: '.swiper-scrollbar',
        },
        */
    });

    
    var mySwiper = new Swiper('.swiper-2', {
        //파라미터
        speed: 400,
        loop: false,
        slidesPerView: 3,
        spaceBetween: 30,
        cssMode: false,
        
        //네비게이션
        navigation: {
            nextEl: '.swiper-2 .swiper-button-next',
            prevEl: '.swiper-2 .swiper-button-prev',
        },
        
    });
    
    var mySwiper = new Swiper('.swiper-3', {
        //파라미터
        speed: 400,
        loop: true,
        initialSlide: 0,
        slidesPerView: 5,
        slidesPerGroup: 3,
        spaceBetween: 10,
        cssMode: false,
        
        //네비게이션
        navigation: {
            nextEl: '.swiper-3 .swiper-button-next',
            prevEl: '.swiper-3 .swiper-button-prev',
        },
        
    });

    var mySwiper = new Swiper('.swiper-4', {
        //파라미터
        speed: 400,
        loop: true,
        cssMode: false,
        
        
        //네비게이션
        navigation: {
            nextEl: '.swiper-4 .swiper-button-next',
            prevEl: '.swiper-4 .swiper-button-prev',
        },
        //스크롤바
        /*
        scrollbar: {
            el: '.swiper-scrollbar',
        },
        */
    });

    var mySwiper = new Swiper('.swiper-6', {
        //파라미터
        speed: 400,
        initialSlide: 0,
        slidesPerView: 4,
        slidesPerGroup: 1,
        spaceBetween: 10,

        
        //페이지네이션
        pagination: {
            el: '.swiper-6 .swiper-pagination',
            type: 'progressbar',
        },

        //네비게이션
        navigation: {
            nextEl: '.swiper-6 .swiper-button-next',
            prevEl: '.swiper-6 .swiper-button-prev',
        },
        //스크롤바
        /*
        scrollbar: {
            el: '.swiper-scrollbar',
        },
        */
    });
});
