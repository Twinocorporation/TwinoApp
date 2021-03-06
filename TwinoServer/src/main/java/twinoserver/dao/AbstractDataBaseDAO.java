/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twinoserver.dao;

import twinoserver.dao.DAOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * Classe abstraite permettant de factoriser du code pour les DAO basées sur
 * JDBC
 *
 * @author omaraz
 */
public abstract class AbstractDataBaseDAO {

    protected final DataSource dataSource;

    protected AbstractDataBaseDAO(DataSource ds) {
        this.dataSource = ds;
    }

    protected Connection getConnection() throws SQLException {
 
            return dataSource.getConnection();

    }

    /**
     * fermeture d'une connexion
     *
     * @param c la connexion à fermer
     * @throws DAOException si problème lors de la fermeture de la connexion
     */
    protected void closeConnection(Connection c, ResultSet rs, Statement st) throws DAOException {
         try {
    
        
            if (rs != null) {
                
        rs.close();
      }
            
      if (st != null) {
          
               
        st.close();
      }
      
          if (c != null) {
           
               
                c.close();
            }
      }
     
            
            catch (SQLException sqle) {
                throw new DAOException("Problème fermeture de connexion avec la BD ", sqle);
            }
        }

    }
