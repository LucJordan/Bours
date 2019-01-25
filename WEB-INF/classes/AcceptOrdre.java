package donnee;

public class AcceptOrdre{
    String idAcceptOrdre;
    String idOrdre;
    public AcceptOrdre () {}

public AcceptOrdre ( String idAcceptOrdre, String idOrdre) {


setIdAcceptOrdre(idAcceptOrdre) ;



setIdOrdre(idOrdre) ;


}

public String aff() {

String res ="" ; 

res += " IdAcceptOrdre: "+getIdAcceptOrdre()+ " ---" ;

res += " IdOrdre: "+getIdOrdre()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun AcceptOrdre";

}

String res ="Tableau de AcceptOrdre" ; 

res +="<table class=\"table table-bordered\">" ; 

res +="<tr>" ; 

res +=" <th>idAcceptOrdre</th>";

res +=" <th>idOrdre</th>";

res +="</tr>" ; 

for(int i=0; i<liste.length; i++){

AcceptOrdre x = (AcceptOrdre)liste[i];

res +="<tr>" ; 

res += "<td>"+x.getIdAcceptOrdre()+"</td>";

res += "<td>"+x.getIdOrdre()+"</td>";

res +="</tr>" ; 

}

res +="</table>" ; 

return res;

}

public String getIdAcceptOrdre() { 

return this.idAcceptOrdre;

} 

public void setIdAcceptOrdre(String idAcceptOrdre) { 

this.idAcceptOrdre = idAcceptOrdre;

} 

public String getIdOrdre() { 

return this.idOrdre;

} 

public void setIdOrdre(String idOrdre) { 

this.idOrdre = idOrdre;

} 

}