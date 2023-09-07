package controllers;

/**
 * 
 * Login controller
 * 
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControllerLogin extends Controller {
	
	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton memberButton;
    @FXML
    private RadioButton staffButton;
    @FXML
    private ToggleGroup type;
    
    
    /**
     * 
     * Login method: call Sistema method and opens memberMenu or staffMenu
     * @param event
     * @throws IOException
     */
    
    public void login(ActionEvent event) throws IOException{
        	Sistema s = Sistema.getIstance();
        	if(this.type.getSelectedToggle().equals(this.memberButton)) {
        		if (s.loginMember(usernameField.getText().toString(), passwordField.getText().toString())) {
        			this.changeScene(event,stage,scene,"MemberMenu.fxml");
        			
                    System.out.println("Login member");
        		}
        		else {
        			this.extraStage("Error Login", event, stage, scene, "ErrorGeneral.fxml");
        			System.out.println("Error Login Member");
        		}
        		
        	}
        	
        	else if(this.type.getSelectedToggle().equals(this.staffButton)) {
        		if (s.loginStaff(usernameField.getText().toString(), passwordField.getText().toString())) {
        			this.changeScene(event,stage,scene,"StaffMenu.fxml");
                    System.out.println("Login staff");
        		}
        		else {
        			this.extraStage("Error Login", event, stage, scene, "ErrorGeneral.fxml");
        			System.out.println("Error Login Staff");
        		}
        		
        	}
        	    	
    }
    
    /**
     * 
     * Opens registration scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void registration(ActionEvent event)  throws IOException{
    	this.changeScene(event,stage,scene,"Registration.fxml");
        System.out.println("Registration");
    }
    
    /**
     * 
     * End system method: calls Sistema method
     * @param event
     * @throws IOException
     */
    
    public void close(ActionEvent event)  throws IOException{
    	Sistema s = Sistema.getIstance();
    	s.endSystem();
    	System.out.println("End System");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

}
