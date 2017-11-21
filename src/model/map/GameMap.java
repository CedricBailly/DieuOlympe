package model.map;

import javafx.scene.image.Image;
import model.Camera;
import model.building.Building;
import model.entity.Entity;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameMap {

    private int size;
    private Terrain[][] terrains;
    private List<Building> buildings;

    public GameMap(int size) {
        this.size = size;
        this.terrains = new Terrain[this.size][this.size];
        this.generate();
        this.buildings = new ArrayList<>();
    }

    public List<Entity> update(long now) {
        return this.buildings.stream()
                .map(b -> b.update(now)).filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }

    private void generate() {
        for (int i = 0; i < this.terrains.length; i++)
            for (int j = 0; j < this.terrains[0].length; j++)
                this.terrains[i][j] = Terrain.WASTE_LAND;
    }

    public boolean isClear(Vector location, Vector dimension) {
        return this.buildings.stream().filter(b -> b.contact(location, dimension)).collect(Collectors.toList()).isEmpty()
                && this.terrainsIsClear(location, dimension);
    }

    private boolean terrainsIsClear(Vector location, Vector dimension) {
        for (int i = (int) location.x; i < location.x + dimension.x; i++)
            for (int j = (int) location.y; j < location.y + dimension.y; j++)
                if (!this.terrains[i][j].buildableArea()) return false;
        return true;
    }

    public void create(Building building) {
        int i = 0;
        while (i < this.buildings.size() && this.buildings.get(i).getLocation().compareTo(building.getLocation()) < 0) i++;
        this.buildings.add(i, building);
    }

    public List<Building> buildingsIn(Camera camera) {
        return this.buildings.stream().filter(camera::isIn).collect(Collectors.toList());
    }

    public Terrain[][] terrainsIn(Camera camera) {
        Vector dimension = camera.getDimension();
        Vector location = camera.getLocation();
        Terrain[][] tmp = new Terrain[(int) dimension.x][(int) dimension.y];
        for (int i = 0; i < dimension.x; i++) {
            for (int j = 0; j < dimension.y; j++) {
                tmp[i][j] = this.terrains[(int) (i + location.x)][(int) (j + location.y)];
            }
        }
        return tmp;
    }

    public List<Building> getBuildings() {
        return this.buildings;
    }

}