package model.map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import viewcontroller.Displayable;

public enum Terrain implements Displayable {

    WASTE_LAND(true, new Image(Terrain.class.getResource("terrain.png").toExternalForm()));

    private boolean buildingLand;
    private Image image;

    Terrain(boolean buildingLand, Image image) {
        this.buildingLand = buildingLand;
        this.image = image;
    }

    public boolean buildableArea() {
        return this.buildingLand;
    }

    @Override
    public ImageView getView(){
        return new ImageView(this.image);
    }

    @Override
    public String toString() {
        return this.name();
    }
}
