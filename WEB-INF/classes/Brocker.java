package donnee;

public class Brocker{
    String idBrocker;
    String nom;
    float pourcentage;
	float argent;
	int delai_payement;
	float pourcentage_penalisation;
	public Brocker () {}

	public Brocker ( String idBrocker, String nom, float pourcentage, float argent, int delai_payement, float pourcentage_penalisation) {
	
	setIdBrocker(idBrocker) ;
	
	setNom(nom) ;
	
	setPourcentage(pourcentage) ;
	
	setArgent(argent) ;
	
	setDelai_payement(delai_payement) ;
	
	setPourcentage_penalisation(pourcentage_penalisation) ;
	
	}
	
	public String aff() {
	
	String res ="" ;
	
	res += " IdBrocker: "+getIdBrocker()+ " ---" ;
	
	res += " Nom: "+getNom()+ " ---" ;
	
	res += " Pourcentage: "+getPourcentage()+ " ---" ;
	
	res += " Argent: "+getArgent()+ " ---" ;
	
	res += " Delai_payement: "+getDelai_payement()+ " ---" ;
	
	res += " Pourcentage_penalisation: "+getPourcentage_penalisation()+ " ---" ;
	
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
	
	res +=" <th>delai_payement</th>";
	
	res +=" <th>pourcentage_penalisation</th>";
	
	res +="</tr>" ;
	
	for(int i=0; i<liste.length; i++){
	
	Brocker x = (Brocker)liste[i];
	
	res +="<tr>" ;
	
	res += "<td>"+x.getIdBrocker()+"</td>";
	
	res += "<td>"+x.getNom()+"</td>";
	
	res += "<td>"+x.getPourcentage()+"</td>";
	
	res += "<td>"+x.getArgent()+"</td>";
	
	res += "<td>"+x.getDelai_payement()+"</td>";
	
	res += "<td>"+x.getPourcentage_penalisation()+"</td>";
	
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
	
	public int getDelai_payement() {
	
	return this.delai_payement;
	
	}
	
	public void setDelai_payement(int delai_payement) {
	
	this.delai_payement = delai_payement;
	
	}
	
	public void setDelai_payement( String delai_payement) {
	
	setDelai_payement((new Integer(delai_payement)).intValue());
	
	}
	
	public float getPourcentage_penalisation() {
	
	return this.pourcentage_penalisation;
	
	}
	
	public void setPourcentage_penalisation(float pourcentage_penalisation) {
	
	this.pourcentage_penalisation = pourcentage_penalisation;
	
	}
	
	public void setPourcentage_penalisation( String pourcentage_penalisation) {
	
	setPourcentage_penalisation((new Integer(pourcentage_penalisation)).floatValue());
	
	}
	public String getderoul(){
        return "<option value=\""+getIdBrocker()+"\">"+getNom()+"</option>";
    }
}