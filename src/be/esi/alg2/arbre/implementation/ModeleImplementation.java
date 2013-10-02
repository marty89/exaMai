/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.implementation;


import be.esi.alg2.arbre.metier.ArbreNonCreeException;
import be.esi.alg2.arbre.mvc.ArbreModificationListener;
import be.esi.alg2.arbre.mvc.ArbreSelectionListener;
import be.esi.alg2.arbre.mvc.Modele;
import be.esi.alg2.arbre.mvc.NoeudBinaire;
import be.esi.alg2.arbre.mvc.ProfondeurMaximaleAtteinteException;
import be.esi.alg2.arbre.mvc.Valeur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alain
 */
public class ModeleImplementation implements Modele {

    private ArbreBinaireImplementation arbre;
    private NoeudBinaireImplementation sel;
    private List<ArbreModificationListener> arbreModlisteners;  //écouteurs des modifications de l'arbre
    private List<ArbreSelectionListener> arbreSellisteners;     //écouteurs des sélections de noeud de l'arbre

    public ModeleImplementation() {
        arbreModlisteners = new ArrayList<>();
        arbreSellisteners = new ArrayList<>();
        arbre = new ArbreBinaireImplementation();
    }

    /**
     * retourne la liste des noeuds de l'arbre dans l'ordre infixé.
     *
     * @return
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public List<NoeudBinaire> getGRD() {
        List<NoeudBinaire> out = new ArrayList<NoeudBinaire>();
        rechGRD(arbre.getRacine(),out);
        return out;
    }

    /**
     * retourne la liste des noeuds de l'arbre dans l'ordre préfixé.
     *
     * @return
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public List<NoeudBinaire> getRGD() {
        List<NoeudBinaire> out = new ArrayList<NoeudBinaire>();
        rechRGD(arbre.getRacine(),out);
        return out;
    }

    /**
     * retourne la liste des noeuds de l'arbre dans l'ordre postfixé.
     *
     * @return
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public List<NoeudBinaire> getGDR() {
        List<NoeudBinaire> out = new ArrayList<NoeudBinaire>();
        rechGDR(arbre.getRacine(),out);
        return out;
    }

    /**
     * ajoute la valeur fournie à l'arbre
     *
     * @param valeur
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     * @throws ProfondeurMaximaleAtteinteException si l'ajout se fait au delà de
     * la profondeur maximale permise
     */
    @Override
    public void addValeur(Valeur valeur) throws  ProfondeurMaximaleAtteinteException {
        int cle = valeur.getCle();
        if (arbre.getRacine() == null) {
            arbre.setRacine(new NoeudBinaireImplementation(valeur));
        } else {
            int i = 2;
            NoeudBinaireImplementation nb = arbre.getRacine();
            while ((nb.getGauche() != null && cle <= nb.getVal().getCle())
                    || nb.getDroite() != null && cle > nb.getVal().getCle()) {
                if (cle <= nb.getVal().getCle()) {
                    nb = nb.getGauche();
                } else {
                    nb = nb.getDroite();
                }
                i++;
            }
            if (i <= 5) {
                if (cle <= nb.getVal().getCle()) {
                    nb.setGauche(new NoeudBinaireImplementation(valeur));
                }else{
                    nb.setDroite(new NoeudBinaireImplementation(valeur));
                }
            }else{
                throw new ProfondeurMaximaleAtteinteException();
            }
        }
        for(ArbreModificationListener noeud : arbreModlisteners){
            noeud.notifyModArbre();
        }
        for(ArbreSelectionListener noeud : arbreSellisteners){
            noeud.notifyNewSelection(sel);
        }
        /* ***************
            Attention, les écouteurs ne sont pas avertis de la modification
        * */
    }

    /**
     * retire à l'arbre le sous-arbre de racine noeud
     *
     * @param noeud racine du sous-arbre à ôter
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public void oteSousArbre(NoeudBinaire noeud){
        
    }



    /**
     * retourne l'arbre repris par le modèle
     * @return the arbre
     * @throws ArbreNonCreeException si l'arbre n'est pas créé
     */
    @Override
    public ArbreBinaireImplementation getArbre() {
        return arbre;
    }

    /**
     * retourne le NoeudBinaire sélectionné, null à défaut.
     * @return the sel
     */
    @Override
    public NoeudBinaire getSel() {
        return sel;
    }

    /**
     * positionne le noeud sélectionné au noeud fourni
     * @param sel the sel to set
     */
    @Override
    public void setSel(NoeudBinaire sel) {
        this.sel =  (NoeudBinaireImplementation) sel;
        for(ArbreSelectionListener s:arbreSellisteners) s.notifyNewSelection(getSel());
        
    }

    @Override
    public void addModificationListener(ArbreModificationListener listener) {
        arbreModlisteners.add(listener);
        
        
    }

    @Override
    public void removeModificationListener(ArbreModificationListener listener) {
        arbreModlisteners.remove(listener);
        
    }

    @Override
    public void addSelectionListener(ArbreSelectionListener listener) {
        arbreSellisteners.add(listener);
        
    }

    @Override
    public void removeSelectionListener(ArbreSelectionListener listener) {
        arbreSellisteners.remove(listener);
    }

    /**
     * retire le noeud fourni de l'arbre courant
     *  A NE PAS DEVELOPPER
     * @param noeud 
     */
    @Override
    public void oteNoeud(NoeudBinaire noeud) {
        boolean trouve = oter(arbre.getRacine(), noeud, false);
        for(ArbreModificationListener mod : arbreModlisteners){
            mod.notifyModArbre();
        }
    }



    /*
     * crée un nouvela arbre vide dans le modèle
     */
    @Override
    public void nouvelArbre() {
        arbre = new ArbreBinaireImplementation();
        for (ArbreModificationListener ar : arbreModlisteners) {
            ar.notifyModArbre();
        }
        
    }
    
    private void rechGRD(NoeudBinaireImplementation noeud, List<NoeudBinaire> out) {
        if(noeud != null){
            rechGRD(noeud.getGauche(), out);
            out.add(noeud);
            rechGRD(noeud.getDroite(), out);
        }
    }
    private boolean oter(NoeudBinaire noeud,NoeudBinaire aSupp,boolean trouve) {
        if(noeud != null && trouve==false){
            if(noeud.equals(aSupp)){
                noeud=null;
                trouve=true;
                return trouve;
            }
            oter(noeud.getGauche(),aSupp,trouve);
            oter(noeud.getDroite(),aSupp,trouve);
        }
        return trouve;
    }
    private void rechRGD(NoeudBinaireImplementation noeud, List<NoeudBinaire> out) {
        if(noeud != null){
            out.add(noeud);
            rechRGD(noeud.getGauche(), out);
            rechRGD(noeud.getDroite(), out);
        }
    }

    private void rechGDR(NoeudBinaireImplementation noeud, List<NoeudBinaire> out) {
        if(noeud != null){
            rechGDR(noeud.getGauche(), out);
            rechGDR(noeud.getDroite(), out);
            out.add(noeud);
        }
    }
}
