package model;

import model.building.Building;
import utils.Vector;

public class Camera {

    private Vector location;
    private Vector dimension;

    public Camera(Vector location, Vector dimension) {
        this.location = location;
        this.dimension = dimension;
    }

    public boolean isIn(Building building) {
        return building.contact(this.location, this.dimension);
    }

    public Vector getDimension() {
        return this.dimension;
    }

    public Vector getLocation() {
        return this.location;
    }
}
