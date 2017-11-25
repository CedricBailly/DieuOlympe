package model;

import model.building.Building;
import model.map.GameMap;
import model.map.Terrain;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameLogic {

    private static final Vector CAMERA_DIMENSION = new Vector(23, 45);
    private static final int MAP_SIZE = 1000;

    private GameMap map;
    private Camera camera;
    private List<Building> buildings;

    public GameLogic() {
        this.map = new GameMap(MAP_SIZE);
        this.camera = new Camera(new Vector(), CAMERA_DIMENSION);
        this.buildings = new ArrayList<>();
    }

    public List<Building> buildingsOnDisplay() {
        return this.buildings.stream().filter(camera::isIn).collect(Collectors.toList());
    }

    public Terrain[][] mapOnDisplay() {
        return this.map.terrainsIn(this.camera);
    }

    public void createBuilding(Building building) {
        if(this.buildings.stream().filter(b -> this.map.contact(building,b) ).collect(Collectors.toList()).isEmpty())
            this.buildings.add(building);
    }

    public void update(long l) {

    }
}
