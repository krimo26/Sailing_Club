package controllers;

/**
 * 
 * Member profile controller
 * 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import actors.Card;
import actors.Transfer;
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

public class ControllerMemberProfile extends Controller implements Initializable{

	private Stage stage;
    private Scene scene;
    
    @FXML
	private Label nameLabel;
    @FXML
	private Label lastnameLabel;
    @FXML
	private Label idLabel;
    @FXML
	private Label addressLabel;
    @FXML
	private Label usernameLabel;
	
	@FXML
    private TableView<Card> cardsTable;
    @FXML
    private TableColumn<Card, String> cardsColumn;
    @FXML
    private TableView<Transfer> transfersTable;
    @FXML
    private TableColumn<Transfer, String> transfersColumn;
    
    ObservableList<Card> cardList = FXCollections.observableArrayList();
    
    ObservableList<Transfer> transferList = FXCollections.observableArrayList();
    
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    	Sistema s = Sistema.getIstance();
        this.nameLabel.setText(s.getMemberLogged().getName());
        this.lastnameLabel.setText(s.getMemberLogged().getLastname());
        this.idLabel.setText(s.getMemberLogged().getID());
        this.addressLabel.setText(s.getMemberLogged().getAddress());
        this.usernameLabel.setText(s.getMemberLogged().getUsername());
        this.usernameLabel.setText(s.getMemberLogged().getUsername());
        
        for (Card tempcard : s.getCardsList()) {
            cardList.add(tempcard);
        }
        cardsColumn.setCellValueFactory(new PropertyValueFactory<Card,String>("Code"));
        cardsTable.setItems(cardList);
        
        for (Transfer temptransfer : s.getTransfersList()) {
            transferList.add(temptransfer);
        }
        transfersColumn.setCellValueFactory(new PropertyValueFactory<Transfer,String>("Code"));
        transfersTable.setItems(transferList);
    }
    
	/**
	 * 
	 * Opens editProfile scene
	 * 
	 * @param event
	 * @throws IOException
	 */
	
    public void editProfile(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"EditMember.fxml");
        System.out.println("Edit Profile");
	}
    
    /**
     * 
     * Open newCard scene
     * @param event
     * @throws IOException
     */
    
    public void addCard(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"NewCard.fxml");
        System.out.println("New Card");
	}
    
    /**
     * 
     * Open newTransfer scene
     * 
     * @param event
     * @throws IOException
     */
    
    public void addTransfer(ActionEvent event) throws IOException {
		this.changeScene(event,stage,scene,"NewTransfer.fxml");
        System.out.println("New Transfer");
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
