package donnee;

public class Ordreconclu{
    String idOrdreconclu ;
    String idBrocker ;
    String idOrdre ;
    public Ordreconclu () {}

public Ordreconclu ( String idOrdreconclu, String idBrocker, String idOrdre) {

setIdOrdreconclu(idOrdreconclu) ;

setIdBrocker(idBrocker) ;

setIdOrdre(idOrdre) ;

}

public String aff() {

String res ="" ;

res += " IdOrdreconclu: "+getIdOrdreconclu()+ " ---" ;

res += " IdBrocker: "+getIdBrocker()+ " ---" ;

res += " IdOrdre: "+getIdOrdre()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun Ordreconclu";

}

String res ="Tableau de Ordreconclu" ;

res +="<table class=\"table table-bordered\">" ;

res +="<tr>" ;

res +=" <th>idOrdreconclu</th>";

res +=" <th>idBrocker</th>";

res +=" <th>idOrdre</th>";

res +="</tr>" ;

for(int i=0; i<liste.length; i++){

Ordreconclu x = (Ordreconclu)liste[i];

res +="<tr>" ;

res += "<td>"+x.getIdOrdreconclu()+"</td>";

res += "<td>"+x.getIdBrocker()+"</td>";

res += "<td>"+x.getIdOrdre()+"</td>";

res +="</tr>" ;

}

res +="</table>" ;

return res;

}

public String getIdOrdreconclu() {

return this.idOrdreconclu;

}

public void setIdOrdreconclu(String idOrdreconclu) {

this.idOrdreconclu = idOrdreconclu;

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
}