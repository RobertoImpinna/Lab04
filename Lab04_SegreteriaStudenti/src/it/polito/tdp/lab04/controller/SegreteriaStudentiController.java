/**
 * Sample Skeleton for 'SegreteriaStudenti.fxml' Controller Class
 */

package it.polito.tdp.lab04.controller;
import it.polito.tdp.lab04.model.*;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.TextArea;

import it.polito.tdp.lab04.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.NumberStringConverter;

public class SegreteriaStudentiController {

	private Model model; //non creo l'oggetto, creco solo la variabile che con il setModel() (in basso) lo setto con quello che mi passa il main;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="mCorsi"
    private ChoiceBox<Corso> mCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="imgV"
    private ImageView imgV; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void cercaCorsi(ActionEvent event) {
    	if(txtMatricola.getText().equals("")==false) {
    	txtResult.clear();
    	String testo=txtMatricola.getText();
    	int matricola=Integer.parseInt(testo);
    	if(testo.equals("")==false) {
	    	List<Corso> lista=model.cercaCorsi(matricola);
	    	if(lista.size()!=0) {
	    		for(Corso c: lista) {
	    			txtResult.appendText(c.getCodins()+" "+c.getNome());
	    			txtResult.appendText("\n");
	    		}
	    	}
    	}
    	}
    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	
    	txtResult.clear();
    	Corso corso=mCorsi.getValue();
    	
	    	List<Studente> lista=model.cercaIscrittiCorso(corso);
	    	if(lista.size()!=0) {
	    		for(Studente s: lista) {
	    			txtResult.appendText(s.getMatricola()+" "+s.getCognome()+" "+s.getNome());
	    			txtResult.appendText("\n");
	    		
	    	}
    	}
    	
    }

    @FXML
    void iscrivi(ActionEvent event) {
    	if(txtMatricola.getText().equals("")==false) {
    	txtResult.clear();
    	int n=model.iscrivi(Integer.parseInt(txtMatricola.getText()), mCorsi.getValue().getCodins());
    	if(n==1){
    		txtResult.appendText("Utente Iscritto correttamente!\n");
    	}else if(n==2){
    		txtResult.appendText("WARNING! Utente già iscritto\n");
    	}else if(n==3){
    		txtResult.appendText("WARNING! Utente non trovato\n");
    	}
    	}
    }

    @FXML
    void onClear(ActionEvent event) {
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    }

    @FXML
    void onSearch(MouseEvent event) {
    	txtNome.clear();
    	txtCognome.clear();
    	String testo=txtMatricola.getText();
    	if(testo.equals("")==false) {
	    	int matricola=Integer.parseInt(testo);
	    	Studente s=model.CercaStudente(matricola);
	    	if(s!= null) {
	    		txtNome.setText(s.getNome());
	    		txtCognome.setText(s.getCognome());
	    	}
    	}


    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
        assert mCorsi != null : "fx:id=\"mCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert imgV != null : "fx:id=\"imgV\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";

        
    }

	public void setModel(Model model) {
		this.model = model;
		
		//Riempio il menu
    	List<Corso> corsi=model.ListaCorsi();
    	
    	mCorsi.setValue(corsi.get(0));
    	mCorsi.getItems().addAll(corsi);
	}

	
}
