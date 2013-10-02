/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.gui;

import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.dto.ArbreDto;
import be.esi.alg2.arbre.metier.ArbreBinaireFacade;
import be.esi.alg2.gui.outils.JDRechGenerique;
import be.esi.alg2.gui.outils.MaJTableInitialisationException;
import be.esi.alg2.gui.outils.SelectObject;
import java.util.ArrayList;

/**
 *
 * @author marty
 */
class SelectArbre extends SelectObject<ArbreDto, ArbreDto> {

    @Override
    protected void initLargeurs() {
        setLargeurCritere(120);
    }

    @Override
    protected String getCle(ArbreDto t) {
        return t.getId();
    }

    @Override
    protected String getShortDescription(ArbreDto t) {
        return "cle : " + t.getId() + " .";
    }

    @Override
    protected ArbreDto trouveObjet(String string) throws Exception {
        return ArbreBinaireFacade.getNomArbres(string).get(0);
    }

    @Override
    protected ArbreDto getObjectById(Object o) throws Exception {
        return ArbreBinaireFacade.getNomArbres(((ArbreDto) o).getId()).get(0);
    }

    @Override
    protected JDRechGenerique<ArbreDto, ArbreDto> getPanelRecherche() throws MaJTableInitialisationException {
            return new JDRechercheArbre(null, true, "Sélection d'édition", new JPCritSelArbre(), new MaJTableArbre());
    }
}
