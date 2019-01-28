<%@ page import="function_gen.*,donnee.*,tools.*,connexion.*,java.lang.reflect.*,java.sql.*" %>
<%
String msg = "";
try{
    (new Function()).conclure((String)session.getAttribute("brocker_id"),request.getParameter("idMyOrdre"),request.getParameter("idOrdreProposition"));
    if((new Function()).check_conclud_2cotes(request.getParameter("idMyOrdre"),request.getParameter("idOrdreProposition"))){
        (new Function()).transaction(request.getParameter("idMyOrdre"),request.getParameter("idOrdreProposition"));
    }
    response.sendRedirect("ordre_conclure.jsp");
}
catch(Exception e){
  out.println(e.getMessage()+""+(new Function()).boutongoback());
  throw e;
}
%>
