/*
 * DBManager.java
 */
package be.esi.alg2.arbre.db;


import java.sql.*;

/**
 * Offre les outils de connexion et de gestion de transaction. 
 */
public class DBManager {

    private static Connection connection;
    //private static MesParametresDeConnexion dbChoisie;

    /**
     * Mémorise la connexion passée en paramètre
     */
    public static void setConnection(Connection con) {
        connection = con;
    }

    /**
     * Retourne la connexion établie ou à défaut, l'établit
     */
    public static Connection getConnection() throws ArbreDbException {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:derby://localhost:1527/arbre", "app", "app");
            } catch (SQLException ex) {
                throw new ArbreDbException("Connexion impossible:\n" + ex.getMessage());
            }
        }
        return connection;
    }

    /**
     * débute une transaction
     */
    public static void startTransaction() throws ArbreDbException {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            throw new ArbreDbException("Impossible de démarrer une transaction");
        }
    }

    /**
     * débute une transaction en spécifiant son niveau d'isolation
     * Attention, ceci n'est pas implémenté sous Access!
     * (cette notion sera abordée ultérieurement dans le cours de bd)
     */
    public static void startTransaction(int isolationLevel) throws ArbreDbException {
        try {
            getConnection().setAutoCommit(false);

            int isol = 0;
            switch (isolationLevel) {
                case 0:
                    isol = java.sql.Connection.TRANSACTION_READ_UNCOMMITTED;
                    break;
                case 1:
                    isol = java.sql.Connection.TRANSACTION_READ_COMMITTED;
                    break;
                case 2:
                    isol = java.sql.Connection.TRANSACTION_REPEATABLE_READ;
                    break;
                case 3:
                    isol = java.sql.Connection.TRANSACTION_SERIALIZABLE;
                    break;
                default:
                    throw new ArbreDbException("Degré d'isolation inexistant!");
            }


            getConnection().setTransactionIsolation(isol);
        } catch (SQLException ex) {
            throw new ArbreDbException("Impossible de démarrer une transaction");
        }
    }

    /**
     * valide la transaction courante
     */
    public static void valideTransaction() throws ArbreDbException {
        try {
            getConnection().commit();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new ArbreDbException("Impossible de valider la transaction");
        }
    }

    /**
     * annule la transaction courante
     */
    public static void annuleTransaction() throws ArbreDbException {
        try {
            getConnection().rollback();
            getConnection().setAutoCommit(true);
        } catch (SQLException ex) {
            throw new ArbreDbException("Impossible d'annuler la transaction");
        }
    }
}
