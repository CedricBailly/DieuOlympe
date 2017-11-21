package viewcontroller;

import javafx.scene.Parent;
import model.building.Building;
import utils.Vector;

public class BuildingView extends Parent {

    private static Vector CELL_DIMENSION = new Vector(58, 30);
    private Building building;

    public BuildingView(Building building) {
        this.building = building;
        Vector location = this.building.getLocation();
        this.setLayoutY(location.y * CELL_DIMENSION.y / 2);
        this.setLayoutX(location.x * CELL_DIMENSION.x + ((location.y % 2 == 1) ? CELL_DIMENSION.x / 2 : 0));
        this.getChildren().add(this.building.getView());
    }
}
