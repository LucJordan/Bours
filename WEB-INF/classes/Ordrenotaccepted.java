package donnee;

import java.sql.Connection;
import java.sql.Date;

import function_gen.Function_gen;
import tools.Function_date;

public class Ordrenotaccepted extends Ordre {
    public Ordrenotaccepted ( String idOrdre, String idSociete, float prixUnitaire, String idClient, int nbTitre, String idBrocker, int type, Date dates) throws Exception {
        super( idOrdre, idSociete, prixUnitaire, idClient, nbTitre, idBrocker, type, dates);
    }
    public Ordrenotaccepted(){
        super();
    }
    public String affSpec(Object[] liste,Connection con) throws Exception {
    
        if(liste.length<=0){
        
        return "aucun Ordre vente a confirmer";
        
        }
        
        String res ="les ordres de ventes" ;
        
        res +="<table class=\"table table-bordered\">" ;
        
        res +="<tr>" ;
                
        res +=" <th>Date de vente</th>";        

        res +=" <th>Client</th>";

        res +=" <th>Societe</th>";
        
        res +=" <th>prix unitaire</th>";
                
        res +=" <th>nombre de titre a vendre</th>";

        res +=" <th></th>";
                                
        res +="</tr>" ;
        
        for(int i=0; i<liste.length; i++){
        
        Ordre x = (Ordre)liste[i];
        
        res +="<tr>" ;
        
        res += "<td>"+(new Function_date()).aff(x.getDates())+"</td>";
        
        Client c = (Client)(new Function_gen()).selectbyId(con, "Client", "idClient", x.getIdClient());
        res += "<td>"+c.getNom()+"</td>";

        Societe soc = (Societe)(new Function_gen()).selectbyId(con, "Societe", "idSociete", x.getIdSociete());
        res += "<td>"+soc.getNom()+"</td>";
        
        res += "<td>"+x.getPrixUnitaire()+"</td>";
        
        
        res += "<td>"+x.getNbTitre()+"</td>";

        res += "<td><a href=\"confirm_ordre.jsp?idOrdre="+x.getIdOrdre()+"\">confirmer</a></td>";
                        
        res +="</tr>" ;
        
        }
        
        res +="</table>" ;
        
        return res;
        
        }
}