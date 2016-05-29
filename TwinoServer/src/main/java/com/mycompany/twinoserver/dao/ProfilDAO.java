/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twinoserver.dao;

import com.mycompany.twinoserver.modele.Profil;
import com.mycompany.twinoserver.modele.Tache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

public class ProfilDAO extends AbstractDataBaseDAO {

    public ProfilDAO(DataSource ds) {
        super(ds);
    }

    /**
     * Ajoute un profil dans la base utilisateur (uniquement).
     */
    public void ajouterUtilisateur(String adresseMail, String mdp, String nom, String prenom, int sexe, String dateNaissance, double latitudeU, double longitudeU, String[] competences) throws DAOException {
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = getConnection();

            //Ajout d'un utilisateur dans la table utilisateur
            PreparedStatement st = conn.prepareStatement(
            "insert into utilisateur(adresseMail,mdp,sexe,nom,prenom,dateNaissance,latitudeU,longitudeU) values(?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?)");
 st.setString(1, adresseMail);
            st.setString(2, mdp);
            st.setInt(3, sexe);
            st.setString(4, nom);
            st.setString(5, prenom);
            st.setString(6, dateNaissance);
            st.setDouble(7,  latitudeU);
            st.setDouble(8,  longitudeU);
            st.executeUpdate();

            //Ajout d'un utilisateur dans la table possede pour avoir acces à ses compétences
            if (competences != null) {
                for (String comp : competences) {
                    st = conn.prepareStatement("insert into possede(adresseMailExec,typeCompetence) values(?,?)");
                    st.setString(1, adresseMail);
                    st.setString(2, comp);
                    st.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (ajouterUtilisateur)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Récupère le profil d'un utilisateur d'identifiant adresseMail.
     */
    public Profil getProfil(String adresseMail) throws DAOException {
        Profil result;
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        LinkedList<String> competences = new LinkedList();
        //competences=this.getCompetences(adresseMail);
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            requeteSQL = "SELECT * FROM utilisateur WHERE adresseMail='" + adresseMail + "'";
            rs = st.executeQuery(requeteSQL);
            rs.next();
            result = new Profil(rs.getString("adresseMail"), rs.getString("mdp"), rs.getString("nom"), rs.getString("prenom"), rs.getString("sexe"), rs.getString("dateNaissance").substring(0, 10), rs.getFloat("latitudeU"), rs.getFloat("longitudeU"), competences);
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getProfil)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return result;
    }

    /**
     * Renvoie une liste de compétences à partir d'une adresse e-mail -- public
     */
    public LinkedList<String> getCompetences(String adresseMail) throws DAOException {
        LinkedList<String> result = new LinkedList<String>();
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            requeteSQL = "SELECT typeCompetence FROM possede WHERE adresseMailExec='" + adresseMail + "'";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                result.add(rs.getString("typeCompetence"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getCompetences avec adresseMail)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
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
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            requeteSQL = "SELECT * FROM competence";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                result.add(rs.getString("typeCompetence"));
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getCompetences sans adresseMail)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return result;
    }

    /**
     * Modifie le profil d'identifiant adresseMail dans utilisateur avec les
     * nouveaux paramètres spécifiés Par contre non modification possible avec
     * cette methode de l'adresseMail
     */
    public void modifierProfil(String adresseMail, String mdp, String nom, String prenom, String dateNaissance, int sexe, double latitudeU, double longitudeU, String[] competences) throws DAOException, IllegalArgumentException {
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<String> tableCompetence = new LinkedList<String>();
        try {
            conn = getConnection();

            //On met à jour le profil de l'utilisateur
            PreparedStatement st = conn.prepareStatement(
                    "UPDATE utilisateur SET mdp = ?, nom = ?, prenom = ?, sexe = ?, dateNaissance = TO_DATE('" + dateNaissance + "','YYYY-MM-DD'),latitudeU = ?, longitudeU = ? WHERE adresseMail = ?");
            st.setString(1, mdp);
            st.setString(2, nom);
            st.setString(3, prenom);
            st.setInt(4, sexe);
            st.setDouble(5, latitudeU);
            st.setDouble(6, longitudeU);
            st.setString(7, adresseMail);
            st.executeUpdate();

            //On récupère dans tableCompetence les différentes compétences possibles
            tableCompetence = this.getCompetences();

            //On met à jour les compétences dans la table possede -- attention adresseMail pour l'instant mais avec session ce sera autre chose !
            requeteSQL = "DELETE from possede WHERE adresseMailExec='" + adresseMail + "'";
            st.executeQuery(requeteSQL);
            if (competences != null) {
                for (String s : competences) {
                    requeteSQL = "INSERT INTO possede(adresseMailExec,typeCompetence) VALUES ('" + adresseMail + "','" + s + "')";
                    st.executeQuery(requeteSQL);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (modifierProfil)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    /**
     * Supprime le profil d'identifiant adresseMail dans la table utilisateur et
     * de possede. Attention pas fini pour l'instant
     */
    public void supprimerProfil(String adresseMail) throws DAOException {
        String requeteSQL = "";
        Connection conn = null;
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            requeteSQL = "DELETE FROM omaraz.utilisateur WHERE adresseMail=" + adresseMail;
            requeteSQL = "DELETE FROM omaraz.possede WHERE adresseMail=" + adresseMail;
            st.executeQuery(requeteSQL);
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (supprimer)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
    }

    public Profil verifieconnexion(String login, String mdp) throws DAOException {
        Profil result = null;
        ResultSet rs = null;
        String requeteSQL = "";
        Connection conn = null;

        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            requeteSQL = "SELECT * FROM utilisateur WHERE adresseMail='" + login + "' AND mdp='" + mdp + "'";
            rs = st.executeQuery(requeteSQL);
            while (rs.next()) {
                result = new Profil(rs.getString("adresseMail"), rs.getString("mdp"), rs.getString("nom"), rs.getString("prenom"), rs.getString("sexe"), rs.getString("dateNaissance").substring(0, 10), rs.getInt("latitudeU"), rs.getInt("longitudeU"), null);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD (getProfil)" + e.getMessage(), e);
        } finally {
            closeConnection(conn);
        }
        return result;
    }
}
