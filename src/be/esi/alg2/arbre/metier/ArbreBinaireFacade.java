/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.metier;


import be.esi.alg2.arbre.db.ArbreDB;
import be.esi.alg2.arbre.db.ArbreDbException;
import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.dto.ArbreDto;
import be.esi.alg2.arbre.implementation.ModeleImplementation;
import be.esi.alg2.arbre.mvc.Modele;
import java.util.List;

/**
 * Classe utilitaire offrant les méthodes d'accès au modèle et les méthodes lièes à la persistance d'arbres
 * @author Alain
 */
public class ArbreBinaireFacade {

    public static Modele modele;

    /**
     * retourne la liste des ArbreDto desarbres persistés dont le nom commence par le contenu de debNom
     * @param debNom
     * @return
     * @throws ArbreMetierException 
     */
    public static List<ArbreDto> getNomArbres(String debNom) throws ArbreMetierException, ArbreDbException {
        return ArbreDB.listeNoms(debNom);
    }

    /**
     * Retourne le modèle courant, le crée s'il n'existe pas encore
     * @return
     */
    public static Modele getModele() {
        if (modele == null) {
            modele = new ModeleImplementation();
        }
        return modele;
    }

    /**
     * persiste l'arbre fourni sous le nom spécifié
     * @param nom
     * @throws ArbreMetierException 
     */
    public static void persisteArbre(ArbreCompletDto nom) throws ArbreMetierException, ArbreDbException {
           ArbreDB.saveArbre(nom);
    }

    /**
     * retourne ArbreCompletDto de l'arbre persisté dont le nom est fourni en paramètre.  Si l'arbre n'existe pas, null est retourné
     * @param nom
     * @throws ArbreMetierException 
     */
    public static ArbreCompletDto chargeArbre(String nom) throws ArbreMetierException, ArbreDbException {
        return ArbreDB.chargeArbre(nom);
    }
    public static boolean deleteArbre(ArbreCompletDto arbre) throws ArbreDbException {
        return ArbreDB.deleteArbre(arbre.getId());
    }
}
