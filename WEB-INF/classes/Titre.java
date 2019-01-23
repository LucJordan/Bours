package donnee;

public class Titre{
    String idTitre;
    String idSociete;
    float prix ;
    public Titre () {}

public Titre ( String idTitre, String idSociete, float prix) {

setIdTitre(idTitre) ;

setIdSociete(idSociete) ;

setPrix(prix) ;

}

public String aff() {

String res ="" ;

res += " IdTitre: "+getIdTitre()+ " ---" ;

res += " IdSociete: "+getIdSociete()+ " ---" ;

res += " Prix: "+getPrix()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun Titre";

}

String res ="Tableau de Titre" ;

res +="<table class=\"table table-bordered\">" ;

res +="<tr>" ;

res +=" <th>idTitre</th>";

res +=" <th>idSociete</th>";

res +=" <th>prix</th>";

res +="</tr>" ;

for(int i=0; i<liste.length; i++){

Titre x = (Titre)liste[i];

res +="<tr>" ;

res += "<td>"+x.getIdTitre()+"</td>";

res += "<td>"+x.getIdSociete()+"</td>";

res += "<td>"+x.getPrix()+"</td>";

res +="</tr>" ;

}

res +="</table>" ;

return res;

}

public String getIdTitre() {

return this.idTitre;

}

public void setIdTitre(String idTitre) {

this.idTitre = idTitre;

}

public String getIdSociete() {

return this.idSociete;

}

public void setIdSociete(String idSociete) {

this.idSociete = idSociete;

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
}