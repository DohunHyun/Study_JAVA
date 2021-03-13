$(function() {

  $('#profile_info_btn').click(function() {
    $.ajax({
      url:'./my_js/user_info.xml',
      type:'get',
      dataType:'xml',
      success:function(result){
        let success = false;
        let password = null;
        let name = null;
        let phone = null;
        let email = null;
        let address = null;
 
        $(result).find('user').each(function(idx, item){
          if($(this).find('id').text()==$('#profile_info_id').val()){
              success = true;
              password = $(this).find('password').text();
              name = $(this).find('user-name').text();
              phone = $(this).find('phone').text();
              email = $(this).find('email').text();
              address = $(this).find('address').text();
          }
        })
  
        if(success){
          let info = `<strong>PASSWORD: </strong><div id="profile_pwd">${password}</div>
          <strong>USER_NAME: </strong><div id="profile_name">${name}</div>
          <strong>PHONE: </strong><div id="profile_phone">${phone}</div>
          <strong>EMAIL: </strong><div id="profile_email">${email}</div>
          <strong>ADDRESS: </strong><div id="profile_address">${address}</div>
          <button id="modify_info" class="m-2">수정</button>`;
          $('#info').html(info);

          $('#modify_info').click(function() {
            let modify = `<form>
                            <div class="form-group">
                              <label for="modify_pwd">Password:</label>
                              <input type="password" class="form-control" placeholder="Enter password" id="modify_pwd">
                            </div>
                            <div class="form-group">
                              <label for="modify_name">Name:</label>
                              <input type="text" class="form-control" placeholder="Enter name" id="modify_name">
                            </div>
                            <div class="form-group">
                              <label for="modify_phone">Phone:</label>
                              <input type="text" class="form-control" placeholder="Enter phone" id="modify_phone">
                            </div>
                            <div class="form-group">
                              <label for="modify_email">Email address:</label>
                              <input type="email" class="form-control" placeholder="Enter email" id="modify_email">
                            </div>
                            <div class="form-group">
                              <label for="modify_address">address:</label>
                              <input type="text" class="form-control" placeholder="Enter address" id="modify_address">
                            </div>
                            
                            <button type="text" class="btn" id="modify_submit">수정하기</button>
                          </form>`;
            $('#info').html(modify);

            $('#modify_submit').click(function() {
              alert('수정 성공!');
              let info = `<strong>PASSWORD: </strong><div id="profile_pwd">${$(modify_pwd).val()}</div>
              <strong>USER_NAME: </strong><div id="profile_name">${$(modify_name).val()}</div>
              <strong>PHONE: </strong><div id="profile_phone">${$(modify_phone).val()}</div>
              <strong>EMAIL: </strong><div id="profile_email">${$(modify_email).val()}</div>
              <strong>ADDRESS: </strong><div id="profile_address">${$(modify_address).val()}</div>
              <button id="modify_info" class="m-2">수정</button>`;
              $('#info').html(info);
            })
          })

        }
      }
    })
  })
});