package controllers;

/**
 * 
 * Competition List controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerCompetitionList extends Controller implements Initializable{

	private Stage stage;
    private Scene scene;
    
    @FXML
    private Pane pContent;
    
    @FXML
    private TextField competitionField;
    @FXML
    private TableView<Competition> competitionTable;
    @FXML
    private TableColumn<Competition, String> nameColumn;
    @FXML
    private TableColumn<Competition, String> idColumn;
    @FXML
    private TableColumn<Competition, Date> dateColumn;
    @FXML
    private TableColumn<Competition, Float> feeColumn;
    
    ObservableList<Competition> compList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL FXMLLoaderurl, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	for (Competition tempcomp : s.getCompetitionsList()) {
            compList.add(tempcomp);
        }
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Competition,String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Competition,String>("ID"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Competition,Date>("date"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<Competition,Float>("partecipationFee"));
        
        competitionTable.setItems(compList);
    }
    
    /**
     * 
     * Opens partecipantsList window
     * 
     * @param event
     * @throws IOException
     */
    
    public void viewPartecipants(ActionEvent event) throws IOException {
    	Sistema s = Sistema.getIstance();
    	if (s.requestCompetition(competitionField.getText().toString())) {
    		this.changeScene(event,stage,scene,"PartecipantsList.fxml");
            System.out.println("Partecipant List");
    	}
    	else {
    		this.extraStage("Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Error");
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
		this.changeScene(event,stage,scene,"StaffMenu.fxml");
        System.out.println("Staff menu");
	}

}
