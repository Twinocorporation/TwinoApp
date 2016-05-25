/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twinoserver.dao;
import com.mycompany.twinoserver.modele.Evaluation;
import java.awt.PageAttributes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.sql.DataSource;

/**
 *
 * @author radissoa
 */
public class EvaluerDAO extends AbstractDataBaseDAO {

	public EvaluerDAO(DataSource ds) {
    	super(ds);
	}

	public void ajouterEvaluation(int numtache, int numtacheatomique, String adressemailcom, int note, String commentaire) throws DAOException {
    	Connection conn = null;
    	ResultSet rs = null;
    	String requeteSQL = "";
    	try {
        	conn = getConnection();

        	//Ajout d'un utilisateur dans la table utilisateur
        	Statement st = conn.createStatement();
        	requeteSQL = "insert into evalue(numtache,numtacheatomique,adressemailcom,note,commentaire) values("+ numtache + "," + numtacheatomique + ",'" +adressemailcom + "'," + note + ",'" + commentaire + "')";
    
        	rs= st.executeQuery(requeteSQL);

    	} catch (SQLException e) {
        	throw new DAOException("Erreur BD (ajouterEvaluation)" + e.getMessage(), e);
    	} finally {
        	closeConnection(conn);
    	}
	}

	public LinkedList<Evaluation> getListeEval(String adresseMailUtil) throws DAOException {
    	LinkedList<Evaluation> result = new LinkedList<>();
    	ResultSet rs = null;
    	String requeteSQL = "";
    	Connection conn = null;
    	LinkedList<String> competences = new LinkedList();
    	//competences=this.getCompetences(adresseMail);
    	try {
        	conn = getConnection();
        	Statement st = conn.createStatement();
        	requeteSQL = "SELECT note,commentaire FROM evalue WHERE adresseMailCom='" + adresseMailUtil + "'";
        	rs = st.executeQuery(requeteSQL);
        	while(rs.next())
            	result.add(new Evaluation(rs.getInt("note"), rs.getString("commentaire")));
    	} catch (SQLException e) {
        	throw new DAOException("Erreur BD (getListeEval)" + e.getMessage(), e);
    	} finally {
        	closeConnection(conn);
    	}
    	return result;
	}
}
