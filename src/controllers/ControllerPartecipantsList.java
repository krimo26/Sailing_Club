package controllers;

/**
 * 
 * Partecipants list controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import actors.PartecipationExtended;
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

public class ControllerPartecipantsList extends Controller implements Initializable{

	private Stage stage;
    private Scene scene;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private TableView<PartecipationExtended> partTable;
    @FXML
    private TableColumn<PartecipationExtended, String> idColumn;
    @FXML
    private TableColumn<PartecipationExtended, String> usernameColumn;
    @FXML
    private TableColumn<PartecipationExtended, String> boatidColumn;
    @FXML
    private TableColumn<PartecipationExtended, String> boatnameColumn;

    ObservableList<PartecipationExtended> partList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	
    	nameLabel.setText(s.getCompRequested().getName());
    	
    	for (PartecipationExtended temppart : s.getCompPartList()) {
            partList.add(temppart);
        }
    	idColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,String>("MemberID"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,String>("member"));
        boatidColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,String>("BoatID"));
        boatnameColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,String>("boat"));
        
        partTable.setItems(partList);
    }

    /**
     * 
     * Back competition method
     * 
     * @param event
     * @throws IOException
     */
    
	public void backCompetitions(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"CompetitionList.fxml");
        System.out.println("Competition List");
	}

}
