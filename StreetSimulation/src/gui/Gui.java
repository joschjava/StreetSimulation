package gui;

import java.io.IOException;
import java.net.URL;

import gameobjects.Vehicle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import main.Constants;
import main.StreetSimulation;

public class Gui {

	public void startApplication(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        URL res = StreetSimulation.class.getResource("/streetgui.fxml");
        loader.setLocation(res);
        Pane rootLayout = null;
		try {
			rootLayout = (Pane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Vehicle v = new Vehicle(200, 1000);
		GuiVehicle gv = new GuiVehicle(v);
		Label label = new Label("Test");
		NumberStringConverter converter = new NumberStringConverter() {
			@Override
			public String toString(Number value) {
				return value.toString();
			}
		};
    	v.yProperty().addListener((observable, oldValue, newValue)->{
    		label.setText(String.valueOf(newValue));
		}); 
    	rootLayout.getChildren().add(gv.getPane());
    	rootLayout.getChildren().add(label);
        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Constants.WINDOW_TITLE);
        primaryStage.show();
        v.drive();
	}

	
	
}
