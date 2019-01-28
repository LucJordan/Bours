package donnee;

public class Ordreconclu{
    String idOrdreconclu ;
    String idBrocker ;
    String idOrdre0 ;
    String idOrdre1 ;
    public Ordreconclu () {}

    public Ordreconclu ( String idOrdreconclu, String idBrocker, String idOrdre0, String idOrdre1) {
    
    setIdOrdreconclu(idOrdreconclu) ;
    
    setIdBrocker(idBrocker) ;
    
    setIdOrdre0(idOrdre0) ;
    
    setIdOrdre1(idOrdre1) ;
    
    }
    
    public String aff() {
    
    String res ="" ;
    
    res += " IdOrdreconclu: "+getIdOrdreconclu()+ " ---" ;
    
    res += " IdBrocker: "+getIdBrocker()+ " ---" ;
    
    res += " IdOrdre0: "+getIdOrdre0()+ " ---" ;
    
    res += " IdOrdre1: "+getIdOrdre1()+ " ---" ;
    
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
    
    res +=" <th>idOrdre0</th>";
    
    res +=" <th>idOrdre1</th>";
    
    res +="</tr>" ;
    
    for(int i=0; i<liste.length; i++){
    
    Ordreconclu x = (Ordreconclu)liste[i];
    
    res +="<tr>" ;
    
    res += "<td>"+x.getIdOrdreconclu()+"</td>";
    
    res += "<td>"+x.getIdBrocker()+"</td>";
    
    res += "<td>"+x.getIdOrdre0()+"</td>";
    
    res += "<td>"+x.getIdOrdre1()+"</td>";
    
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
    
    public String getIdOrdre0() {
    
    return this.idOrdre0;
    
    }
    
    public void setIdOrdre0(String idOrdre0) {
    
    this.idOrdre0 = idOrdre0;
    
    }
    
    public String getIdOrdre1() {
    
    return this.idOrdre1;
    
    }
    
    public void setIdOrdre1(String idOrdre1) {
    
    this.idOrdre1 = idOrdre1;
    
    }
}