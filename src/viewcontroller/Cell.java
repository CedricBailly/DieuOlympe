package viewcontroller;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.Vector;

public class Cell extends Parent {

    private static final int CELL_WIDTH = 58;
    private static final int CELL_HEIGHT = 30;
    private Vector pos;

    public Cell(Vector pos, int value) {
        this.pos = pos;
        this.setLayoutX(this.pos.y * CELL_WIDTH / 2);
        this.setLayoutY(this.pos.x * CELL_HEIGHT - this.pos.y * CELL_HEIGHT / 2);
        this.getChildren().add(new ImageView(new Image(Cell.class.getResource("terrain.png").toExternalForm())));
    }

    public Vector getPos() {
        return this.pos;
    }

}
