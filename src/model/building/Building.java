package model.building;

import model.entity.Person;
import utils.Vector;

import java.util.Optional;

public abstract class Building {

    /**
     * the name of the building
     */
    private String name;
    /**
     * the location of the building
     */
    private Vector location;
    /**
     * the dimension of the building
     */
    private Vector dimension;

    public Building(String name, Vector location, Vector dimension) {
        this.name = name;
        this.location = location;
        this.dimension = dimension;
    }

    /**
     * this method should be called at every frame
     *
     * @param now the time between this call of the method and the last call
     * @return an object of Person if the building created one.
     */
    public abstract Optional<Person> update(long now);

    /**
     * method called when the building need to create an object of Person
     *
     * @return the person created by the building
     */
    protected abstract Person createPerson();

    public boolean contact(Vector location, Vector dimension) {
        Vector dist = this.location.minus(location);
        boolean contact = (dist.x > 0) ? dimension.x > dist.x : this.dimension.x > -dist.x;
        contact = (dist.y > 0) ? dimension.y > dist.y || contact : this.dimension.y > -dist.y || contact;
        return contact;
    }

    public Vector getDimension() {
        return this.dimension;
    }

    public Vector getLocation() {
        return this.location;
    }

}