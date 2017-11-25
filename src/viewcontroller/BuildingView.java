package viewcontroller;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import model.building.Building;
import utils.Vector;

public class BuildingView extends Parent {

    private static Vector CELL_DIMENSION = new Vector(58, 30);
    private Building building;

    public BuildingView(Building building) {

        this.building = building;

        Vector location = this.building.getLocation();

        Vector cellBottom = new Vector(location.x * CELL_DIMENSION.x, location.y * CELL_DIMENSION.y / 2)
                .add(new Vector((location.y % 2 != 0) ? CELL_DIMENSION.x : CELL_DIMENSION.x / 2, CELL_DIMENSION.y));

        ImageView view = this.building.getView();

        this.setLayoutY(cellBottom.y - view.getImage().getHeight());
        this.setLayoutX(cellBottom.x - view.getImage().getWidth() / 2);

        this.getChildren().add(this.building.getView());


    }
}
