package model;

import model.building.Building;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class which represent the map of the game
 */
public class GameMap {

    /**
     * the size of the map
     */
    private int size;
    /**
     * matric of the tile of the map
     */
    private int[][] terrains;
    /**
     * the list of the buildings in the game
     */
    private List<Building> buildings;

    public GameMap(int size) {
        this.size = size;
        this.terrains = new int[size][size];
        this.generate();
        this.buildings = new ArrayList<>();
    }

    public void generate() {
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
}