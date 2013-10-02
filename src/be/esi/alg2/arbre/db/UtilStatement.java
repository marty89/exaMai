package be.esi.alg2.arbre.db;

import java.sql.SQLException;

/**
 * Classe utilitaire de fonctionnalités liées à JDBC
 */
public class UtilStatement {

    static void setInteger(java.sql.PreparedStatement stmt, int pos, Integer value) throws SQLException{
        if (value == null)
            stmt.setNull(pos, java.sql.Types.INTEGER);
        else
            stmt.setInt(pos, value);
    }

}
