package controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	Stage window;
	public static void main(String[] args) {
		launch(args);
	}

	
	//the main opens the app from the login screen
	@Override
	public void start(final Stage primaryStage)throws Exception 
	{	
		try {
			Parent StartRoot=FXMLLoader.load(getClass().getResource("Start.fxml"));
			primaryStage.setTitle("Sailing Club");
			primaryStage.setScene(new Scene(StartRoot));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}		
}

