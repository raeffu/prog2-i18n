package ch.leafit.i18NSample;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public final class Main extends Application {

	private Stage stage;

	@Override
	public void start(Stage primaryStage) {
		
		stage = primaryStage;
		
		Button btnEN = new Button();
		btnEN.setText("English");
		btnEN.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadView(new Locale("en", "EN"));
			}
		});
		
		Button btnFR = new Button();
		btnFR.setText("Français");
		btnFR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadView(new Locale("fr", "FR"));
			}
		});

		Button btnDE = new Button();
		btnDE.setText("Deutsch");
		btnDE.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadView(new Locale("de", "CH"));
			}
		});
		
		Button btnKG = new Button();
		btnKG.setText("Kyrgyz");
		btnKG.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadView(new Locale("kg", "KG"));
			}
		});

		VBox root = new VBox(10);
		
		HBox buttonBox = new HBox();
		buttonBox.setSpacing(10);
		buttonBox.setStyle("-fx-background-color: gray");
		buttonBox.setPadding(new Insets(5));
	    buttonBox.getChildren().addAll(btnEN,btnDE, btnFR, btnKG); 
	    root.getChildren().add(buttonBox);
	    
		root.getChildren().add(new StackPane());
		
		primaryStage.setScene(new Scene(root, 350, 200));
		primaryStage.setTitle("Simple I18N Sample");
		primaryStage.getIcons().add(new Image("5cm.png"));
		primaryStage.show();
	}

	private void loadView(Locale locale) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			
			// This looks in the resources folder
			fxmlLoader.setResources(ResourceBundle.getBundle("Bundle", locale));
			
			// Get content delivered by FXML: It's a BorderPane in this case: We cast to Pane
			Pane pane = (Pane) fxmlLoader.load(this.getClass().getResource("View3.fxml").openStream());
			
			// replace the content
			// The root of the scene is a VBox element.
			// The first element (0) of VBox is a HBox - no interest
			// The second element (1) is a StackPane which contains the internationalized elements
			StackPane content = (StackPane) ((VBox) stage.getScene().getRoot()).getChildren().get(1);
			
			// We clear all content
			content.getChildren().clear();
			
			// And we redisplay the content with the new localized values
			content.getChildren().add(pane);
		}
		catch (IOException ex) {ex.printStackTrace();}
	}

	public static void main(String[] args) {launch(args);}
}