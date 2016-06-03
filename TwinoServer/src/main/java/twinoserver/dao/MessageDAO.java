
package twinoserver.dao;

import twinoserver.modele.Message;
import twinoserver.modele.Tache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.sql.DataSource;

/**
 *
 * @author delecoua
 */
public class MessageDAO extends AbstractDataBaseDAO {

    public MessageDAO(DataSource ds) {
        super(ds);
    }

    /**
     * Renvoie une liste de message pour l'utilisateur destinataire (celui qui
     * possède les messages)
     */
    public LinkedList<Message> getListeMessages(String adresseMail) throws DAOException {
        LinkedList<Message> result = new LinkedList<Message>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        Statement st=null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "select * from messagerie where adresseMailDest='" + adresseMail + "' order by dateHeureMess desc";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                Message m = new Message(Integer.parseInt(rs.getString("numMessage")), rs.getString("titre"), rs.getString("message"), rs.getString("adresseMailExp"), rs.getString("adresseMailDest"), rs.getString("dateHeureMess").substring(0, 19), Integer.parseInt(rs.getString("estLu")));
                result.add(m);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getListeMessages)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;
    }

    /**
     * Renvoi le message correspondant au numero numMessage
     */
    public Message getMessage(int numMessage) throws DAOException {
        Message result;
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        Statement st=null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "select * from messagerie where numMessage=" + numMessage;
            rs = st.executeQuery(requeteSQL);
            rs.next();
            result = new Message(Integer.parseInt(rs.getString("numMessage")), rs.getString("titre"), rs.getString("message"), rs.getString("adresseMailExp"), rs.getString("adresseMailDest"), rs.getString("dateHeureMess").substring(0, 19), Integer.parseInt(rs.getString("estLu")));

        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getMessage)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;
    }

    /**
     * Ajoute un message dans la table messagerie
     */
    public void ajouterMessage(String titre, String message, String adresseMailExp, String adresseMailDest, int estLu) throws DAOException {
        Connection conn = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        try {
            conn = getConnection();
             st = conn.prepareStatement(
                    "insert into messagerie(dateHeureMess,titre,message,estLu,adresseMailExp,adresseMailDest) values(Current_timestamp,?,?,?,?,?)");
            st.setString(1, titre);
            st.setString(2, message);
            st.setInt(3, estLu);
            st.setString(4, adresseMailExp);
            st.setString(5, adresseMailDest);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (ajouterMessage)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    /**
     * Modifie le message dont le numéro de messages est connu est le déclare
     * comme lu
     */
    public void modifierMessage(int numMessage) throws DAOException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st=null;
        try {
            conn = getConnection();

             st = conn.prepareStatement(
                    "UPDATE messagerie SET estLu=? WHERE numMessage = ? ");
            st.setInt(1, 1);
            st.setInt(2, numMessage);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur BD (modifierMessage)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    /**
     * Supprime le message de numero numMessage
     */
    public void supprimerMessage(int numMessage) throws DAOException {
        String requeteSQL = "";
        Connection conn = null;
       Statement st=null;
        ResultSet rs = null;
       
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "DELETE FROM messagerie WHERE numMessage=" + numMessage;
            st.executeQuery(requeteSQL);
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (supprimerMessage)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

}
