package controllers;

/**
 * 
 * Web pages controller
 * 
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;


public class ControllerWeb extends Controller implements Initializable {
	
    
    @FXML
    private WebView web;
	
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	this.web.getEngine().load(s.getURL());
    }
    

}
