package model;

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
        for (int i = 0; i < this.terrains.length; i++) {
            for (int j = 0; j < this.terrains[0].length; j++) {
                this.terrains[i][j] = Terrain.WASTE_LAND;
            }
        }
    }

    public boolean isClear(Vector location, Vector dimension) {
        return this.buildings.stream().filter(b -> b.contact(location, dimension)).collect(Collectors.toList()).isEmpty();
    }

    public void create(Building building) {
        this.buildings.add(building);
    }

    public List<Building> buildingsIn(Camera camera) {
        return this.buildings.stream().filter(camera::isIn).collect(Collectors.toList());
    }

    public Terrain[][] terrainsIn(Camera camera) {
        Vector dimension = camera.getDimension();
        Vector location = camera.getLocation();
        Terrain[][] tmp = new Terrain[(int) dimension.x][(int) dimension.x];
        for (int i = (int) (location.x) - 1; i < dimension.x + location.x + 1; i++) {
            for (int j = (int) (location.y) - 1; j < dimension.y + location.y + 1; j++) {
                tmp[i - (int) location.x - 1][j - (int) location.y - 1] = this.terrains[i][j];
            }
        }
        return tmp;
    }

}