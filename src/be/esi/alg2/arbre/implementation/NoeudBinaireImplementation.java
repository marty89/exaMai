/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.implementation;

import be.esi.alg2.arbre.mvc.NoeudBinaire;
import be.esi.alg2.arbre.mvc.Valeur;



/**
 * A ne pas modifier
 */
public class NoeudBinaireImplementation implements NoeudBinaire {
    private Valeur valeur;
    private NoeudBinaireImplementation gauche, droite;
    
    public NoeudBinaireImplementation(Valeur valeur){
        this.valeur=valeur;
    }
    
    @Override
    public Valeur getVal(){
        return valeur;
    }
    
    @Override
    public NoeudBinaireImplementation getGauche(){
        return gauche;
    }  
    
    @Override
    public NoeudBinaireImplementation getDroite(){
        return droite;
    }
    
    void setValeur(Valeur val){
        valeur=val;
    }
    
    void setGauche(NoeudBinaireImplementation g){
        gauche=g;
    }
    
    void setDroite(NoeudBinaireImplementation d){
        droite=d;
    }
    
    
    @Override
    public String toString(){
        return ""+valeur;

    }
}
