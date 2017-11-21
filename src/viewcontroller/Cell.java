package viewcontroller;

import javafx.scene.Parent;
import model.map.Terrain;
import utils.Vector;

public class Cell extends Parent {

    private static Vector CELL_DIMENSION = new Vector(58, 30);
    private Vector location;

    public Cell(Vector vector, Terrain terrain) {
        this.location = vector;
        this.setLayoutY(this.location.y * CELL_DIMENSION.y / 2);
        this.setLayoutX(this.location.x * CELL_DIMENSION.x + ((this.location.y % 2 == 1) ? CELL_DIMENSION.x / 2 : 0));
        this.getChildren().add(terrain.getView());
    }

    public Vector getLocation() {
        return location;
    }
}
