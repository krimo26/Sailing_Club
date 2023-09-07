
package controllers;

/**
 * 
 * My fees controller
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerMyFees extends Controller implements Initializable{
	
	private Stage stage;
    private Scene scene;
    
    @FXML 
    private Label dateLabel;
    
    @FXML
    private TextField boatField;
    
    @FXML
    private TableView<StorageFee> storageTable;
    @FXML
    private TableColumn<StorageFee, Date> dateColumn;
    @FXML
    private TableColumn<StorageFee, String> idColumn;
    @FXML
    private TableColumn<StorageFee, String> nameColumn;
    @FXML
    private TableColumn<StorageFee, Float> valueColumn;
    
    ObservableList<StorageFee> storageList = FXCollections.observableArrayList();
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
    	this.dateLabel.setText(s.getExpirementMemberhipFee());
    	
    	for (StorageFee temppart : s.getMyStorageFee()) {
            storageList.add(temppart);
        }
    	
    	dateColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,Date>("date"));
        idColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,String>("BoatID"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,String>("BoatName"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<StorageFee,Float>("value"));
        
        storageTable.setItems(storageList);
    }
	
	/**
	 * 
	 * Pay membership fee method: calls Sistema method
	 * 
	 * 
	 * @param event
	 * @throws IOException
	 * 
	 */
	
	public void payMembershipFee(ActionEvent event) throws IOException {
		Sistema s = Sistema.getIstance();
		
		if (s.checkMembershipFee()) {
    		this.extraStage("Payment", event, stage, scene, "Payment.fxml");
    		if (s.getPaymentSuccess()){
    			s.payMembershipFee();
    			this.changeScene(event,stage,scene,"MyFees.fxml");
                System.out.println("Success");
    		}
    					
		}
		else {
			this.extraStage("Membership payment error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Membership payment error");
		}

	}

	/**
	 * 
	 * Pay storage fee method: calls Sistema method
	 * 
	 * @param event
	 * @throws IOException
	 */
	
	public void payStorageFee(ActionEvent event)throws IOException{
		Sistema s = Sistema.getIstance();
		
		if (s.checkStorageFee(this.boatField.getText().toString())) {
    		this.extraStage("Payment", event, stage, scene, "Payment.fxml");
    		if (s.getPaymentSuccess()){
    			s.payStorageFee(this.boatField.getText().toString());
    			this.changeScene(event,stage,scene,"MyFees.fxml");
                System.out.println("Success");
    		}
    					
		}
		else {
			this.extraStage("Storage payment error", event, stage, scene, "ErrorGeneral.fxml");
			System.out.println("Storage payment error");
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
