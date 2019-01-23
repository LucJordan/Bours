package donnee;

public class Brocker{
    String idBrocker;
    String nom;
    float pourcentage;
    float argent;
	public Brocker () {}

	public Brocker ( String idBrocker, String nom, float pourcentage, float argent) {
	
	setIdBrocker(idBrocker) ;
	
	setNom(nom) ;
	
	setPourcentage(pourcentage) ;
	
	setArgent(argent) ;
	
	}
	
	public String aff() {
	
	String res ="" ;
	
	res += " IdBrocker: "+getIdBrocker()+ " ---" ;
	
	res += " Nom: "+getNom()+ " ---" ;
	
	res += " Pourcentage: "+getPourcentage()+ " ---" ;
	
	res += " Argent: "+getArgent()+ " ---" ;
	
	return res;
	
	}
	
	public String affS(Object[] liste) {
	
	if(liste.length<=0){
	
	return "aucun Brocker";
	
	}
	
	String res ="Tableau de Brocker" ;
	
	res +="<table class=\"table table-bordered\">" ;
	
	res +="<tr>" ;
	
	res +=" <th>idBrocker</th>";
	
	res +=" <th>nom</th>";
	
	res +=" <th>pourcentage</th>";
	
	res +=" <th>argent</th>";
	
	res +="</tr>" ;
	
	for(int i=0; i<liste.length; i++){
	
	Brocker x = (Brocker)liste[i];
	
	res +="<tr>" ;
	
	res += "<td>"+x.getIdBrocker()+"</td>";
	
	res += "<td>"+x.getNom()+"</td>";
	
	res += "<td>"+x.getPourcentage()+"</td>";
	
	res += "<td>"+x.getArgent()+"</td>";
	
	res +="</tr>" ;
	
	}
	
	res +="</table>" ;
	
	return res;
	
	}
	
	public String getIdBrocker() {
	
	return this.idBrocker;
	
	}
	
	public void setIdBrocker(String idBrocker) {
	
	this.idBrocker = idBrocker;
	
	}
	
	public String getNom() {
	
	return this.nom;
	
	}
	
	public void setNom(String nom) {
	
	this.nom = nom;
	
	}
	
	public float getPourcentage() {
	
	return this.pourcentage;
	
	}
	
	public void setPourcentage(float pourcentage) {
	
	this.pourcentage = pourcentage;
	
	}
	
	public void setPourcentage( String pourcentage) {
	
	setPourcentage((new Integer(pourcentage)).floatValue());
	
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
	public String getderoul(){
        return "<option value=\""+getIdBrocker()+"\">"+getNom()+"</option>";
    }
}