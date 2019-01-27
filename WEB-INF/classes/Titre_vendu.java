package donnee;

import tools.*;
import function_gen.*;
import java.sql.Connection;

public class Titre_vendu {
    String idTitre_vendu;
    String idTitre;
    String idProprietaire;
    public Titre_vendu () {}

public Titre_vendu ( String idTitre_vendu, String idTitre, String idProprietaire) {

setIdTitre_vendu(idTitre_vendu) ;

setIdTitre(idTitre) ;

setIdProprietaire(idProprietaire) ;

}

public String aff() {

String res ="" ;

res += " IdTitre_vendu: "+getIdTitre_vendu()+ " ---" ;

res += " IdTitre: "+getIdTitre()+ " ---" ;

res += " IdProprietaire: "+getIdProprietaire()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun Titre_vendu";

}

String res ="Tableau de Titre_vendu" ;

res +="<table class=\"table table-bordered\">" ;

res +="<tr>" ;

res +=" <th>idTitre_vendu</th>";

res +=" <th>idTitre</th>";

res +=" <th>idProprietaire</th>";

res +="</tr>" ;

for(int i=0; i<liste.length; i++){

Titre_vendu x = (Titre_vendu)liste[i];

res +="<tr>" ;

res += "<td>"+x.getIdTitre_vendu()+"</td>";

res += "<td>"+x.getIdTitre()+"</td>";

res += "<td>"+x.getIdProprietaire()+"</td>";

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
public void updateProprio(Connection con,String idproprio) throws Exception {
    new Function_gen().update(con, this,"Titre_vendu","idProprietaire,idTitre_vendu",idproprio+","+getIdTitre_vendu());
    System.out.println("_____proprietaire de titre changee_____");
}
}