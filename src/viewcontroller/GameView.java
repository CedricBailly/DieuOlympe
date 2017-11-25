package viewcontroller;

import javafx.scene.Parent;
import model.GameLogic;
import model.building.Building;
import model.map.Terrain;
import utils.Vector;

import java.util.List;

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
        this.clear();
        this.displayMap(this.logic.mapOnDisplay());
        this.displayBuildings(this.logic.buildingsOnDisplay());
    }

    private void clear() {
        this.getChildren().removeAll(this.getChildren());
    }

    private void displayBuildings(List<Building> buildings) {
        buildings.forEach(b -> this.getChildren().add(this.createBuildingView(b)));
    }

    private BuildingView createBuildingView(Building b) {
        return new BuildingView(b);
    }

    private void displayMap(Terrain[][] terrains) {
        for (int i = 0; i < terrains.length; i++) {
            for (int j = 0; j < terrains[0].length; j++) {
                this.getChildren().add(this.createCell(new Vector(i, j), terrains[i][j]));
            }
        }
    }

    private Cell createCell(Vector vector, Terrain terrain) {
        Cell cell = new Cell(vector, terrain);
        cell.setOnMousePressed(event -> this.logic.createBuilding(new Building(vector)));
        return cell;
    }

}
