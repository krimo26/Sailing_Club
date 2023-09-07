package controllers;

/**
 * 
 * Payment controller
 * 
 */

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ControllerPayment extends Controller {

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField codeField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private RadioButton cardButton;
    @FXML
    private RadioButton transferButton;
    @FXML
    private ToggleGroup type;
    @FXML
    private Button closeButton;
    
    /**
     * Pay method: calls Sistema method (payCard or payTransfer)
     * @param event
     * @throws IOException
     * 
     */
    
    public void pay(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	if(this.type.getSelectedToggle().equals(this.cardButton)) {
    		if (s.payCard(codeField.getText().toString(), passwordField.getText().toString())) {
    			this.changeScene(event,stage,scene,"SuccessGeneral.fxml");                
    		}
    		else {
    			this.changeScene(event,stage,scene,"ErrorGeneral.fxml");
    			System.out.println("Payment card error");
    		}
    		
    	}
    	
    	else if(this.type.getSelectedToggle().equals(this.transferButton)) {
    		if (s.payTransfer(codeField.getText().toString())) {
    			this.changeScene(event,stage,scene,"SuccessGeneral.fxml");
    		}
    		else {
    			this.changeScene(event,stage,scene,"ErrorGeneral.fxml");
    			System.out.println("Payment transfer error");
    		}
    		
    	}
    	    	
    }	
    
    /**
     * 
     * Close method
     * 
     * @param event
     */
    
    public void close(ActionEvent event) {
    	  Stage stage = (Stage) closeButton.getScene().getWindow();
    	  stage.close();
    }

}
