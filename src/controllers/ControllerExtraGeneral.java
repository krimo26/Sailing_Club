package controllers;

/**
 * 
 * Extra stage controller
 * 
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;

public class ControllerExtraGeneral extends Controller{

    /**
     * 
     * Close window method
     * @param event
     * @throws IOException
     */
	
	public void close(ActionEvent event)  throws IOException{
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

}
