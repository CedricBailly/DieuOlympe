package model.building;

import model.entity.Person;
import model.resource.Manufactured;
import model.resource.Primary;
import utils.Vector;

import java.util.Optional;

/**
 * Class which represent every building that craft a manufactured resources from a primary one
 */
public class Factory extends Building {

	/**
	 * the amount of primary resources the factory has to transform
	 */
	private int toTransform;
	/**
	 * the amount of manufactured resources the factory has crafted
	 */
	private int transformed;
	/**
	 * the number of the primary resources which is needed to create one manufactured resource
	 */
	private int ratio;
	/**
	 * the resources use to craft the manufactured resource
	 */
	private Primary to;
	/**
	 * the resource crafted by the factory
	 */
	private Manufactured in;

    public Factory(String name, Vector location, Vector dimension, int ratio, Primary to, Manufactured in) {
        super(name, location, dimension);
        this.toTransform = 0;
        this.transformed = 0;
        this.ratio = ratio;
        this.to = to;
        this.in = in;
    }

    @Override
    public Optional<Person> update(long now) {
        // todo
        return Optional.empty();
    }

    @Override
    protected Person createPerson() {
        //todo
        return null;
    }
}