<%@ page import="function_gen.*,donnee.*,tools.*,connexion.*,java.lang.reflect.*,java.sql.*" %>
<%
String msg = "";
try{
    (new Function()).confirmOrdre(request.getParameter("idOrdre"));
    out.println("confirmee!"+(new Function()).boutongoback());
    response.sendRedirect("ordre_confirm.jsp");
}
catch(Exception e){
  out.println(e.getMessage()+""+(new Function()).boutongoback());
  //throw e;
}
%>
