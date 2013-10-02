/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.dto;


import be.esi.alg2.arbre.mvc.ArbreBinaire;
import be.esi.alg2.arbre.mvc.NoeudBinaire;
import be.esi.alg2.arbre.mvc.Valeur;
import be.esi.alg2.dto.Dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Dto d'un arbre binaire reprenant l'entierté de l'arbre
 */
public class ArbreCompletDto extends Dto<String> {
    private Date timesTamp;
    private List<Valeur> liste;

    @Override
    public String toString() {
        return "ArbreCompletDto{" + "timesTamp=" + timesTamp + ", liste=" + liste + '}';
    }

    /**
     * 
     * @param nom
     * @param date
     * @param arbre 
     */
    public ArbreCompletDto(String nom, Date date, ArbreBinaire arbre){
        timesTamp=date;
        id=nom;
        liste=new ArrayList<Valeur>();
        construitListe(arbre.getRacine());
    }  
    
    /**
     * 
     * @param nom
     * @param date
     * @param liste 
     */
    public ArbreCompletDto(String nom, Date date, List<Valeur> liste){
        timesTamp=date;
        id=nom;
        this.liste=liste;
    }
    
    
    private void construitListe(NoeudBinaire n){
        if(n!=null){
            getListe().add(n.getVal());
            construitListe(n.getGauche());
            construitListe(n.getDroite());            
        }
    }
    /**
     * @return the timesTamp
     */
    public Date getTimesTamp() {
        return timesTamp;
    }

    /**
     * @param timesTamp the timesTamp to set
     */
    public void setTimesTamp(Date timesTamp) {
        this.timesTamp = timesTamp;
    }

    /**
     * @return the liste
     */
    public List<Valeur> getListe() {
        return liste;
    }
}
