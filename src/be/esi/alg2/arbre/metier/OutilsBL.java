package be.esi.alg2.arbre.metier;

import be.esi.alg2.arbre.db.ArbreDbException;
import be.esi.alg2.arbre.db.DBManager;

/**
 * Classe utilitaire d'outils d'aide à la rédaction de méthodes 'façade'
 * @author Alain
 */
class OutilsBL {

    static void gereAnnulation(String msg) throws ArbreMetierException {
        try {
            DBManager.annuleTransaction();
        } catch (ArbreDbException ex) {
            msg =  msg + "\n"+ex.getMessage() ;
        } 
            throw new ArbreMetierException(msg);

    }
}
