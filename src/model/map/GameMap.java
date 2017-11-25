package model.map;

import model.Camera;
import model.building.Building;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameMap {

    private int size;
    private Terrain[][] terrains;

    public GameMap(int size) {
        this.size = size;
        this.terrains = new Terrain[this.size][this.size];
        this.generate();
    }

    private void generate() {
        for (int i = 0; i < this.terrains.length; i++)
            for (int j = 0; j < this.terrains[0].length; j++)
                this.terrains[i][j] = Terrain.WASTE_LAND;
    }//Todo generate a random map

    public Vector getPosition(Vector from, Vector path) {
        Vector to = new Vector(from);
        for (int i = 0; i < (int) path.y - 1; i++)  /* /!\ the cast may fuck up everything */
            to = to.minus((to.y % 2 == 0) ? new Vector(1, 1) : new Vector(0, 1));
        for (int i = 0; i < (int) path.x - 1; i++)  /* /!\ the cast may fuck up everything */
            to = to.add((to.y % 2 == 0) ? new Vector(0, -1) : new Vector(1, -1));
        return to;
    }//Todo not ready to use

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

    public boolean contact(Building b1, Building b2) {
        return false;
    }//Todo method for forbid contact between two building
}