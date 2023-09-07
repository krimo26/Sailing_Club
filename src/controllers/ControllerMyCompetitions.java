package controllers;

/**
 * 
 * My competitions controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import actors.PartecipationExtended;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerMyCompetitions extends Controller implements Initializable {

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TableView<PartecipationExtended> partTable;
    @FXML
    private TableColumn<PartecipationExtended, String> compColumn;
    @FXML
    private TableColumn<PartecipationExtended, String> boatColumn;
    @FXML
    private TableColumn<PartecipationExtended, Date> dateColumn;
    @FXML
    private TableColumn<PartecipationExtended, Float> feeColumn;
    
    ObservableList<PartecipationExtended> partList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	for (PartecipationExtended temppart : s.getPartecipationList()) {
            partList.add(temppart);
        }
    	compColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,String>("competition"));
        boatColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,String>("boat"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,Date>("date"));
        feeColumn.setCellValueFactory(new PropertyValueFactory<PartecipationExtended,Float>("value"));
        
        partTable.setItems(partList);
    }
    
    /**
     * 
     * Enroll boat method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     */
    
    public void enrolBoat(ActionEvent event) throws IOException {
    	this.changeScene(event,stage,scene,"EnrolBoat.fxml");
        System.out.println("Enrol Boat");
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
