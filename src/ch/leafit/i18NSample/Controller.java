package ch.leafit.i18NSample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Controller implements Initializable {

    @FXML private Label lblTextByController;
    
    @FXML
    private Label laLanguage;
    
    private ResourceBundle bundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;
        lblTextByController.setText(bundle.getString("key1"));
        laLanguage.setText(bundle.getString("key4"));
    }
}