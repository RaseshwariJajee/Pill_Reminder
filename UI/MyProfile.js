
        
var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var pobj = {
                "email": usersDataString
            }
            $(document).ready(function() {
                var id;
                
                
                
     
     $.get("http://localhost:8080/profile/"+pobj.email.replace(/['"]+/g, ''), function(data) {     
        
        
        
           
       
       $.each(data, function (key, value) {
        
        var dob1=value.dob.split(" ");
        $('#mydeplist').val(value.relationship);
        $('#name').val(value.name);
        $('#email').val(value.email);
        $('#contact').val(value.contact);
        $('#mybglist').val(value.blood_group);
        $('#dob').val(dob1[0]);
        $('#weight').val(value.weight);
        $('#height').val(value.height);
        id=value.id;

      
});

           
      });
      $('#mydeplist1').change(function(){
        var n=1;
        var msg="";
        
        var obj={
                "id":id,
                "relationship":$('#mydeplist1').val(),               
            
        };
        $.ajax({
            url:'http://localhost:8080/dependent',
            dataType:'json',
            data:JSON.stringify(obj),
            method:'post',
            contentType:'application/json',
            success:function(Record)
            { 
                $.each(Record, function (key, value) {
                    n=0;
        
                    var dob1=value.dob.split(" ");
                    $('#mydeplist').val(value.relationship);
                    $('#name').val(value.name);
                    $('#email').val(value.email);
                    $('#contact').val(value.contact);
                    $('#mybglist').val(value.blood_group);
                    $('#dob').val(dob1[0]);
                    $('#weight').val(value.weight);
                    $('#height').val(value.height);
                    
            
                  
            });
            
            
            
            if(n==1){
        
                    msg="Data not added.Please add Data";
            alert(msg);
            }
            
                
            
            
        }
    
    

    
        

      });
      $('#1b').click(function(){ 
        var msg="";
        
        var obj={
                "id":id,
                "relationship":$('#mydeplist').val(),
                "name":$('#name').val(),
                "email":$('#email').val(),
                "contact":$('#contact').val(),
                "blood_group":$('#mybglist').val(),
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
            });
function adddep(){
    $('#name').val("");
    $('#email').val("");
    $('#contact').val("");
    $('#mybglist').val("");
    $('#dob').val("");
    $('#weight').val("");
    $('#height').val("");
}

const image = document.querySelector('.image');
const hover = document.querySelector('.hover');
const modal = document.querySelector('.modal');
const close = document.querySelector('.close');

