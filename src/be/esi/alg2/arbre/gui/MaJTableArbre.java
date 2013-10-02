/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.dto.ArbreDto;
import be.esi.alg2.gui.outils.MaJTable;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;

/**
 *
 * @author marty
 */
class MaJTableArbre extends MaJTable<ArbreDto>{
    
    public MaJTableArbre() throws MaJTableInitialisationException {
    }
    public MaJTableArbre(Collection<ArbreDto> data) throws MaJTableInitialisationException {
        this();
        setData(data);
    }

     @Override
    protected void setTitres() {
        String[] t = {"Nom",};
        titres = t;
    }

    @Override
    protected void setMethods() {
        String[] t = {"getId", };
        methodes = t;
    }

    @Override
    protected void setLargeurs() {
        int[] t = {300};
        largeurs = t;
    }
    
}
