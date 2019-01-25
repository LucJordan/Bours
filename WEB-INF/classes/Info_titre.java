package donnee;

public class Info_titre{
    String idTitre_vendu;
    String idTitre;
    String idProprietaire;
    float prix;
    String idSociete;
    String nomSociete;
    int nbTitre;
    public Info_titre () {}

public Info_titre ( String idTitre_vendu, String idTitre, String idProprietaire, float prix, String idSociete, String nomSociete, int nbTitre) {


setIdTitre_vendu(idTitre_vendu) ;



setIdTitre(idTitre) ;



setIdProprietaire(idProprietaire) ;



setPrix(prix) ;



setIdSociete(idSociete) ;



setNomSociete(nomSociete) ;



setNbTitre(nbTitre) ;


}

public String aff() {

String res ="" ; 

res += " IdTitre_vendu: "+getIdTitre_vendu()+ " ---" ;

res += " IdTitre: "+getIdTitre()+ " ---" ;

res += " IdProprietaire: "+getIdProprietaire()+ " ---" ;

res += " Prix: "+getPrix()+ " ---" ;

res += " IdSociete: "+getIdSociete()+ " ---" ;

res += " NomSociete: "+getNomSociete()+ " ---" ;

res += " NbTitre: "+getNbTitre()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun Info_titre";

}

String res ="Tableau de Info_titre" ; 

res +="<table class=\"table table-bordered\">" ; 

res +="<tr>" ; 

res +=" <th>idTitre_vendu</th>";

res +=" <th>idTitre</th>";

res +=" <th>idProprietaire</th>";

res +=" <th>prix</th>";

res +=" <th>idSociete</th>";

res +=" <th>nomSociete</th>";

res +=" <th>nbTitre</th>";

res +="</tr>" ; 

for(int i=0; i<liste.length; i++){

Info_titre x = (Info_titre)liste[i];

res +="<tr>" ; 

res += "<td>"+x.getIdTitre_vendu()+"</td>";

res += "<td>"+x.getIdTitre()+"</td>";

res += "<td>"+x.getIdProprietaire()+"</td>";

res += "<td>"+x.getPrix()+"</td>";

res += "<td>"+x.getIdSociete()+"</td>";

res += "<td>"+x.getNomSociete()+"</td>";

res += "<td>"+x.getNbTitre()+"</td>";

res +="</tr>" ; 

}

res +="</table>" ; 

return res;

}

public String getIdTitre_vendu() { 

return this.idTitre_vendu;

} 

public void setIdTitre_vendu(String idTitre_vendu) { 

this.idTitre_vendu = idTitre_vendu;

} 

public String getIdTitre() { 

return this.idTitre;

} 

public void setIdTitre(String idTitre) { 

this.idTitre = idTitre;

} 

public String getIdProprietaire() { 

return this.idProprietaire;

} 

public void setIdProprietaire(String idProprietaire) { 

this.idProprietaire = idProprietaire;

} 

public float getPrix() { 

return this.prix;

} 

public void setPrix(float prix) { 

this.prix = prix;

} 

public void setPrix( String prix) { 

setPrix((new Integer(prix)).floatValue());

} 

public String getIdSociete() { 

return this.idSociete;

} 

public void setIdSociete(String idSociete) { 

this.idSociete = idSociete;

} 

public String getNomSociete() { 

return this.nomSociete;

} 

public void setNomSociete(String nomSociete) { 

this.nomSociete = nomSociete;

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
}