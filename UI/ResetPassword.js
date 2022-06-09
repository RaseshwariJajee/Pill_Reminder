$(document).ready(function() {
    $('#resetpassword').click(function(){ 
        var valid=1; 
                if ($("#newpassword1").val() != $("#newpassword2").val()) {
                    alert("Passwords do not match.");
                    valid=0;

                    
                }
            
            if(valid==1){
                
            var msg="";
        
            
            var pobj={
                "password":$('#newpassword2').val(), 
            };
            console.log(document.getElementById('resetpassword').value);
            document.getElementById('Oldpassword').value="";
            document.getElementById('newpassword1').value="";
            document.getElementById('newpassword2').value="";
          
        } 
});
});