package viewcontroller;

import javafx.scene.Parent;
import model.GameLogic;
import utils.Vector;

public class GameView extends Parent {

    private GameLogic logic;
    private Vector mousePos;

    public GameView(GameLogic logic) {
        this.logic = logic;
        this.mousePos = new Vector();
    }

    public void init() {
        this.getScene().setOnMouseMoved(event -> {
            mousePos.x = event.getX();
            mousePos.y = event.getY();
        });

    }

    public void update() {

    }



}
