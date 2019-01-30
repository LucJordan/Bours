package donnee;

import java.sql.*;
import tools.*;

public class Payement_brocker{
    String idPayement_brocker;
    String idClient;
    String idBrocker;
    String idOrdre;
    float argent ;//negatif pour le brocker , positif pour le client
    Date date_payement ;
    public Payement_brocker () {}

    public Payement_brocker ( String idPayement_brocker, String idClient, String idBrocker, String idOrdre, float argent, Date date_payement) {
    
    setIdPayement_brocker(idPayement_brocker) ;
    
    setIdClient(idClient) ;
    
    setIdBrocker(idBrocker) ;
    
    setIdOrdre(idOrdre) ;
    
    setArgent(argent) ;
    
    setDate_payement(date_payement) ;
    
    }
    
    public String aff() {
    
    String res ="" ;
    
    res += " IdPayement_brocker: "+getIdPayement_brocker()+ " ---" ;
    
    res += " IdClient: "+getIdClient()+ " ---" ;
    
    res += " IdBrocker: "+getIdBrocker()+ " ---" ;
    
    res += " IdOrdre: "+getIdOrdre()+ " ---" ;
    
    res += " Argent: "+getArgent()+ " ---" ;
    
    res += " Date_payement: "+getDate_payement()+ " ---" ;
    
    return res;
    
    }
    
    public String affS(Object[] liste) {
    
    if(liste.length<=0){
    
    return "aucun Payement_brocker";
    
    }
    
    String res ="Tableau de Payement_brocker" ;
    
    res +="<table class=\"table table-bordered\">" ;
    
    res +="<tr>" ;
    
    res +=" <th>idPayement_brocker</th>";
    
    res +=" <th>idClient</th>";
    
    res +=" <th>idBrocker</th>";
    
    res +=" <th>idOrdre</th>";
    
    res +=" <th>argent</th>";
    
    res +=" <th>date_payement</th>";
    
    res +="</tr>" ;
    
    for(int i=0; i<liste.length; i++){
    
    Payement_brocker x = (Payement_brocker)liste[i];
    
    res +="<tr>" ;
    
    res += "<td>"+x.getIdPayement_brocker()+"</td>";
    
    res += "<td>"+x.getIdClient()+"</td>";
    
    res += "<td>"+x.getIdBrocker()+"</td>";
    
    res += "<td>"+x.getIdOrdre()+"</td>";
    
    res += "<td>"+x.getArgent()+"</td>";
    
    res += "<td>"+x.getDate_payement()+"</td>";
    
    res +="</tr>" ;
    
    }
    
    res +="</table>" ;
    
    return res;
    
    }
    
    public String getIdPayement_brocker() {
    
    return this.idPayement_brocker;
    
    }
    
    public void setIdPayement_brocker(String idPayement_brocker) {
    
    this.idPayement_brocker = idPayement_brocker;
    
    }
    
    public String getIdClient() {
    
    return this.idClient;
    
    }
    
    public void setIdClient(String idClient) {
    
    this.idClient = idClient;
    
    }
    
    public String getIdBrocker() {
    
    return this.idBrocker;
    
    }
    
    public void setIdBrocker(String idBrocker) {
    
    this.idBrocker = idBrocker;
    
    }
    
    public String getIdOrdre() {
    
    return this.idOrdre;
    
    }
    
    public void setIdOrdre(String idOrdre) {
    
    this.idOrdre = idOrdre;
    
    }
    
    public float getArgent() {
    
    return this.argent;
    
    }
    
    public void setArgent(float argent) {
    
    this.argent = argent;
    
    }
    
    public void setArgent( String argent) {
    
    setArgent((new Integer(argent)).floatValue());
    
    }
    
    public Date getDate_payement() {
    
    return this.date_payement;
    
    }
    
    public void setDate_payement(Date date_payement) {
    
    this.date_payement = date_payement;
    
    }
    
    public void setDate_payement( String date_payement) throws Exception {
    
    setDate_payement( (new Function_date()).stringtodate(date_payement) );
    
    }
}