package gui;

import gameobjects.Vehicle;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class GuiVehicle {

	private Pane pane;
	private ImageView iv;

	public GuiVehicle(Vehicle vehicle){
		pane = new Pane();

		String fuelImageRes = GuiVehicle.class.getResource("/taxi.png").toExternalForm();
		Image image = new Image(fuelImageRes);
		iv = new ImageView(image);
//		iv.relocate(500, 1000);
		pane.getChildren().add(iv);
		performanceSettings(pane);
		performanceSettings(iv);
		pane.layoutXProperty().bind(vehicle.xProperty());
		pane.layoutYProperty().bind(vehicle.yProperty());
		
//		Bindings.bindBidirectional(vehicle.xProperty(), iv.layoutXProperty());
//		Bindings.bindBidirectional(vehicle.yProperty(), iv.layoutYProperty());
	}
	
	private void performanceSettings(Node node) {
		node.setCache(true);
		node.setCacheHint(CacheHint.SPEED);
	}
	
	public Pane getPane() {
		return pane;
	}
}
