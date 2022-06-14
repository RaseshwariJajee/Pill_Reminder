var msg="";
        

        
var usersDataString = sessionStorage.getItem("usersData");
            console.log(usersDataString);
            var idobj = {
                "email": usersDataString
            }


$.ajax({
    url:'http://localhost:8080/home',
    dataType:'json',
    type:'get',
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

$.ajax({
    url:'http://localhost:8080/iduser/'+idobj.email.replace(/['"]+/g, ''),
    dataType:'json',
    data:JSON.stringify(idobj),
    type:'post',
    contentType:'application/json',
    success:function(Record)
    {
        console.log(Record); 
        sessionStorage.setItem("usersDataid", JSON.stringify(Record)); 
        
         
    },
    error:function(err)
    {
        console.log(Record);
        sessionStorage.setItem("usersDataid", JSON.stringify(Record));
        
    }
});  


function dis(ls){
    var msg="<table>";
        msg=msg+"<tr><th>Medicine&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Dosage Amount&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Dosage Time&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th></tr>";
        for(var i=0;i<ls.length;i++){
            var startdate = ls[i].start_date.split(" ");
            var enddate = ls[i].end_date.split(" ");
            var freq = ls[i].doasge_feq;
            $('#time').text(startdate[0]);
           // while(freq > 0){
                msg=msg+"<tr><td>"+ls[i].medicine_details+"</td><td>"+ls[i].dosage_amount+"</td><td>"+ls[i].dosage_time+"</td></tr>";
          //      freq--;
            //}
        };
        msg=msg+"</table>";
    document.getElementById("div1").innerHTML=msg;
    console.log(msg);
}

