package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.*;

public class Model {
	
	CorsoDAO cd=new CorsoDAO();
	StudenteDAO sd=new StudenteDAO();
	
	
	
	public Model() {
		
	}
	
	public List<Corso> ListaCorsi(){
		return cd.getTuttiICorsi();
	}
	
	public Studente CercaStudente(int matricola) {
		return sd.cercaStudente(matricola);
	}
	
	public List<Corso> cercaCorsi(int matricola){
		return cd.cercaCorsiDiStudente(matricola);
	}
	
	public List<Studente> cercaIscrittiCorso(Corso corso){
		return cd.cercaIscrittoCorso(corso); 
	}
	
	public int iscrivi(int matricola, String codins) {
		
		if(this.CercaStudente(matricola)!=null) {
			if( cd.iscrivi(matricola, codins)==true)
				return 1;
			else
				return 2;
		}
		else
			return 3;
	}
	
}