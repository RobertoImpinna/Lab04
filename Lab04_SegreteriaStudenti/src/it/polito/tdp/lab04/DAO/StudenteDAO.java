package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.lab04.model.*;



public class StudenteDAO {

	public StudenteDAO() {
		
	}
	
	
	public Studente cercaStudente(int matricola) {
		
		String sql="SELECT studente.* " + 
				"FROM studente " + 
				"WHERE matricola= ? ; ";
		Studente s=null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			if(rs==null) {
				return null;
			}else {
			
				while(rs.next() ){
					s= new Studente(rs.getString("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("cds"));
				}
				
			}
			conn.close();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return s;
	}
}
