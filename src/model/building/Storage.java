package model.building;

import model.entity.Person;
import model.resource.Physical;
import utils.Vector;

import java.util.*;

/**
 * Class which represent the building used to store physical resources
 */
public class Storage extends Building {

    /**
     * the storage capacity of the building
     */
    private int capacity;

    /**
     * the Map of the resource which can be stored in this building and its amount
     */
    private Map<Physical, Integer> stored;

    public Storage(String name, Vector location, Vector dimension, int capacity, Map<Physical, Integer> stored) {
        super(name, location, dimension);
        this.capacity = capacity;
        this.stored = stored;
    }

    /**
     * @param res the resource to store
     * @return if the building accept the resource
     */
    public boolean isStorable(Physical res) {
        return this.stored.containsKey(res);
    }

    /**
     * @return the total amount of resources stored in the building
     */
    public int resourceStored() {
        return this.stored.values().stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * method which store the amount (or the amount max possible) of the resource in the building
     *
     * @param res    the resource to store
     * @param amount the amount of the resource
     * @return the amount of resource which hasn't be stored
     */
    public int store(Physical res, int amount) {
        if (!this.isStorable(res)) return amount;
        int max = Math.min(amount, this.capacity - this.resourceStored());
        this.stored.put(res, this.stored.get(res) + max);
        return amount - max;
    }

    @Override
    public Optional<Person> update(long now) {
        //todo
        return Optional.empty();
    }

    @Override
    protected Person createPerson() {
        //todo
        return null;
    }
}