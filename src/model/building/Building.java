package model.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Vector;
import viewcontroller.Displayable;

public class Building implements Displayable {

    private static Image IMAGE = new Image(Building.class.getResource("house.png").toExternalForm());
    private Vector location;
    private Vector dimension;

    public Building(Vector location) {
        this.dimension = new Vector(2, 2);
        this.location = location;
    }

    @Override
    public ImageView getView() {
        return new ImageView(IMAGE);
    }

    public Vector getLocation() {
        return this.location;
    }

    public Vector getDimension() {
        return this.dimension;
    }
}