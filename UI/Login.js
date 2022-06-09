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
                    
                    $('#div5').text(msg);
                },
                error:function(err)
                {
                    msg=err.responseText;
                    $('#div5').text(msg);
                }
            })   
            
});
});