package donnee;

import java.sql.Date;
import tools.*;

public class Ordre{
    String idOrdre;
    String idSociete;
    float prixUnitaire;
    String idClient;
    int nbTitre;
    String idBrocker;
    int type;
    Date dates;
    public Ordre () {}

    public Ordre ( String idOrdre, String idSociete, float prixUnitaire, String idClient, int nbTitre, String idBrocker, int type, Date dates) {
    
    setIdOrdre(idOrdre) ;
    
    setIdSociete(idSociete) ;
    
    setPrixUnitaire(prixUnitaire) ;
    
    setIdClient(idClient) ;
    
    setNbTitre(nbTitre) ;
    
    setIdBrocker(idBrocker) ;
    
    setType(type) ;
    
    setDates(dates) ;
    
    }
    
    public String aff() {
    
    String res ="" ;
    
    res += " IdOrdre: "+getIdOrdre()+ " ---" ;
    
    res += " IdSociete: "+getIdSociete()+ " ---" ;
    
    res += " PrixUnitaire: "+getPrixUnitaire()+ " ---" ;
    
    res += " IdClient: "+getIdClient()+ " ---" ;
    
    res += " NbTitre: "+getNbTitre()+ " ---" ;
    
    res += " IdBrocker: "+getIdBrocker()+ " ---" ;
    
    res += " Type: "+getType()+ " ---" ;
    
    res += " Dates: "+getDates()+ " ---" ;
    
    return res;
    
    }
    
    public String affS(Object[] liste) {
    
    if(liste.length<=0){
    
    return "aucun Ordre";
    
    }
    
    String res ="Tableau de Ordre" ;
    
    res +="<table class=\"table table-bordered\">" ;
    
    res +="<tr>" ;
    
    res +=" <th>idOrdre</th>";
    
    res +=" <th>idSociete</th>";
    
    res +=" <th>prixUnitaire</th>";
    
    res +=" <th>idClient</th>";
    
    res +=" <th>nbTitre</th>";
    
    res +=" <th>idBrocker</th>";
    
    res +=" <th>type</th>";
    
    res +=" <th>dates</th>";
    
    res +="</tr>" ;
    
    for(int i=0; i<liste.length; i++){
    
    Ordre x = (Ordre)liste[i];
    
    res +="<tr>" ;
    
    res += "<td>"+x.getIdOrdre()+"</td>";
    
    res += "<td>"+x.getIdSociete()+"</td>";
    
    res += "<td>"+x.getPrixUnitaire()+"</td>";
    
    res += "<td>"+x.getIdClient()+"</td>";
    
    res += "<td>"+x.getNbTitre()+"</td>";
    
    res += "<td>"+x.getIdBrocker()+"</td>";
    
    res += "<td>"+x.getType()+"</td>";
    
    res += "<td>"+x.getDates()+"</td>";
    
    res +="</tr>" ;
    
    }
    
    res +="</table>" ;
    
    return res;
    
    }
    
    public String getIdOrdre() {
    
    return this.idOrdre;
    
    }
    
    public void setIdOrdre(String idOrdre) {
    
    this.idOrdre = idOrdre;
    
    }
    
    public String getIdSociete() {
    
    return this.idSociete;
    
    }
    
    public void setIdSociete(String idSociete) {
    
    this.idSociete = idSociete;
    
    }
    
    public float getPrixUnitaire() {
    
    return this.prixUnitaire;
    
    }
    
    public void setPrixUnitaire(float prixUnitaire) {
    
    this.prixUnitaire = prixUnitaire;
    
    }
    
    public void setPrixUnitaire( String prixUnitaire) {
    
    setPrixUnitaire((new Integer(prixUnitaire)).floatValue());
    
    }
    
    public String getIdClient() {
    
    return this.idClient;
    
    }
    
    public void setIdClient(String idClient) {
    
    this.idClient = idClient;
    
    }
    
    public int getNbTitre() {
    
    return this.nbTitre;
    
    }
    
    public void setNbTitre(int nbTitre) {
    
    this.nbTitre = nbTitre;
    
    }
    
    public void setNbTitre( String nbTitre) {
    
    setNbTitre((new Integer(nbTitre)).intValue());
    
    }
    
    public String getIdBrocker() {
    
    return this.idBrocker;
    
    }
    
    public void setIdBrocker(String idBrocker) {
    
    this.idBrocker = idBrocker;
    
    }
    
    public int getType() {
    
    return this.type;
    
    }
    
    public void setType(int type) {
    
    this.type = type;
    
    }
    
    public void setType( String type) {
    
    setType((new Integer(type)).intValue());
    
    }
    
    public Date getDates() {
    
    return this.dates;
    
    }
    
    public void setDates(Date dates) {
    
    this.dates = dates;
    
    }
    
    public void setDates( String dates) throws Exception {
    
    setDates( (new Function_date()).stringtodate(dates) );
    
    }
}