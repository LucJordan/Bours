<%@page import="tools.*,donnee.*,connexion.*,java.sql.*"%>
<%
	String html = "";
    html += (new Function()).getFormulaireOrdre((String)session.getAttribute("client_id"),request.getParameter("type"));
%>
<!DOCTYPE HTML>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" width="device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="main.css" rel="stylesheet" type="text/css">
	<title><% out.println((new Function()).getTitreOrdre(request.getParameter("type"))); %></title>
</head>
<body>
    <div class="container">
        <% out.println(html); %>
        <% out.println(session.getAttribute("client")); %>
        <% out.println(session.getAttribute("client_id")); %>
		<% out.println((new Function()).getLien_session((new Function()).getTypeSession(session.getAttribute("client"),session.getAttribute("brocker"),session.getAttribute("admin")))); %>
    </div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>