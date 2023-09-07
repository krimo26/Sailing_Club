package controllers;

/**
 * 
 * Storage fee controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import actors.StorageFee;
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

public class ControllerStorageFee extends Controller implements Initializable{

	private Stage stage;
    private Scene scene;
    
    @FXML 
    private TextField memberField;
    @FXML 
    private TextField boatField;
    
    @FXML
    private TableView<StorageFee> storageTable;
    
    @FXML
    private TableColumn<StorageFee, Date> dateColumn;
    @FXML
    private TableColumn<StorageFee, String> memberColumn;
    @FXML
    private TableColumn<StorageFee, String> boatColumn;
    @FXML
    private TableColumn<StorageFee, Float> valueColumn;
    
    ObservableList<StorageFee> feeList = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	for (StorageFee tempfee : s.getStorageFee()) {
            feeList.add(tempfee);
        }
    	
        dateColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,Date>("Date"));
        memberColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,String>("MemberID"));
        boatColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,String>("BoatID"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,Float>("Value"));
        
        storageTable.setItems(feeList);
    
    }
    
    /**
     * 
     * Send notification method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     */
    
    public void sendNotification(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	if (s.sendStorageNotification(this.memberField.getText().toString(), this.boatField.getText().toString())){
    		this.extraStage("Success", event, stage, scene, "SuccessGeneral.fxml");
			System.out.println("Success send memberhip notification");
    	}
    	else {
    		this.extraStage("Error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Error send memberhip notification");
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
        System.out.println("Menu staff");
	}

}
