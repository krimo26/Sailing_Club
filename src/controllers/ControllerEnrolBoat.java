package controllers;

/**
 * 
 * Enroll boat controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import actors.Boat;
import actors.Competition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerEnrolBoat extends Controller implements Initializable {

	private Stage stage;
    private Scene scene;
    
    @FXML 
    TextField boatField;
    @FXML 
    TextField compField;
    
    @FXML
    private TableView<Competition> compTable;
    @FXML
    private TableColumn<Competition, String> compnameColumn;
    @FXML
    private TableColumn<Competition, String> compidColumn;
    @FXML
    private TableColumn<Competition, Date> compdateColumn;
    @FXML
    private TableColumn<Competition, Float> compfeeColumn;
    
    ObservableList<Competition> compList = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Boat> boatTable;
    @FXML
    private TableColumn<Boat, String> boatnameColumn;
    @FXML
    private TableColumn<Boat, String> boatidColumn;
    
    ObservableList<Boat> boatList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	for (Competition tempcomp : s.getCompetitionsList()) {
            compList.add(tempcomp);
        }
    	compnameColumn.setCellValueFactory(new PropertyValueFactory<Competition,String>("name"));
        compidColumn.setCellValueFactory(new PropertyValueFactory<Competition,String>("ID"));
        compdateColumn.setCellValueFactory(new PropertyValueFactory<Competition,Date>("date"));
        compfeeColumn.setCellValueFactory(new PropertyValueFactory<Competition,Float>("partecipationFee"));
        
        compTable.setItems(compList);
        
        for (Boat tempboat : s.getBoatsList()) {
            boatList.add(tempboat);
        }
        boatnameColumn.setCellValueFactory(new PropertyValueFactory<Boat,String>("name"));
        boatidColumn.setCellValueFactory(new PropertyValueFactory<Boat,String>("ID"));
        boatTable.setItems(boatList);
    }

    /**
     * 
     * Enroll boat method: checks payments and then enroll boat
     * 
     * @param event
     * @throws IOException
     */
    
    public void enrolBoat(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	
    	
    	if (s.checkBoat(boatField.getText().toString(), compField.getText().toString())) {
    		this.extraStage("Payment", event, stage, scene, "Payment.fxml");
    		if (s.getPaymentSuccess()){
    			s.enrolBoat(boatField.getText().toString(), compField.getText().toString());
    			this.changeScene(event,stage,scene,"MyCompetitions.fxml");
                System.out.println("Success");
    		}
    					
		}
		else {
			this.extraStage("Enrolment Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Boat already enrolled");
		}
    	
    }

    /**
     * 
     * Back to my competitions method
     * 
     * @param event
     * @throws IOException
     */
    
	public void backCompetitions(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MyCompetitions.fxml");
        System.out.println("My Competitions");
	}

}
