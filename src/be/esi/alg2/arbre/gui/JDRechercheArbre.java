/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.dto.ArbreDto;
import be.esi.alg2.arbre.metier.ArbreBinaireFacade;
import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import java.util.Collection;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author marty
 */
public class JDRechercheArbre extends JDRechGenerique<ArbreDto,ArbreDto >{
    public JDRechercheArbre(java.awt.Frame parent, boolean modal, String title, JPCritSelArbre crit, MaJTableArbre jT) {
        super(parent, modal, title, crit, jT);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

   

    public static void main(String[] args) throws MaJTableInitialisationException {
        new JDRechercheArbre(null, true, "Sélection d'une édition", new JPCritSelArbre(),
                new MaJTableArbre()).setVisible(true);
    }

    @Override
    protected Collection<ArbreDto> recherche(ArbreDto s) throws Exception {
        return ArbreBinaireFacade.getNomArbres(s.getId());
    }

    

    

    
}
