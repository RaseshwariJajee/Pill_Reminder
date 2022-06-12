            var msg="";
        
            var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var pobj = {
                "email": usersDataString
            }
            
            $.ajax({
                url:'http://localhost:8080/medicalhistory',
                dataType:'json',
                data:JSON.stringify(pobj),
                type:'post',
                contentType:'application/json',
                success:function(Record)
                {
                     console.log(Record);  
                     
                },
                error:function(err)
                {
                    console.log(Record);
                    
                }
            });  
        