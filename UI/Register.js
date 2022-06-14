$(document).ready(function() {
    $('#b').click(function(){ 
        var valid=1;

        
                
                if ($("#password1").val() != $("#password2").val()) {
                    alert("Passwords do not match.");
                    valid=0;
                }

                if($('#email_id').val() == null || $('#email_id').val() == ""){
                    alert("Email is Required.");
                    valid=0;
                }else if($('#password1').val() == null || $('#password1').val() == ""){
                    alert("Password is Required.");
                    valid=0;
                }else if($('#country').val() == null || $('#country').val() == ""){
                    alert("Country is Required.");
                    valid=0;
                }else if($('#name').val() == null || $('#name').val() == ""){
                    alert("Name is Required.");
                    valid=0;
                }else if($('#contact').val() == 0 || ($('#contact').val()).length < 10){
                    alert("Contact is Required.");
                    valid=0;
                }else if($('#dob').val() == null || $('#dob').val() == ""){
                    alert("Date of Birth is Required.");
                    valid=0;
                }
            
        
            if(valid==1){
                /*alert(document.getElementById("email_id").value+" "+document.getElementById("name").value+" "+document.getElementById("contact").value+" "+document.getElementById("dob").value+" "+document.getElementById("password1").value);*/
            var msg="";
        
            
            var pobj={
                "email":$('#email_id').val(),
                "password":$('#password1').val(),
                "country":$('#country').val(),
                "name":$('#name').val(),                
                "contact":$('#contact').val(),
                "dob":$('#dob').val(),                
                
            };
            
           
            $.ajax({
                url:'http://localhost:8080/register',
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
                    alert(msg);
                    if(msg == "Registered Successfully"){
                        window.location.href="Login.html";
                        }
                }
            }) 
            document.getElementById('email_id').value="";
            document.getElementById('password1').value=""; 
            document.getElementById('contact').value="";
            document.getElementById('country').value="";
            document.getElementById('dob').value="";
            document.getElementById('name').value="";
            document.getElementById('password2').value=""; 
        } 
});
});