package viewcontroller;

import javafx.scene.Parent;
import model.GameLogic;
import utils.Vector;

public class GameView extends Parent {

    private GameLogic logic;

    public GameView(GameLogic logic) {
        this.logic = logic;
    }

    public void init() {
        int[][] terrains = this.logic.getMap().getTerrains();
        for (int i = 0; i < terrains.length; i++) {
            for (int j = 0; j < terrains[i].length; j++) {
                this.getChildren().add(this.createCell(i, j, terrains[i][j]));
            }
        }
    }

    private Cell createCell(int x, int y, int value) {
        return new Cell(new Vector(x,y),value);
    }

    public void update() {

    }

}
