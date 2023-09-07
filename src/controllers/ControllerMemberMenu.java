package controllers;

/**
 * 
 * Member menu conrtoller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import actors.Notification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ControllerMemberMenu extends Controller implements Initializable{
	
	private Stage stage;
    private Scene scene;
    
    @FXML
	private Label usernameLabel;
    
    @FXML
    private TableView<Notification> notificationTable;
    
    @FXML
    private TableColumn<Notification, Date> dateColumn;
    @FXML
    private TableColumn<Notification, String> typeColumn;
    @FXML
    private TableColumn<Notification, Float> valueColumn;
    
    ObservableList<Notification> notificationList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	
        this.usernameLabel.setText(s.getMemberLogged().getUsername());
        
    	for (Notification tempfee : s.getNotification()) {
            notificationList.add(tempfee);
        }
    	
    	dateColumn.setCellValueFactory(new PropertyValueFactory<Notification,Date>("Date"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Notification,String>("Type"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<Notification,Float>("Value"));
        
        notificationTable.setItems(notificationList);
    }
    
    /**
     * 
     * Opens memberProfile scene
     * @param event
     * @throws IOException
     */
    
    public void viewProfile(ActionEvent event) throws IOException {
    	this.changeScene(event,stage,scene,"MemberProfile.fxml");
        System.out.println("My profile menu");
    }
    
    /**
     * 
     * Opens myBoats scene
     * @param event
     * @throws IOException
     */
    
    public void viewBoats(ActionEvent event) throws IOException {
    	this.changeScene(event,stage,scene,"MyBoats.fxml");
        System.out.println("My boats menu");
    }
    
    /**
     * 
     * Opens myCompetition scene
     * @param event
     * @throws IOException
     */
    
    public void viewCompetitions(ActionEvent event) throws IOException {
    	this.changeScene(event,stage,scene,"MyCompetitions.fxml");
        System.out.println("My competitions menu");
    }
    
    /**
     * 
     * Open myFess scene
     * @param event
     * @throws IOException
     */
    
    public void viewFees(ActionEvent event)throws IOException{
    	this.changeScene(event,stage,scene,"MyFees.fxml");
        System.out.println("My fees menu");
    }
    
    /**
     * 
     * Logout method: calls Sistema method and opens login scene
     * 
     * @param event
     * @throws IOException
     */
    
	public void logout(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"Login.fxml");
		Sistema s = Sistema.getIstance();
		s.memberLogout();
        System.out.println("Logout");
	}
	
	public void setUsernameLabel(String un) {
		this.usernameLabel.setText(un);
	}

}
