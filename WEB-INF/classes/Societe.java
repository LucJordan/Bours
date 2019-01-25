package donnee;

public class Societe{
    String idSociete;
    String nom;
    int nbTitre ;
    public Societe () {}

    public Societe ( String idSociete, String nom, int nbTitre) {
    
    
    setIdSociete(idSociete) ;
    
    
    
    setNom(nom) ;
    
    
    
    setNbTitre(nbTitre) ;
    
    
    }
    
    public String aff() {
    
    String res ="" ; 
    
    res += " IdSociete: "+getIdSociete()+ " ---" ;
    
    res += " Nom: "+getNom()+ " ---" ;
    
    res += " NbTitre: "+getNbTitre()+ " ---" ;
    
    return res;
    
    }
    
    public String affS(Object[] liste) {
    
    if(liste.length<=0){
    
    return "aucun Societe";
    
    }
    
    String res ="Tableau de Societe" ; 
    
    res +="<table class=\"table table-bordered\">" ; 
    
    res +="<tr>" ; 
    
    res +=" <th>idSociete</th>";
    
    res +=" <th>nom</th>";
    
    res +=" <th>nbTitre</th>";
    
    res +="</tr>" ; 
    
    for(int i=0; i<liste.length; i++){
    
    Societe x = (Societe)liste[i];
    
    res +="<tr>" ; 
    
    res += "<td>"+x.getIdSociete()+"</td>";
    
    res += "<td>"+x.getNom()+"</td>";
    
    res += "<td>"+x.getNbTitre()+"</td>";
    
    res +="</tr>" ; 
    
    }
    
    res +="</table>" ; 
    
    return res;
    
    }
    
    public String getIdSociete() { 
    
    return this.idSociete;
    
    } 
    
    public void setIdSociete(String idSociete) { 
    
    this.idSociete = idSociete;
    
    } 
    
    public String getNom() { 
    
    return this.nom;
    
    } 
    
    public void setNom(String nom) { 
    
    this.nom = nom;
    
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
    
    public String getderoul(){
        return "<option value=\""+getIdSociete()+"\">"+getNom()+"</option>";
    }
}