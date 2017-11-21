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
    private int[][] terrains;
    private List<Building> buildings;

    public GameMap(int size) {
        this.size = size;
        this.terrains = new int[this.size * 2 - 1][];
        for (int i = 0; i < this.terrains.length; i++) {
            if (i < this.terrains.length / 2)
                this.terrains[i] = new int[i * 2 + 1];
            else
                this.terrains[i] = new int[(this.terrains.length - i) * 2 + 1];
        }
        this.generate();
        this.buildings = new ArrayList<>();
    }

    /**
     * this method should be called at every frame
     *
     * @param now the time between this call of the method and the last call
     */
    public List<Entity> update(long now) {
        return this.buildings.stream()
                .map(b -> b.update(now)).filter(Optional::isPresent)
                .map(Optional::get).collect(Collectors.toList());
    }

    /**
     * generate a random map
     */
    private void generate() {
        //todo
    }

    /**
     * @param location  the top left corner of the area to test
     * @param dimension the dimension of the area
     * @return if the area is clear (no building in it)
     */
    public boolean isClear(Vector location, Vector dimension) {
        return this.buildings.stream().filter(b -> b.contact(location, dimension)).collect(Collectors.toList()).isEmpty();
    }

    /**
     * add the new building to the list
     *
     * @param building the new building to add
     */
    public void create(Building building) {
        this.buildings.add(building);
    }

    public List<Building> getBuildings() {
        return this.buildings;
    }

    public int[][] getTerrains() {
        return this.terrains;
    }
}