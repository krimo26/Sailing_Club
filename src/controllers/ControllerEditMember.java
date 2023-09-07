package controllers;

/**
 * 
 * Edit member data controller
 * 
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerEditMember extends Controller{

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField addressField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    
    /**
     * 
     * Edit address method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     */
    
    public void editAddress(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	if (s.editMemberAddress(addressField.getText().toString())) {
    		this.extraStage("Success: Update Address", event, stage, scene, "SuccessGeneral.fxml");
    	}
    	else {
    		this.extraStage("Error: Update Address", event, stage, scene, "ErrorGeneral.fxml");	
    	}
    }
    
    /**
     * 
     * Edit username method: calls Sistema method
     * @param event
     * @throws IOException
     */
    
	public void editUsername(ActionEvent event) throws IOException{
		Sistema s = Sistema.getIstance();
    	if (s.editMemberUsername(usernameField.getText().toString())) {
    		this.extraStage("Success: Update Username", event, stage, scene, "SuccessGeneral.fxml");
    	}
    	else {
    		this.extraStage("Error: Update Username", event, stage, scene, "ErrorGeneral.fxml");
    	}    	
	}

	/**
	 * 
	 * Edit password method: calls Sistema method
	 * 
	 * @param event
	 * @throws IOException
	 */
	
	public void editPassword(ActionEvent event) throws IOException{
		Sistema s = Sistema.getIstance();
    	if (s.editMemberPassword(passwordField.getText().toString())) {
    		this.extraStage("Success: Update Password", event, stage, scene, "SuccessGeneral.fxml");	
    	}
    	else {
    		this.extraStage("Error: Update PAssword", event, stage, scene, "ErrorGeneral.fxml");	
    	}
	}

	/**
	 * 
	 * Back menu method
	 * @param event
	 * @throws IOException
	 */
	
	public void backMenu(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MemberProfile.fxml");
        System.out.println("Member Profile");
	}

}
