package controllers;

/**
 * 
 * New card controller
 * 
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerNewCard extends Controller{
	
	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField cardField;
    @FXML
    private PasswordField passwordField;
    
    /**
     * 
     * New card method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     */
    
    public void newCard(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	
    	if (s.addCard(cardField.getText().toString(), passwordField.getText().toString())) {
    		this.extraStage("Success", event, stage, scene, "SuccessGeneral.fxml");
			this.changeScene(event,stage,scene,"MemberProfile.fxml");
            System.out.println("Success");
		}
		else {
			this.extraStage("New Card Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("New Card Error");
		}
    	
    }
    
    /**
     * 
     * Back profile method
     * 
     * @param event
     * @throws IOException
     */
    
	public void backProfile(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MemberProfile.fxml");
        System.out.println("Member profile");
	}

}
