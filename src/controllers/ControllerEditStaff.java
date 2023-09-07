package controllers;

/**
 * 
 * Edit staff data controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ControllerEditStaff extends Controller implements Initializable {

	private Stage stage;
    private Scene scene;
    
    @FXML
    private Label usernameLabel;
    @FXML
    private PasswordField passwordField;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	this.usernameLabel.setText(s.getStaffLogged().getUsername());
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
    	if (s.editStaffPassword(passwordField.getText().toString())) {
    		this.extraStage("Success: Update Password", event, stage, scene, "SuccessGeneral.fxml");	
    	}
    	else {
    		this.extraStage("Error: Update PAssword", event, stage, scene, "ErrorGeneral.fxml");	
    	}
	}
    
    /**
     * 
     * Back menu method
     * 
     * @param event
     * @throws IOException
     */
    
	public void backMenu(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"StaffMenu.fxml");
        System.out.println("Staff menu");
	}

}
