package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {

	public boolean iscrivi(int matricola, String codins) {

		final String sql="INSERT INTO iscrizione (matricola, codins) " + 
				"(SELECT studente.matricola, corso.codins " +
				"FROM studente, corso " +
				"WHERE studente.matricola= ? AND corso.codins= ? ) ; " ;
				//Ricorda: Se devi inserire una stringa in un ? devi sempre mettere le '' ma non nella INSERT!!
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, matricola);
			st.setString(2, codins);

			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
			
		}
	}

	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<Corso> getTuttiICorsi() {

		final String sql = "SELECT * FROM corso";

		List<Corso> corsi = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

				// Crea un nuovo JAVA Bean Corso
				Corso corso=new Corso (codins,  numeroCrediti,  nome,  periodoDidattico);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				corsi.add(corso);
			}

			return corsi;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}
	
	
	public List<Corso> cercaCorsiDiStudente(int matricola){
		
		String sql="SELECT corso.* " + 
				"FROM corso, iscrizione " + 
				"WHERE iscrizione.matricola= ? AND iscrizione.codins=corso.codins; ";
	
		List<Corso> listaCorsi=new LinkedList<Corso>();
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			if(rs==null) {
				return null;
			}else {
				while (rs.next()) {

					String codins = rs.getString("codins");
					int numeroCrediti = rs.getInt("crediti");
					String nome = rs.getString("nome");
					int periodoDidattico = rs.getInt("pd");

					//System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);

					// Crea un nuovo JAVA Bean Corso
					Corso corso=new Corso (codins,  numeroCrediti,  nome,  periodoDidattico);
					// Aggiungi il nuovo oggetto Corso alla lista corsi
					listaCorsi.add(corso);
				}

				return listaCorsi;
			}

			
			
		}catch (SQLException e) {
			
			throw new RuntimeException("Errore Db");
		}
	}
	

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

	public List<Studente> cercaIscrittoCorso(Corso corso) {
		String sql="SELECT studente.* " + 
				"FROM studente, iscrizione " + 
				"WHERE iscrizione.codins= ? AND iscrizione.matricola=studente.matricola; ";
		Studente s=null;
		List<Studente> listaStudenti=new LinkedList<Studente>();
		
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso.getCodins());
			ResultSet rs = st.executeQuery();
			
			if(rs==null) {
				return null;
			}else {
				while (rs.next()) {
					s= new Studente(rs.getString("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("cds"));
					listaStudenti.add(s);
				}

				
			}

			return listaStudenti;
			
		}catch (SQLException e) {
			
			throw new RuntimeException("Errore Db");
		}
		
	}
}
