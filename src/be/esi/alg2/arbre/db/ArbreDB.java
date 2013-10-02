/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.alg2.arbre.db;

import be.esi.alg2.arbre.dto.ArbreCompletDto;
import be.esi.alg2.arbre.dto.ArbreDto;
import be.esi.alg2.arbre.mvc.Valeur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe utilitaire d'accès aux arbres persistants
 */
public class ArbreDB {

    public static void saveArbre(ArbreCompletDto aDto) throws ArbreDbException {
        try {
            String query = "INSERT INTO ArbreBinaire(nom, ts) " + " values(?, ?)";

            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert = connexion.prepareStatement(query);
            insert.setString(1, aDto.getId());
            insert.setTimestamp(2, new java.sql.Timestamp(aDto.getTimesTamp().getTime()));
            insert.execute();
            query = "INSERT INTO Noeud (cle, libelle, nomArbre, numOrdre) " + " values(?, ?, ?, ?)";
            insert = connexion.prepareStatement(query);
            int i = 1;
            for (Valeur v : aDto.getListe()) {
                insert.setInt(1, v.getCle());
                insert.setString(2, v.getLibelle());
                insert.setString(3, aDto.getId());
                insert.setInt(4, i);
                insert.execute();
                i++;
            }
        } catch (SQLException ex) {
            throw new ArbreDbException("Ajout d'arbre impossible:\r SQLException: " + ex.getMessage());
        }
    }



    public static List<ArbreDto> listeNoms(String debNom) throws ArbreDbException {
            try {
                
            String query = "SELECT nom FROM ArbreBinaire where nom like ? ";
            
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt = connexion.prepareStatement(query);
            debNom+="%";
            stmt.setString(1, debNom);

            java.sql.ResultSet rs = stmt.executeQuery();
            List<ArbreDto> liste = new ArrayList();
            while (rs.next()) {
                liste.add(new ArbreDto(rs.getString("nom")));
            }

            
            return liste;
        } catch (SQLException e) {
            
            throw new ArbreDbException();
        }
    }

    public static ArbreCompletDto chargeArbre(String nom) throws ArbreDbException {
        try {
            String query = "SELECT cle, libelle  FROM Noeud where nomArbre=? Order by numOrdre ";

            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, nom);

            java.sql.ResultSet rs = stmt.executeQuery();
            List<Valeur> liste = new ArrayList<Valeur>();
            while (rs.next()) {
                liste.add(new Valeur(rs.getInt("cle"), rs.getString("libelle")));
            }

            ArbreCompletDto arbreDto = new ArbreCompletDto(nom, new Date(), liste);
            return arbreDto;
        } catch (SQLException e) {
            throw new ArbreDbException();
        }
    }
    public static boolean deleteArbre(String nom) throws ArbreDbException {
        try {
            String query = "DELETE FROM APP.NOEUD WHERE NOMARBRE = ?";

            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, nom);
            
            boolean b = stmt.execute();
            query = "DELETE FROM APP.ARBREBINAIRE WHERE NOM = ?";

             connexion = DBManager.getConnection();
            stmt = connexion.prepareStatement(query);
            stmt.setString(1, nom);
            
            boolean c = stmt.execute();
            return b&&c;
            
        } catch (SQLException e) {
            throw new ArbreDbException();
        }
    }
}
