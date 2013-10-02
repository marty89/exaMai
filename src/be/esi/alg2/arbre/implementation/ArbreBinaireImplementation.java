/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.implementation;

import be.esi.alg2.arbre.mvc.ArbreBinaire;



/**
 * A ne pas modifier
 */
public class ArbreBinaireImplementation implements ArbreBinaire {
    private NoeudBinaireImplementation racine;
    
    void setRacine(NoeudBinaireImplementation noeud){
        racine=noeud;
    }
   
    @Override
    public NoeudBinaireImplementation getRacine(){
        return racine;
    }
        
    
}
