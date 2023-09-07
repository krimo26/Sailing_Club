package controllers;

/**
 * 
 * Registration controller
 * 
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerRegistration extends Controller{
	
	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    

    /**
     * 
     * Registration method
     * @param event
     * @throws IOException
     * 
     */
    
    public void registration(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	
    	if (s.registration(usernameField.getText().toString(), lastnameField.getText().toString(),
    			idField.getText().toString(), addressField.getText().toString(),
    			usernameField.getText().toString(),passwordField.getText().toString())) {
			this.changeScene(event,stage,scene,"MemberMenu.fxml");
			this.extraStage("Success", event, stage, scene, "SuccessRegistration.fxml");
            System.out.println("Success");
		}
		else {
			this.extraStage("Registration Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Registration Error");
		}
    }
    
    /**
     * 
     * Go back method (back to login scene)
     * @param event
     * @throws IOException
     */
    
    public void goBack(ActionEvent event) throws IOException {
        this.changeScene(event,stage,scene,"Login.fxml");
        System.out.println("Login");
    }

}
