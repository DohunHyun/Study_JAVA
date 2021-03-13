$(function() {
  let login_success = false;

  $('#submit_login').click(function() {
    $.ajax({
      url:'./my_js/user_info.xml',
      type:'get',
      dataType:'xml',
      success:function(result){
        let success = false;
        $(result).find('user').each(function(idx, item){
          if($(this).find('id').text()==$('#login_id').val()){
            if($(this).find('password').text()==$('#login_pwd').val()){
              success = true;
            }
          }
        })

        if(success){
          alert('로그인 성공');
          login_success = true;
          location.href='./profile.html'
        }else{
          alert('로그인 실패')
          login_success = false;
        }
      }
    })
    return false;
  });

  $('#find_pwd').click(function() {
    $.ajax({
      url:'./my_js/user_info.xml',
      type:'get',
      dataType:'xml',
      success:function(result){
        let success = false;
        let pwd = null;
        $(result).find('user').each(function(idx, item){
          if($(this).find('id').text()==$('#login_id').val()){
            success = true;
            pwd = $(this).find('password').text();
          }
        })

        if(success){
          alert("비밀번호: " + pwd);
        }else{
          alert('아이디 없음')
        }
      }
    })
    return false;
  });

});