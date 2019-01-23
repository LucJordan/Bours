<%@page import="tools.*,donnee.*,function_gen.*,connexion.*,java.sql.*"%>

<%

%>
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

	<div class="container">
		<%
			if(session.getAttribute("client")==null && session.getAttribute("brocker")==null && session.getAttribute("admin")==null){
            	response.sendRedirect("ejectee.jsp");
			}
			String msg = "<h2>Bienvenu "+(new Function()).getNotNull(session.getAttribute("client"),session.getAttribute("brocker"),session.getAttribute("admin"))+"</h2>";
			msg += "[" + (new Function()).getTypeSession(session.getAttribute("client"),session.getAttribute("brocker"),session.getAttribute("admin")) + "]";
			out.println(msg);
		%>

		<% out.println((new Function()).getLien_session((new Function()).getTypeSession(session.getAttribute("client"),session.getAttribute("brocker"),session.getAttribute("admin")))); %>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>