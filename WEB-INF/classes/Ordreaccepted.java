package donnee;

import java.sql.Date;

public class Ordreaccepted extends Ordre {
    public Ordreaccepted ( String idOrdre, String idSociete, float prixUnitaire, String idClient, int nbTitre, String idBrocker, int type, Date dates) throws Exception {
        super( idOrdre, idSociete, prixUnitaire, idClient, nbTitre, idBrocker, type, dates);
    }
    public Ordreaccepted(){
        super();
    }
}