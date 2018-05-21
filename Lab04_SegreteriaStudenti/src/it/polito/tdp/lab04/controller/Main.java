package it.polito.tdp.lab04.controller;

import it.polito.tdp.lab04.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {
			//fare il loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SegreteriaStudenti.fxml"));
			BorderPane root = (BorderPane) loader.load();
			
			//fare la scena
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//fare oggetto di tipo model
			Model model=new Model();
			
			//Prendo il controller dal loader ( perche il controller è creato dalla scena).
			//Al controlle gli setto il suo modello con quello che ho appena crato nel main
			SegreteriaStudentiController controller = loader.getController();
			controller.setModel(model);
			
			
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
