/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.db;

/**
 *
 * @author Alain
 */
public class ArbreDbException extends Exception {

    /**
     * Creates a new instance of
     * <code>ArbreDbException</code> without detail message.
     */
    public ArbreDbException() {
    }

    /**
     * Constructs an instance of
     * <code>ArbreDbException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ArbreDbException(String msg) {
        super(msg);
    }
}
