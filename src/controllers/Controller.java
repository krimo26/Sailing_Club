package controllers;

/**
*
* General controller class with common methods of most of controllers
*
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
		
		/**
		 * 
		 * Change scene method
		 * 
		 * @param event
		 * @param stage
		 * @param scene
		 * @param fxmlfile
		 * @throws IOException
		 */
	
        public void changeScene(ActionEvent event, Stage stage, Scene scene, String fxmlfile) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlfile));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        
        /**
         * 
         * Extra stage method
         * 
         * @param title
         * @param event
         * @param stage
         * @param scene
         * @param fxmlfile
         * @throws IOException
         */
        
        public void extraStage(String title, ActionEvent event, Stage stage, Scene scene, String fxmlfile) throws IOException{
        	Stage extrastage= new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlfile));
            extrastage.setTitle(title);
            extrastage.setScene(new Scene(root));
            extrastage.setResizable(false);
            extrastage.initModality(Modality.APPLICATION_MODAL);
            extrastage.showAndWait();
        }
                

}
