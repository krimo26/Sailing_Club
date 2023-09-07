package controllers;

/**
 * 
 * Start controller
 * 
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;



public class ControllerStart extends Controller{

	private Sistema sistema;
	
	private Stage stage;
    private Scene scene;
    
    @FXML
    private WebView web;
    
    /**
     * 
     * Opens manualStaff scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void manualStaff(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	s.setURL("http://localhost/test/SailingClub_Staff_Manual.html");
    	this.extraStage("Staff Manual", event, stage, scene, "Web.fxml");
    }
    
    /**
     * 
     * Opens manualMember scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void manualMember(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	s.setURL("http://localhost/test/SailingClub_Member_Manual.html");
    	this.extraStage("Staff Manual", event, stage, scene, "Web.fxml");
    }
    
    /**
     * 
     * Opens generalInfo scene
     * @param event
     * @throws IOException
     */
    
    public void generalInfo(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	s.setURL("http://localhost/test/SailingClub_General_Info.html");
    	this.extraStage("Staff Manual", event, stage, scene, "Web.fxml");
    }
		
    /**
     * 
     * Boot the system
     * 
     * @param event
     * @throws IOException
     */
    
	public void start(ActionEvent event) throws IOException{
		
		this.sistema = Sistema.getIstance();
		
		this.sistema.start();
		
        this.changeScene(event,stage,scene,"Login.fxml");
        System.out.println("Login");
    }
	
	

}
