/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinoserver.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import twinoserver.modele.Tache;
import twinoserver.modele.TacheAtom;
import java.util.LinkedList;

/**
 *
 * @author delecoua
 */


public class TacheDAO extends AbstractDataBaseDAO {

    public TacheDAO(DataSource ds) {
        super(ds);
    }

    /**
     * Renvoie la liste des taches de la table tache sous la forme d'une liste
     * pour un commanditaire donné
     */
    public LinkedList<Tache> getListeTaches(String adresseMail) throws DAOException {
        LinkedList<Tache> result = new LinkedList<Tache>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
         Statement st =null;
        try {
            conn = getConnection();
           st = conn.createStatement();
            requeteSQL = "select * from tache where adresseMailCom='"
                    + adresseMail + "'";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                Tache t = new Tache(rs.getInt("numTache"), rs.getString("description"),
                        rs.getString("adresseMailCom"),
                        this.getListeTacheAtom(rs.getInt("numTache")));
                result.add(t);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getListeTache)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;
    }

    /**
     * Renvoie la liste des taches atomiques de la table tacheAtom sous la forme
     * d'une liste associée au numéro de tache numTache
     */
    private LinkedList<TacheAtom> getListeTacheAtom(int numTache) throws DAOException {
        LinkedList<TacheAtom> result = new LinkedList<TacheAtom>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        TacheAtom ta;
        Statement st =null;
        try {
            conn = getConnection();
           st = conn.createStatement();
            requeteSQL = "select * from tacheAtomique where numTache='" + numTache + "'";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                ta = new TacheAtom(rs.getInt("numTacheAtomique"), rs.getInt("numTache"),
                        rs.getFloat("latitudeT"), rs.getFloat("longitudeT"),
                        rs.getString("dateTot").substring(0, 10),
                        rs.getString("dateTard").substring(0, 10), rs.getString("titre"),
                        rs.getString("description"), rs.getFloat("remuneration"),
                        rs.getInt("estPaye"), rs.getInt("estEffectue"),
                        rs.getString("adresseMailExec"));
                result.add(ta);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getListeTacheAtom -- numTache)"
                    + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;

    }

