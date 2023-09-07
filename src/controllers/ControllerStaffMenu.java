package controllers;

/**
 * 
 * Staff menu controller
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
import javafx.stage.Stage;

public class ControllerStaffMenu extends Controller implements Initializable{

	
	
	private Stage stage;
    private Scene scene;
    
    @FXML
	private Label usernameLabel;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
        this.usernameLabel.setText(s.getStaffLogged().getUsername());
    }
    
    /**
     * 
     * Opens editStaff scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void viewProfile(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"EditStaff.fxml");
        System.out.println("Staff profile");
	}
    
    /**
     * 
     * Opens membershipFee scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void viewMembershipF(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MembershipFee.fxml");
        System.out.println("Membership Fee");
	}
    
    /**
     * 
     * Opens storageFee scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void viewStorageF(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"StorageFee.fxml");
        System.out.println("StorageFee");
	}
    
    /**
     * 
     * Opens competitionList scene
     * @param event
     * @throws IOException
     */
    
    public void viewCompetitions(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"CompetitionList.fxml");
        System.out.println("Competiotn list");
	}
    
    /**
     * 
     * Logout method: calls Sistema method and go back to login scene
     * 
     * @param event
     * @throws IOException
     */
    
	public void logout(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"Login.fxml");
		Sistema s = Sistema.getIstance();
		s.staffLogout();
        System.out.println("Logout");
	}
}
