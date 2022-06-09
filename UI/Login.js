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
                    window.location.href="Register.html";
                },
                error:function(err)
                {
                    msg=err.responseText;
                    alert(msg);
                }
            })   
            document.getElementById("email_id").value="";
            document.getElementById("password").value="";
            
});
});