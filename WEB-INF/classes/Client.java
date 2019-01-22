package donnee;

public class Client{
    String idClient;
    String nom ;
    int argent;
	public Client () {}

	public Client ( String idClient, String nom, int argent) {

		setIdClient(idClient) ;

		setNom(nom) ;

		setArgent(argent) ;

	}

	public String aff() {

		String res ="" ;

		res += " IdClient: "+getIdClient()+ " ---" ;

		res += " Nom: "+getNom()+ " ---" ;

		res += " Argent: "+getArgent()+ " ---" ;

		return res;

	}

	public String affS(Object[] liste) {

		if(liste.length<=0){

			return "aucun Client";

		}

		String res ="" ;

		res +="<table class=\"table table-bordered\">" ;

		res +="<tr>" ;

		res +=" <th>idClient</th>";

		res +=" <th>nom</th>";

		res +=" <th>argent</th>";

		res +="</tr>" ;

		for(int i=0; i<liste.length; i++){

			Client x = (Client)liste[i];

			res +="<tr>" ;

			res += "<td>"+x.getIdClient()+"</td>";

			res += "<td>"+x.getNom()+"</td>";

			res += "<td>"+x.getArgent()+"</td>";

			res +="</tr>" ;

		}

		res +="</table>" ;

		return res;

	}

	public String getIdClient() {

		return this.idClient;

	}

	public void setIdClient(String idClient) {

		this.idClient = idClient;

	}

	public String getNom() {

		return this.nom;

	}

	public void setNom(String nom) {

		this.nom = nom;

	}

	public int getArgent() {

		return this.argent;

	}

	public void setArgent(int argent) {

		this.argent = argent;

	}
	public void setArgent(String argent) {

		setArgent((new Integer(argent)).intValue());

	}
}