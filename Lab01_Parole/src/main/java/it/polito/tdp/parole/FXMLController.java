package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;
    
    @FXML
    private Button btnCancella;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtExecutionTime;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	elenco.addParola(txtParola.getText());
    	String res = "";
    	for(String s : elenco.getElenco()) {
    		res+= s + "\n";
    	}
    	txtResult.setText(res);
    	txtParola.clear();
    	
    	txtExecutionTime.setText(""+System.nanoTime());
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    	
    	txtExecutionTime.setText(""+System.nanoTime());
    }
    
    // ------------------ESERCIZIO 2------------------
    
    @FXML
    void doCancellaParola(ActionEvent event) {
    	String selWord = txtResult.getSelectedText();
    	boolean flag = elenco.removeParola(selWord);
    	
    	if(!flag)
    		txtResult.setText("\nNon è stato possibile rimuovere la parola selezionata. Riprovare!");
    	
    	txtExecutionTime.setText(""+System.nanoTime());
    }

    @FXML
    void initialize() {
    	assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
