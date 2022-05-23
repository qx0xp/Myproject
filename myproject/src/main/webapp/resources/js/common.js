$(function(){
    // 메뉴 버튼 클릭하면 side 보이기
    $(".h_menu").on("click", function(e){
        //스크롤 막기
        $('#wrap').on('scroll touchmove mousewheel', function(event){
            event.preventDefault(); event.stopPropagation();
            return false;
        })

        $(".side").animate({
            'right': 0
        })
    })

    // side_close 클릭 시, side 닫기
    $(".side_close").on("click", function(){
        $(".side").animate({
            'right': "-100%"
        })
        // 스크롤 막기 해제
        $('#wrap').off('scroll touchmove mousewheel');
    })
})