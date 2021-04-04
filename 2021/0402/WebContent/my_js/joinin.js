$(function() {
  $('#join_submit').click(function () {
    alert('가입 성공!')
    location.href='./index.html'
  })

  $('#btn-id-check').click(function(){
    $.ajax({
      url:'./my_js/user_info.xml',
      type:'get',
      dataType:'xml',
      success:function(result){
        let used = false;
        $(result).find('user').each(function(idx, item){
          if($(this).find('id').text()==$('#join_id').val()){
            used = true;
          }
        })
        
        if(used){
          alert('이미 사용중인 아이디 입니다.');
        }else{
          alert('사용 가능합니다.')
        }
      }
    })
    
    return false;
  })

})