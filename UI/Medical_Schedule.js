
            var msg="";
        
            var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var pobj = {
                "email": usersDataString
            }
            console.log(pobj.email);


         $.ajax({
                url:'http://localhost:8080/medicalhistory/'+pobj.email.replace(/['"]+/g, ''),
                dataType:'json',
                data:JSON.stringify(pobj),
                type:'post',
                contentType:'application/json',
                success:function(Record)
                {
                    console.log(Record);  
                    dis(Record);
                     
                },
                error:function(err)
                {
                    console.log(Record);
                    dis(Record);
                    
                }
            });  
            function dis(ls){
                var msg="<table>";
                    msg=msg+"<tr><th>Illness&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Doctor Details&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Medicine&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Start Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th></th><th>End Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Dosage Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Dosage Frequency&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Dosage Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th></tr>";
                    for(var i=0;i<ls.length;i++){
                        var startdate = ls[i].start_date.split(" ");
                        var enddate = ls[i].end_date.split(" ");
                        msg=msg+"<tr><td>"+ls[i].illness+"</td>"+"<td>"+ls[i].doctor_details+"</td>"+"<td>"+ls[i].medicine_details+"</td><td>"+startdate[0]+"</td><td>"+enddate[0]+"</td><td>"+ls[i].dosage_amount+"</td><td>"+ls[i].doasge_feq+"</td><td>"+ls[i].dosage_time+"</td></tr>";
                    };
                    msg=msg+"</table>";
                document.getElementById("div1").innerHTML=msg;
                console.log(msg);
            }


            var usersDataint = sessionStorage.getItem("usersDataid");
            console.log(usersDataint);
            
            $('#mydeplist').change(function(){
                console.log($('#mydeplist1').val());
                var n=1;
                var msg="";
                
                var obj={
                        "user_id":usersDataint,
                        "relationship":$('#mydeplist1').val(),          
                    
                };
                $.ajax({
                    url:'http://localhost:8080/viewmedicalhis',
                    dataType:'json',
                    data:JSON.stringify(obj),
                    method:'post',
                    contentType:'application/json',
                    success:function(Record)
                    { 
                        $.each(Record, function (key, value) {
                            n=0;
                            dis(Record);
                            
                    
                          
                    });
                    
                    
                    
                    if(n==1){
                
                            msg="Data not added.Please add Data";
                    alert(msg);
                    }
                    
                        
                    
                    
                }
            
            
        
            
                
        
              });
            });