    /**
     * Renvoie la liste des taches atomiques de la table tacheAtom sous la forme
     * d'une liste associée à l'adresse mail de l'executant
     */
    public LinkedList<TacheAtom> getListeTacheAtom(String adresseMailExec) throws DAOException {
        LinkedList<TacheAtom> result = new LinkedList<TacheAtom>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        TacheAtom ta;
        Statement st =null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "select * from tacheAtomique where adresseMailExec='"
                    + adresseMailExec + "'";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                ta = new TacheAtom(rs.getInt("numTacheAtomique"),
                        rs.getInt("numTache"), rs.getFloat("latitudeT"),
                        rs.getFloat("longitudeT"),
                        rs.getString("dateTot").substring(0, 10),
                        rs.getString("dateTard").substring(0, 10), rs.getString("titre"),
                        rs.getString("description"), rs.getFloat("remuneration"),
                        rs.getInt("estPaye"), rs.getInt("estEffectue"),
                        rs.getString("adresseMailExec"));
                result.add(ta);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getListeTacheAtom -- adresseMailExec)"
                    + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;

    }

    /**
     * Renvoie la tache atomique associé au numéro numTache voulu et au numero
     * numTacheAtomique voulu
     */
    public TacheAtom getTacheAtom(int numTache, int numTacheAtom) throws DAOException {
        TacheAtom result = null;
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        Statement st =null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "select * from tacheAtomique where numTache=" + numTache
                    + " and numTacheAtomique=" + numTacheAtom;
            rs = st.executeQuery(requeteSQL);
            rs.next();
            result = new TacheAtom(rs.getInt("numTacheAtomique"),
                    rs.getInt("numTache"), rs.getFloat("latitudeT"), rs.getFloat("longitudeT"),
                    rs.getString("dateTot").substring(0, 10),
                    rs.getString("dateTard").substring(0, 10), rs.getString("titre"),
                    rs.getString("description"), rs.getFloat("remuneration"),
                    rs.getInt("estPaye"), rs.getInt("estEffectue"),
                    rs.getString("adresseMailExec"));
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getTacheAtom)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;

    }

    /**
     * Renvoie l'adresseMail du commanditaire d'une tache
     */
    public String getAdresseDest(int numTache) throws DAOException {
        String result = null;
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        Statement st =null;
        try {
            conn = getConnection();
             st = conn.createStatement();
            requeteSQL = "select distinct adresseMailCom from tache where numTache=" + numTache;
            rs = st.executeQuery(requeteSQL);
            rs.next();
            result = rs.getString("adresseMailCom");
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getAdresseDest)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;

    }

    /**
     * Ajoute la tache globale dans la table tache. Attention faire une
     * transaction pour la suite d'instruction qui suit !
     */
    public int ajouterTache(String description, String adresseMailCom) throws DAOException {
        Connection conn = null;
        ResultSet rs = null;
        String requeteSQL = "";
        int numTache = 0;
        PreparedStatement st =null;
        try {
            conn = getConnection();
             st = conn.prepareStatement(
                    "insert into tache(description,adresseMailCom) values(?,?)");
            st.setString(1, description);
            st.setString(2, adresseMailCom);
            st.executeUpdate();

            Statement test = conn.createStatement();
            requeteSQL = "select max(numTache) from tache";
            rs = test.executeQuery(requeteSQL);
            rs.next();
            numTache = rs.getInt("max(numTache)");

        } catch (SQLException e) {
            throw new DAOException("Erreur BD (ajouterTache)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
            return numTache;
        }
    }

    /**
     * Ajout de compétences dans la table requiert
     */
    public void addCompetences(LinkedList<String> competences, int numTache,
            int numTacheAtomique) throws DAOException {
        Connection conn = null;
        PreparedStatement st =null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            for (String compet : competences) {
                 st = conn.prepareStatement(
                        "insert into requiert(numTache,numTacheAtomique,"
                        + "typeCompetence) values(?,?,?)");
                st.setInt(1, numTache);
                st.setInt(2, numTacheAtomique);
                st.setString(3, compet);
                st.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (addCompetences)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    /**
     * Ajoute la tache atomique dans la table tacheAtomique en mettant des
     * paramètres à des valeurs par défaut.
     */
    public int ajouterTacheAtomique(int numTache, String titre, String description,
            String dateTot, String dateTard, float latitudeT, float longitudeT,
            float remuneration) throws DAOException {
        Connection conn = null;
        String requeteSQL = "";
        ResultSet rs = null;
        int numTacheAtomique = 0;
        PreparedStatement st = null;
        try {
            conn = getConnection();
             st = conn.prepareStatement(
                    "insert into tacheAtomique(numTache,latitudeT,longitudeT,"
                    + "dateTot,dateTard,titre,description,remuneration,"
                    + "estPaye,estEffectue,adresseMailExec) "
                    + "values(?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?,?,?)");
            st.setInt(1, numTache);
            st.setFloat(2, latitudeT);
            st.setFloat(3, longitudeT);
            st.setString(4, dateTot);
            st.setString(5, dateTard);
            st.setString(6, titre);
            st.setString(7, description);
            st.setFloat(8, remuneration);
            st.setInt(9, 0);
            st.setInt(10, 0);
            st.setString(11, "");
            st.executeUpdate();

            Statement test = conn.createStatement();
            requeteSQL = "select max(numTacheAtomique) from tacheAtomique";
            rs = test.executeQuery(requeteSQL);
            rs.next();
            numTacheAtomique = rs.getInt("max(numTacheAtomique)");

        } catch (SQLException e) {
            throw new DAOException("Erreur BD (ajouterTacheAtomique)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return numTacheAtomique;
    }

    /**
     * Renvoie une liste de compétences possibles contenues dans la table
     * requiert -- public
     */
    public LinkedList<String> getCompetences(int numTache, int numTacheAtomique) throws DAOException {
        LinkedList<String> result = new LinkedList<String>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
         Statement st =null;       
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "SELECT * FROM requiert where numTache=" + numTache
                    + " and numTAcheAtomique=" + numTacheAtomique;
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                result.add(rs.getString("typeCompetence"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getCompetences sans adresseMail)"
                    + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;
    }

    /**
     * Renvoie une liste de compétences possibles contenues dans la table
     * competence -- public
     */
    public LinkedList<String> getCompetences() throws DAOException {
        LinkedList<String> result = new LinkedList<String>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        Statement st = null;
        try {
            conn = getConnection();
            st = conn.createStatement();
            requeteSQL = "SELECT * FROM competence";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                result.add(rs.getString("typeCompetence"));
            }
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getCompetences sans adresseMail)"
                    + e.getMessage(), e);
        } finally {
            
            closeConnection(conn,rs,st);
           
        }
        return result;
    }

    /**
     * Modifie la tache de numero de tache numTache et de numero de tache
     * atomique numTacheAtom
     */
    public void modifierTache(int numTache, int numTacheAtom, String titre,
            String description, String dateTot, String dateTard, float latitudeT,
            float longitudeT, float remuneration, String[] competences) throws DAOException {
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> tableCompetence = new LinkedList<String>();
        PreparedStatement st=null;
        try {
            conn = getConnection();

            //On met à jour le profil de la tache
             st = conn.prepareStatement(
                    "UPDATE tacheAtomique SET titre = ?, description = ?, "
                    + "dateTot = TO_DATE('" + dateTot + "','YYYY-MM-DD'), "
                    + "dateTard = TO_DATE('" + dateTard + "','YYYY-MM-DD'), "
                    + "latitudeT = ?, longitudeT = ?, "
                    + "remuneration=? WHERE numTache = ? and numTacheAtomique = ?");
            st.setString(1, titre);
            st.setString(2, description);
            st.setFloat(3, latitudeT);
            st.setFloat(4, longitudeT);
            st.setFloat(5, remuneration);
            st.setInt(6, numTache);
            st.setInt(7, numTacheAtom);
            st.executeUpdate();

            //On récupère dans tableCompetence les différentes compétences possibles
            tableCompetence = getCompetences();

            //On met à jour les compétences dans la table possede -- attention adresseMail pour l'instant mais avec session ce sera autre chose !
            requeteSQL = "DELETE from requiert WHERE numTache=" + numTache
                    + " and numTacheAtomique=" + numTacheAtom;
            st.executeQuery(requeteSQL);
            if (competences != null) {
                for (String s : competences) {
                    st = conn.prepareStatement(
                            "insert into requiert(numTache,numTacheAtomique,"
                            + "typeCompetence) values(?,?,?)");
                    st.setInt(1, numTache);
                    st.setInt(2, numTacheAtom);
                    st.setString(3, s);
                    st.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (modifierTache)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    /**
     * Recherche les annonces qui correspondent aux critères passés en
     * paramètre.
     */
    public LinkedList<TacheAtom> search(String[] competences, String dateTot,
            String dateTard, float latitude, float longitude, float remuneration, int distance, String adresseMailCom) throws DAOException {
        String requeteSQL = "";
        Connection conn = null;
        ResultSet rs = null;
        LinkedList<TacheAtom> result = new LinkedList<TacheAtom>();
        TacheAtom ta;
        int i = 1;
        Statement st =null;
        try {
            conn = getConnection();
             st = conn.createStatement();
            requeteSQL = "select distinct ta.numTache, ta.numTacheAtomique, "
                    + "titre, ta.description, dateTot, dateTard, latitudeT, "
                    + "longitudeT, remuneration, adresseMailExec, EstPaye, "
                    + "estEffectue FROM tacheAtomique ta";
            if (competences != null) {
                requeteSQL += ",requiert r";
            }
            if (adresseMailCom != null) {
                requeteSQL = requeteSQL + ", tache t ";
            }
            requeteSQL += " where ta.numTache > 0 ";
            if (competences != null) {
                requeteSQL += " and ta.numTache=r.numTache and ta.numTacheAtomique=r.numTacheAtomique and (";
                for (String compet : competences) {
                    if (i != competences.length) {
                        requeteSQL = requeteSQL + " typeCompetence='" + compet + "' or";
                    } else {
                        requeteSQL = requeteSQL + " typeCompetence='" + compet + "'";
                    }
                    i++;
                }
                // en mettant cette condition on ne prend que les tâches qui ne sont pas déjà prises
                requeteSQL += ") and adresseMailExec is null";
            } else {
                //pour mettre le where quelque chose si pas de competences et que cela ne pose pas de pbs par la suite
                requeteSQL += " and adresseMailExec is null";
            }
            //là on va s'arranger pour avoir ne pas avoir les tâches de celui qui les cherchent
            if (adresseMailCom != null) {
                requeteSQL = requeteSQL + " and t.adresseMailCom !='" + adresseMailCom + "' and ta.numTache=t.numTache";
            }
            if (!dateTot.equals("")) {
                requeteSQL = requeteSQL + " and dateTot >= TO_DATE('"
                        + dateTot + "','YYYY-MM-DD')";
            }
            if (!dateTard.equals("")) {
                requeteSQL = requeteSQL + " and dateTard <= TO_DATE('"
                        + dateTard + "','YYYY-MM-DD')";
            }
            //valeur de 1000 si jamais aucune valeur n'a été rentrée sur la page rechercher.jsp
            if (longitude != 1000 && latitude != 1000 & distance >= 0) {
                requeteSQL = requeteSQL + " and sqrt((latitudeT- ("
                        + latitude + "))*(latitudeT- (" + latitude
                        + ")) +(longitudeT - (" + longitude + "))*(longitudeT - ("
                        + longitude + ")))*40075.864/360 < " + distance;
            }
            if (remuneration > 0) {
                requeteSQL = requeteSQL + " and remuneration <" + remuneration;
            }
            requeteSQL += " Group by ta.numTache, ta.numTacheAtomique,titre, ta.description, dateTot, dateTard, latitudeT,longitudeT, remuneration, adresseMailExec, EstPaye,estEffectue";

            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                ta = new TacheAtom(rs.getInt("numTacheAtomique"), rs.getInt("numTache"),
                        rs.getFloat("latitudeT"), rs.getFloat("longitudeT"),
                        rs.getString("dateTot").substring(0, 10),
                        rs.getString("dateTard").substring(0, 10),
                        rs.getString("titre"), rs.getString("description"),
                        rs.getFloat("remuneration"), rs.getInt("estPaye"),
                        rs.getInt("estEffectue"), rs.getString("adresseMailExec"));
                result.add(ta);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (search)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
        return result;
    }

    /**
     * Supprime l'ouvrage d'identifiant id dans la table tache.
     */
    public void supprimerTache(int numTache, int numTacheAtomique) throws DAOException {
        String requeteSQL = "";
        Connection conn = null;
        ResultSet rs = null;
        Statement st =null;
        try {
            conn = getConnection();
             st = conn.createStatement();
            requeteSQL = "DELETE FROM requiert WHERE numTache=" + numTache
                    + " and numTacheAtomique= " + numTacheAtomique;
            st.executeQuery(requeteSQL);
            requeteSQL = "DELETE FROM tacheAtomique WHERE numTache=" + numTache
                    + " and numTacheAtomique= " + numTacheAtomique;
            st.executeQuery(requeteSQL);
            requeteSQL = "Select * from tacheAtomique WHERE numTache=" + numTache;
            rs = st.executeQuery(requeteSQL);
            rs.next();
            if (rs.next() == false) {//on supprime l'entrée dans tache si il n'y a plus de taches atomiques qui li sont liées
                requeteSQL = "DELETE FROM tache WHERE numTache=" + numTache;
                st.executeQuery(requeteSQL);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (supprimerTache)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    /**
     * Met l'executant d'une tache à jour
     */
    public void execute(int numTache, int numTacheAtomique, String adresseMailExec) throws DAOException {
        Connection conn = null;
         PreparedStatement st=null;
         ResultSet rs = null;
        try {
            conn = getConnection();
            st = conn.prepareStatement(
                    "UPDATE tacheAtomique SET adresseMailExec=? "
                    + "WHERE numTache = ? and numTacheAtomique = ?");
            st.setString(1, adresseMailExec);
            st.setInt(2, numTache);
            st.setInt(3, numTacheAtomique);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Erreur BD (execute)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    /**
     * Met l'executant d'une tache à null pour l'enlever des tâches en cours
     * d'exécution
     */
    public void annulerTache(int numTache, int numTacheAtomique) throws DAOException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement st=null;
        try {
            conn = getConnection();
            st = conn.prepareStatement(
                    "UPDATE tacheAtomique SET adresseMailExec=? "
                    + "WHERE numTache = ? and numTacheAtomique = ?");
            st.setString(1, null);
            st.setInt(2, numTache);
            st.setInt(3, numTacheAtomique);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (annulerTache)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }

    public void effectue(int numTache, int numTacheAtomique) throws DAOException {
        Connection conn = null;
        PreparedStatement st=null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            st = conn.prepareStatement(
                    "UPDATE tacheAtomique SET estEffectue=? "
                    + "WHERE numTache = ? and numTacheAtomique = ?");
            st.setInt(1, 1);
            st.setInt(2, numTache);
            st.setInt(3, numTacheAtomique);
            st.executeUpdate();

            st = conn.prepareStatement(
                    "UPDATE tacheAtomique SET estPaye=? "
                    + "WHERE numTache = ? and numTacheAtomique = ?");
            st.setInt(1, 1);
            st.setInt(2, numTache);
            st.setInt(3, numTacheAtomique);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (execute)" + e.getMessage(), e);
        } finally {
            closeConnection(conn,rs,st);
        }
    }
}
