package model;

import model.building.Building;
import model.entity.Entity;
import utils.Vector;

import java.util.ArrayList;
import java.util.List;

import static utils.Constant.MAP_SIZE;

/**
 * Class which handle the logic of the game
 */
public class GameLogic {

    /**
     * the map of the game
     */
    private GameMap map;
    /**
     * list of every entities of the game
     */
    private List<Entity> entities;

    public GameLogic() {
        this.map = new GameMap(MAP_SIZE);
        this.entities = new ArrayList<>();
    }

    /**
     * this method should be called at every frame
     *
     * @param now the time between this call of the method and the last call
     */
    public void update(long now) {
        this.entities.addAll(this.map.update(now));
        this.entities.forEach(e -> e.update(now));
    }

    /**
     * @param building the building which will which we want to be create
     * @return if it is possible to create this building at this location
     */
    public boolean canCreate(Building building) {
        Vector dimension = building.getDimension();
        Vector location = building.getLocation();
        return this.map.isClear(location, dimension);
    }

    /**
     * method which create a building on the map
     *
     * @param building building which will be create
     */
    public void create(Building building) {
        if (this.canCreate(building))
            this.map.create(building);
    }

}