<%@page import="tools.*,donnee.*,function_gen.*,connexion.*,java.sql.*,function.*"%>
<%
	String txt = (new Function()).lister();
%>

<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" width="device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet" type="text/css">
	<title>Tableau de cotation</title>
</head>
<body>

	<div class="container">
        <% out.println(new Function().getTabCotation()); %>
		<% out.println((new Function()).getLien_session((new Function()).getTypeSession(session.getAttribute("client"),session.getAttribute("brocker"),session.getAttribute("admin")))); %>
	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>