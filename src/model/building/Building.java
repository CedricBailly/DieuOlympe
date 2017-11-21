package model.building;

import model.entity.Entity;
import utils.Vector;
import viewcontroller.Displayable;

import java.util.Optional;

public abstract class Building implements Displayable{

    private String name;
    private Vector location;
    private Vector dimension;

    public Building(String name, Vector location, Vector dimension) {
        this.name = name;
        this.location = location;
        this.dimension = dimension;
    }

    public abstract Optional<Entity> update(long now);

    protected abstract Entity createEntity();

    public boolean contact(Vector location, Vector dimension) {
        Vector dist = this.location.minus(location);
        boolean contact = (dist.x > 0) ? dimension.x > dist.x : this.dimension.x > -dist.x;
        contact = (dist.y > 0) ? dimension.y > dist.y && contact : this.dimension.y > -dist.y && contact;
        return contact;
    }

    public Vector getDimension() {
        return this.dimension;
    }

    public Vector getLocation() {
        return this.location;
    }

}