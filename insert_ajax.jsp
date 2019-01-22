<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" width="device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet" type="text/css">
	<title>Bourse</title>
</head>
<body>
<script>
function submitForm()
{ 
    var xhr; 
    try {  xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
    catch (e) 
    {
        try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
        catch (e2) 
        {
           try {  xhr = new XMLHttpRequest();  }
           catch (e3) {  xhr = false;   }
         }
    }
  
    xhr.onreadystatechange  = function() 
    { 
       if(xhr.readyState  == 4)
       {
        if(xhr.status  == 200) 
            document.ajax.dyn="Received:"  + xhr.responseText; 
        else
            document.ajax.dyn="Error code " + xhr.status;
        }
    }; 
 
   xhr.open("GET", "data.xml",  true); 
   xhr.send(null); 
} 
</script>
	<div class="container">
		<% out.println((new Function()).getLien()); %>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>