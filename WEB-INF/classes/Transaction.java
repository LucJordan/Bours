package donnee;

import java.sql.Date;
import tools.*;

public class Transaction {
    String idTransaction;
    Date dateTransac;
    String idOrdreVente;
    String idOrdreAchat;
    float montantBrockerV;
    float montantBrockerA;
    public Transaction () {}

public Transaction ( String idTransaction, Date dateTransac, String idOrdreVente, String idOrdreAchat, float montantBrockerV, float montantBrockerA) {

setIdTransaction(idTransaction) ;

setDateTransac(dateTransac) ;

setIdOrdreVente(idOrdreVente) ;

setIdOrdreAchat(idOrdreAchat) ;

setMontantBrockerV(montantBrockerV) ;

setMontantBrockerA(montantBrockerA) ;

}

public String aff() {

String res ="" ;

res += " IdTransaction: "+getIdTransaction()+ " ---" ;

res += " DateTransac: "+getDateTransac()+ " ---" ;

res += " IdOrdreVente: "+getIdOrdreVente()+ " ---" ;

res += " IdOrdreAchat: "+getIdOrdreAchat()+ " ---" ;

res += " MontantBrockerV: "+getMontantBrockerV()+ " ---" ;

res += " MontantBrockerA: "+getMontantBrockerA()+ " ---" ;

return res;

}

public String affS(Object[] liste) {

if(liste.length<=0){

return "aucun Transaction";

}

String res ="Tableau de Transaction" ;

res +="<table class=\"table table-bordered\">" ;

res +="<tr>" ;

res +=" <th>idTransaction</th>";

res +=" <th>dateTransac</th>";

res +=" <th>idOrdreVente</th>";

res +=" <th>idOrdreAchat</th>";

res +=" <th>montantBrockerV</th>";

res +=" <th>montantBrockerA</th>";

res +="</tr>" ;

for(int i=0; i<liste.length; i++){

Transaction x = (Transaction)liste[i];

res +="<tr>" ;

res += "<td>"+x.getIdTransaction()+"</td>";

res += "<td>"+x.getDateTransac()+"</td>";

res += "<td>"+x.getIdOrdreVente()+"</td>";

res += "<td>"+x.getIdOrdreAchat()+"</td>";

res += "<td>"+x.getMontantBrockerV()+"</td>";

res += "<td>"+x.getMontantBrockerA()+"</td>";

res +="</tr>" ;

}

res +="</table>" ;

return res;

}

public String getIdTransaction() {

return this.idTransaction;

}

public void setIdTransaction(String idTransaction) {

this.idTransaction = idTransaction;

}

public Date getDateTransac() {

return this.dateTransac;

}

public void setDateTransac(Date dateTransac) {

this.dateTransac = dateTransac;

}

public void setDateTransac( String dateTransac) throws Exception {

setDateTransac( (new Function_date()).stringtodate(dateTransac) );

}

public String getIdOrdreVente() {

return this.idOrdreVente;

}

public void setIdOrdreVente(String idOrdreVente) {

this.idOrdreVente = idOrdreVente;

}

public String getIdOrdreAchat() {

return this.idOrdreAchat;

}

public void setIdOrdreAchat(String idOrdreAchat) {

this.idOrdreAchat = idOrdreAchat;

}

public float getMontantBrockerV() {

return this.montantBrockerV;

}

public void setMontantBrockerV(float montantBrockerV) {

this.montantBrockerV = montantBrockerV;

}

public void setMontantBrockerV( String montantBrockerV) {

setMontantBrockerV((new Integer(montantBrockerV)).floatValue());

}

public float getMontantBrockerA() {

return this.montantBrockerA;

}

public void setMontantBrockerA(float montantBrockerA) {

this.montantBrockerA = montantBrockerA;

}

public void setMontantBrockerA( String montantBrockerA) {

setMontantBrockerA((new Integer(montantBrockerA)).floatValue());

}
}