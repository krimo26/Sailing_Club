package controllers;

/**
 * 
 * My boats controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import actors.Boat;
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

public class ControllerMyBoats extends Controller implements Initializable{

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TableView<Boat> boatsTable;
    @FXML
    private TableColumn<Boat, String> nameColumn;
    @FXML
    private TableColumn<Boat, String> idColumn;
    @FXML
    private TableColumn<Boat, Date> dateColumn;
    @FXML
    private TableColumn<Boat, Float> feeColumn;
    @FXML
    private TextField idremoveField;
    
    ObservableList<Boat> boatList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	for (Boat tempboat : s.getBoatsList()) {
            boatList.add(tempboat);
        }
        nameColumn.setCellValueFactory(new PropertyValueFactory<Boat,String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Boat,String>("ID"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Boat,Date>("registrationDate"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Boat,Float>("storageFee"));
        boatsTable.setItems(boatList);
    }
    
    /**
     * 
     * Add boat method: calls Sistema method
     * @param event
     * @throws IOException
     */
    
    public void addBoat(ActionEvent event) throws IOException{
    	this.changeScene(event,stage,scene,"NewBoat.fxml");
        System.out.println("New Boat");
    }
    
    /**
     * 
     * Remove boat method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     * 
     */
    
    public void removeBoat(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	
    	if (s.removeBoat(idremoveField.getText().toString())) {
			this.extraStage("Success", event, stage, scene, "SuccessGeneral.fxml");
			this.changeScene(event,stage,scene,"MyBoats.fxml");
            System.out.println("Success");
		}
		else {
			this.extraStage("Remove Boat Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Remove Boat Error");
		}
    	
    }
    
    /**
     * 
     * Back menu method
     * 
     * @param event
     * @throws IOException
     */
    
	public void backMenu(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"MemberMenu.fxml");
        System.out.println("Member menu");
	}

}
