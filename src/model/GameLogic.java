package model;

import model.building.Building;
import model.entity.Entity;
import model.map.GameMap;
import model.map.Terrain;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

import static utils.ConstantModel.CAMERA_DIMENSION;
import static utils.ConstantModel.MAP_SIZE;

public class GameLogic {

    private GameMap map;
    private Camera camera;
    private List<Entity> entities;

    public GameLogic() {
        this.map = new GameMap(MAP_SIZE);
        this.camera = new Camera(new Vector(), CAMERA_DIMENSION);
        this.entities = new ArrayList<>();
    }

    public void update(long now) {
        this.entities.addAll(this.map.update(now));
        this.entities.forEach(e -> e.update(now));
    }

    public boolean canCreate(Building building) {
        Vector dimension = building.getDimension();
        Vector location = building.getLocation();
        return this.map.isClear(location, dimension);
    }

    public void create(Building building) {
        if (this.canCreate(building))
            this.map.create(building);
    }

    public List<Building> buildingsOnDisplay(){
        return this.map.buildingsIn(this.camera);
    }

    public Terrain[][] terrainsOnDisplay(){
        return this.map.terrainsIn(this.camera);
    }

}