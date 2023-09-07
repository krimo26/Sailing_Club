package controllers;

/**
 * 
 * Membership fee controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import actors.MembershipFee;
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

public class ControllerMembershipFee extends Controller implements Initializable {

	private Stage stage;
    private Scene scene;
    
    @FXML
    private TextField idField; 
    @FXML
    private TableView<MembershipFee> feeTable;
    @FXML
    private TableColumn<MembershipFee, Date> dateColumn;
    @FXML
    private TableColumn<MembershipFee, String> idColumn;
    @FXML
    private TableColumn<MembershipFee, Float> valueColumn;
    
    ObservableList<MembershipFee> feeList = FXCollections.observableArrayList(); 
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	for (MembershipFee tempfee : s.getMembershipFee()) {
            feeList.add(tempfee);
        }
    	
        dateColumn.setCellValueFactory(new PropertyValueFactory<MembershipFee,Date>("Date"));
        idColumn.setCellValueFactory(new PropertyValueFactory<MembershipFee,String>("MemberID"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<MembershipFee,Float>("Value"));
        
        feeTable.setItems(feeList);
    
    }
    
    /**
     * 
     * Send notification method: calls Sistema method
     * 
     * @param event
     * @throws IOException
     * 
     */
    
    public void sendNotification(ActionEvent event) throws IOException{
    	Sistema s = Sistema.getIstance();
    	if (s.sendMembershipNotification(this.idField.getText().toString())){
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
     * 
     */
    
	public void backMenu(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"StaffMenu.fxml");
        System.out.println("Menu staff");
	}

}
