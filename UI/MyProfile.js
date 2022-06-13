
        
var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var pobj = {
                "email": usersDataString
            }
            $(document).ready(function() {
                
                
                
     
     $.get("http://localhost:8080/profile/"+pobj.email.replace(/['"]+/g, ''), function(data) {     
        
        
        
        $('#div2').text(data);     
       
       $.each(data, function (key, value) {
        
        var dob1=value.dob.split(" ");
        $('#name').val(value.name);
        $('#email').val(value.email);
        $('#contact').val(value.contact);
        $('#blood_group').val(value.blood_group);
        $('#dob').val(dob1[0]);
        $('#weight').val(value.weight);
        $('#height').val(value.height);
      
});
           
      });
      $('#1b').click(function(){ 
        var msg="";
        
        var obj={
                "name":$('#name').val(),
                "email":$('#email').val(),
                "contact":$('#contact').val(),
                "blood_group":$('#blood_group').val(),
                "dob":$('#dob').val(),
                "weight":$('#weight').val(),
                "height":$('#height').val()
            
        };
        
        $.ajax({
            url:'http://localhost:8080/profile',
            dataType:'json',
            data:JSON.stringify(obj),
            type:'put',
            contentType:'application/json',
        
            success:function(Record)
            {
                msg=Record.responseText;
                alert(msg);
                
            },
            error:function(err)
            {
                msg=err.responseText;
                alert(msg);
                
            }
            
        })



});
    
     
});

const image = document.querySelector('.image');
const hover = document.querySelector('.hover');
const modal = document.querySelector('.modal');
const close = document.querySelector('.close');

