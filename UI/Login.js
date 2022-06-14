$(document).ready(function() {
    $('#b').click(function(){ 
            var msg="";
            
            var pobj={
                "email":$('#email_id').val(),
                "password":$('#password').val()
            };
            
            if(pobj.email == null || pobj.email == ""){

                document.getElementById("email_id").value="";
                document.getElementById("password").value="";
                alert("Email Required.");  
            }else if(pobj.password == null || pobj.password == ""){

                document.getElementById("email_id").value="";
                document.getElementById("password").value="";
                alert("Password Required.");  
            }else if(password.length<6){  
                document.getElementById("email_id").value="";
                document.getElementById("password").value="";
                alert("Password must be at least 6 characters long.");  
                
            }else{
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
                        sessionStorage.setItem("usersData", JSON.stringify(pobj.email));
                        window.location.href="Home.html";
                    },
                    error:function(err)
                    {
                        msg=err.responseText;
                        alert(msg);
                        if(msg == "Login Successful"){
                            sessionStorage.setItem("usersData", JSON.stringify(pobj.email));
                            window.location.href="Home.html";
                            }
                         
                    }
                })   
                document.getElementById("email_id").value="";
                document.getElementById("password").value="";
            }       
            
});
});