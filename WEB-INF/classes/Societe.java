package donnee;

public class Societe{
    String idSociete;
    String nom;
    int nbTitre ;
    String idBrocker;
    public Societe () {}

public Societe ( String idSociete, String nom, int nbTitre, String idBrocker) {

setIdSociete(idSociete) ;

setNom(nom) ;

setNbTitre(nbTitre) ;

setIdBrocker(idBrocker) ;

}

public String aff() {

String res ="" ;

res += " IdSociete: "+getIdSociete()+ " ---" ;

res += " Nom: "+getNom()+ " ---" ;

res += " NbTitre: "+getNbTitre()+ " ---" ;

res += " IdBrocker: "+getIdBrocker()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun Societe";

}

String res ="Tableau de Societe" ;

res +="<table class=\"table table-bordered\">" ;

res +="<tr>" ;

res +=" <th>idSociete</th>";

res +=" <th>nom</th>";

res +=" <th>nbTitre</th>";

res +=" <th>idBrocker</th>";

res +="</tr>" ;

for(int i=0; i<liste.length; i++){

Societe x = (Societe)liste[i];

res +="<tr>" ;

res += "<td>"+x.getIdSociete()+"</td>";

res += "<td>"+x.getNom()+"</td>";

res += "<td>"+x.getNbTitre()+"</td>";

res += "<td>"+x.getIdBrocker()+"</td>";

res +="</tr>" ;

}

res +="</table>" ;

return res;

}

public String getIdSociete() {

return this.idSociete;

}

public void setIdSociete(String idSociete) {

this.idSociete = idSociete;

}

public String getNom() {

return this.nom;

}

public void setNom(String nom) {

this.nom = nom;

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
public String getderoul(){
    return "<option value=\""+getIdSociete()+"\">"+getNom()+"</option>";
}
}