package tools;

import java.lang.reflect.Method;
import java.sql.*;

import function_gen.Function_gen;

public class Champ{
  String nom ;
  Boolean visible = true;
  String apparence;
  String defaultt = "";
  String libele;
  Boolean deroulante = false;
  Object liste = null;
  Boolean box = false;

  public Champ(){}
  public String getlibele(){
    return libele;
  }
  public void setLibele(String libele){
    this.libele = libele;
  }
  public String getDefault(){
    return defaultt;
  }
  public void setDefault(String defaultt){
    this.defaultt = defaultt;
  }
  public String getApparence(){
    apparence = "";
    if(visible==false){
      apparence = "hidden";
    }
    return apparence;
  }
  public void setApparence(String apparence){
    this.apparence = apparence;
  }
  public Champ (String nom){
    setName(nom);
    setLibele(nom);
  }
  public void setName(String nom){
    this.nom = nom;
  }
  public String getName(){
    return nom;
  }
  public Boolean getVisible(){
    return visible;
  }
  public void setVisible(Boolean tof){
    this.visible = tof;
  }
    public Boolean getDeroulante() {

    return this.deroulante;
    
    }
    
    public void setDeroulante(Boolean deroulante) {
    
      this.deroulante = deroulante;
    
    }
    
    public Object getListe() {
    
      return this.liste;
    
    }
    
    public void setListe(Object liste) {
    
      this.liste = liste;
    
    }
    public String getListederoul(Connection con)throws Exception{
      String html = "<tr><td><label for=\""+getName()+"\">"+getlibele()+"</label></td>";
      html += "<td><select name=\""+getName()+"\">";
      Class c = getListe().getClass();
      String nt = c.getName().substring(c.getName().indexOf(".")+1);
      Object[] objss = (new Function_gen()).select(con,nt);
      for(int i=0; i<objss.length; i++){

        Method meth = c.getMethod("getderoul");

        html += (String)meth.invoke(c.cast(objss[i]));
      }
      html += "</select></td></tr>";
      return html;
    }

    public String getCombobox(Connection con) throws Exception {
      String html = "<tr><td><label for=\""+getName()+"\">"+getlibele()+"</label></td>";
      html += "<td>";
      Class c = getListe().getClass();
      String nt = c.getName().substring(c.getName().indexOf(".")+1);
      Object[] objss = (new Function_gen()).select(con,nt);
      for(int i=0; i<objss.length; i++){

        Method meth = c.getMethod("getCombo");

        html += (String)meth.invoke(c.cast(objss[i]));
      }
      html += "</td></tr>";     
      return html;

    }

    public Boolean getBox() {

      return this.box;
      
    }
      
    public void setBox(Boolean box) {
      
      this.box = box;
      
    } 
}