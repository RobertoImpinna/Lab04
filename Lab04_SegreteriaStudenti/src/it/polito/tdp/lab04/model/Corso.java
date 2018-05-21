package it.polito.tdp.lab04.model;

public class Corso {
	
	//parametri
	String codins;
	int crediti;
	String nome;
	int periodoDidattico;
	
	//costruttore con parametri
	public Corso(String codins, int crediti, String nome, int periodoDidattico) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.periodoDidattico = periodoDidattico;
	}
	
	//getter and setter
	public String getCodins() {
		return codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public int getCrediti() {
		return crediti;
	}
	public void setCrediti(int crediti) {
		this.crediti = crediti;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPeriodoDidattico() {
		return periodoDidattico;
	}
	public void setPeriodoDidattico(int periodoDidattico) {
		this.periodoDidattico = periodoDidattico;
	}

	@Override
	public String toString() {
		return  codins +" "+ nome;
	}
	
	
	
	
	
}
