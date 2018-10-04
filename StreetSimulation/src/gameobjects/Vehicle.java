package gameobjects;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.Duration;

public class Vehicle {
	private DoubleProperty x = new SimpleDoubleProperty();
	private DoubleProperty y = new SimpleDoubleProperty();
	Timeline driveTimeline;
	
	public Vehicle(double x, double y) {
		this.x.set(x);
		this.y.set(y);
	}
	
	public DoubleProperty xProperty() {
		return x;
	}
	
	public DoubleProperty yProperty() {
		return y;
	}
	
	public void drive() {
		KeyValue keyValueX = new KeyValue(xProperty(), 200);
		KeyValue keyValueY = new KeyValue(yProperty(), 200);
		driveTimeline =   new Timeline(
				new KeyFrame(Duration.millis(0)),
				new KeyFrame(Duration.millis(10000), keyValueX, keyValueY)
				);
		driveTimeline.play();
	}
}
