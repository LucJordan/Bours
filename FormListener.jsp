<%@ page import="function_gen.*,donnee.*,tools.*,connexion.*,java.lang.reflect.*,java.sql.*" %>
<%
DBConnection dbh =  new DBConnection();
Connection con = dbh.getConnnection();
try{
  Class c = Class.forName("donnee."+request.getParameter("class"));
  Object myClass = c.newInstance();
  String[] lesChamps = new Formulaire().getFieldString(myClass);
  String[] values = new String[lesChamps.length];
  for(int i=0; i < values.length; i++){
    values[i] = request.getParameter(lesChamps[i]);
  }
  if(request.getParameter("colone") == null){
    (new Cible()).action(request.getParameter("class"), myClass, con, values);
    out.println(request.getParameter("class")+" ajoutee");
  }else{
    (new Cible()).actionup(request.getParameter("class"), myClass, con, values,request.getParameter("colone"),request.getParameter("valeur_colonne"));
    out.println(request.getParameter("class")+" updated");
  }

}
catch(java.lang.reflect.InvocationTargetException e){
  if(e.getCause().getMessage().indexOf("For input string:")!=-1){
    String msg = "veuillez remplir tout les champs ou les donnes entree sont incompatibles";
    msg += (new Function()).boutongoback();
    out.println(msg);
  }
  else{
    out.println(e.getCause().getMessage());
  }
  //throw e;
}
catch(Exception e){
  out.println(e.getMessage());
  //throw e;
}
finally{
  con.close();
}
%>