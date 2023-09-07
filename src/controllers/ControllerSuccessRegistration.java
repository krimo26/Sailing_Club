package controllers;

/**
 * 
 * Success registartion controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class ControllerSuccessRegistration extends Controller implements Initializable{

	@FXML
	private Label usernameLabel;
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
        this.usernameLabel.setText(s.getMemberLogged().getUsername());
    }
	
	/**
	 * 
	 * Close method
	 * 
	 * @param event
	 * @throws IOException
	 */
	
	public void close(ActionEvent event)  throws IOException{
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

}
