<%@page import="tools.*"%>

<%
    String msg = "";
    try{
        Boolean x = (new Function()).check_log_brocker(request.getParameter("login"),request.getParameter("pwd"));
        if(x){
            session.setAttribute("brocker",request.getParameter("login"));
            response.sendRedirect("index.jsp");
        }
    }catch(Exception e){
        msg += e.getMessage();
        //throw e;
    }
%>

<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" width="device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet" type="text/css">
	<title>Connection Brocker</title>
</head>
<body>

	<div class="container">
        <% out.println((new Function()).get_log_brocker()); %>
        <% out.println(msg); %>
    </div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>