$(function(){
    $('#btn_login').on('click', function(){ // login start
        let userId = prompt('아이디를 입력하세요.');
        let userPw = prompt('패스워드를 입력하세요.');
        
        if(userId == 'ssafy' && userPw == '1234') {
            alert('login success!');
            $('#before_login').removeClass('visible').addClass('invisible');
            $('#after_login').removeClass('invisible').addClass('visible');

            $('profile_img_before').css('display', 'none');
            $('profile_img_after').css('display', '');

        }
    }) // login end

    $('#store_all_open').click(function(){
        $('.store_item_sub').removeClass('invisible').addClass('visible');
        $(this).removeClass('visible').addClass('invisible');
        $('#store_all_close').removeClass('invisible').addClass('visible');
    })

    $('#store_all_close').click(function(){
        $('.store_item_sub').removeClass('visible').addClass('invisible');
        $(this).removeClass('visible').addClass('invisible');
        $('#store_all_open').removeClass('invisible').addClass('visible');
    }) // 지역 전체 닫기 예약 완료 

    $('.store_area').click(function(){
        if($(this).siblings('.store_item_sub').hasClass('invisible')) {
            $(this).siblings('.store_item_sub')
            .removeClass('invisible')
            .addClass('visible');
        } else {
            $(this).siblings('.store_item_sub').removeClass('visible').addClass('invisible');
        }
    }) // 각 지역 눌렀을 때 토글 예약 완료 

    $('.menu_item').click(function() {
        var src = $(this).find('img').attr('src');
        $('.img_big').attr('src', src);
    })

})