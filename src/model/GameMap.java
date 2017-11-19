package model;

import model.building.Building;

import java.util.List;

/**
 * Class which represent the map of the game
 */
public class GameMap {

    /**
     * matric of the tile of the map
     */
    private int[][] terrains;
	/**
	 * the list of the buildings in the game
	 */
	private List<Building> buildings;

    public GameMap(int[][] terrains, List<Building> buildings) {
        this.terrains = terrains;
        this.buildings = buildings;
    }
}