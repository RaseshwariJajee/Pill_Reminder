
        
var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var pobj = {
                "email": usersDataString
            }
            $(document).ready(function() {
                
                
                
     
     $.get("http://localhost:8080/profile/"+pobj.email.replace(/['"]+/g, ''), function(data) {     
        alert(data);
        console.log(data);
        
        $('#div2').text(data);         
      });
    
     
});

const image = document.querySelector('.image');
const hover = document.querySelector('.hover');
const modal = document.querySelector('.modal');
const close = document.querySelector('.close');

