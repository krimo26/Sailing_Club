package controllers;

/**
 * 
 * New transfer controller
 * 
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerNewTransfer extends Controller{

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField transferField;
    
    /**
     * 
     * New transfer method: calls the Sistema method
     * 
     * @param event
     * @throws IOException
     */
    
    public void newTransfer(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	
    	if (s.addTransfer(transferField.getText().toString())) {
			this.changeScene(event,stage,scene,"MemberProfile.fxml");
			this.extraStage("Success", event, stage, scene, "SuccessGeneral.fxml");
            System.out.println("Success");
		}
		else {
			this.extraStage("New Transfer Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("New Transfer Error");
		}
    	
    }
    
    /**
     * 
     * Back to profile method
     * @param event
     * @throws IOException
     */
    
	public void backProfile(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MemberProfile.fxml");
        System.out.println("Member profile");
	}

}
