package controllers;

/**
 * 
 * New boat controller
 * 
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerNewBoat extends Controller {

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField feeField;
    
    /**
     * 
     * New boat method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     */
    
    public void newBoat(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	
    	if (s.addBoat(nameField.getText().toString(), idField.getText().toString(), Float.parseFloat(feeField.getText().toString()))) {		
    		this.extraStage("Success", event, stage, scene, "SuccessGeneral.fxml");
    		this.changeScene(event,stage,scene,"MyBoats.fxml");
            System.out.println("Success");
		}
		else {
			this.extraStage("New Boat Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("New Boat Error");
		}
    	
    }
    
    /**
     * 
     * Back to boat menu method
     * 
     * @param event
     * @throws IOException
     */
    
    public void backBoats(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MyBoats.fxml");
        System.out.println("My Boats");
	}

}
