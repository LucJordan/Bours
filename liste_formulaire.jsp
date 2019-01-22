<%@page import="tools.*,donnee.*,connexion.*,java.sql.*"%>
<%
    String html = (new Function()).formuler();
%>
<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" width="device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet" type="text/css">
	<title>Liste de formulaire</title>
</head>
<body>
    <div class="container">
        <% out.println(html); %>
        <% out.println((new Function()).getLien()); %>
    </div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>