$(document).ready(function() {
    $('#resetpassword').click(function(){ 
        var valid=1; 
                if ($("#newpassword1").val() != $("#newpassword2").val()) {
                    alert("Passwords do not match.");
                    document.getElementById('Oldpassword').value="";
                    document.getElementById('newpassword1').value="";
                    document.getElementById('newpassword2').value="";
                    valid=0; 
                }else if ($("#Oldpassword").val() == $("#newpassword1").val()) {
                    alert("Old password can not be same.");
                    document.getElementById('Oldpassword').value="";
                    document.getElementById('newpassword1').value="";
                    document.getElementById('newpassword2').value="";
                    valid=0; 
                }
            
            if(valid==1){
                
            var msg="";
        
            var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var usersData = JSON.parse(usersDataString);
            console.log(usersData);
            document.write(usersData);
            var pobj={
                "email" : "vishal@gmail.com",
                "password":$('#Oldpassword').val(),
                "newPassword":$('#newpassword2').val()
                
            };
            
            $.ajax({
                url:'http://localhost:8080/reset_password',
                dataType:'json',
                data:JSON.stringify(pobj),
                type:'post',
                contentType:'application/json',
                success:function(Record)
                {
                    msg=Record.responseText;
                    alert(msg);
                    window.location.href="Login.html";
                },
                error:function(err)
                {
                    
                    msg=err.responseText;
                    if(msg == "Password Reset Successful"){
                        window.location.href="Login.html";
                        }
                    alert(msg);
                }
            })   
            console.log(document.getElementById('Oldpassword').value+document.getElementById('newpassword2').value);
            document.getElementById('Oldpassword').value="";
            document.getElementById('newpassword1').value="";
            document.getElementById('newpassword2').value="";
          
        } 
});
});