/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.metier;

/**
 * Exception lancée par les méthodes façade en cas d'erreur de type:
 * <ul>
 * <li>Persistance</li>
 * <li>Métier</li>
 * <li>...</li>
 * </ul>
 * @author Alain
 */
public class ArbreNonCreeException extends Exception {

    /**
     * Creates a new instance of
     * <code>ArbreMetierException</code> without detail message.
     */
    public ArbreNonCreeException() {
    }

    /**
     * Constructs an instance of
     * <code>ArbreMetierException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ArbreNonCreeException(String msg) {
        super(msg);
    }
}
