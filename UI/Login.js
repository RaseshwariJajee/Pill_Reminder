$(document).ready(function() {
    $('#b').click(function(){ 
            var msg="";
            
            var pobj={
                "email":$('#email_id').val(),
                "password":$('#password').val()
            };
            
           
            $.ajax({
                url:'http://localhost:8080/login',
                dataType:'json',
                data:JSON.stringify(pobj),
                type:'post',
                contentType:'application/json',
                success:function(Record)
                {
                    msg=Record.responseText;
                    alert(msg);
                    var testObject = document.getElementById("email_id");
                    localStorage.setItem('testObject',testObject);

                    window.location.href="ResetPassword.html";
                },
                error:function(err)
                {
                    msg=err.responseText;
                    alert(msg);
                    if(msg == "Login Successful"){
                        var testObject = document.getElementById("email_id");
                        localStorage.setItem('testObject', testObject);

                        window.location.href="ResetPassword.html";
                        }
                     
                }
            })   
            
            document.getElementById("email_id").value="";
            document.getElementById("password").value="";
            
});
});