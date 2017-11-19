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
	 * @return the person created by the building
	 */
	protected abstract Person createPerson();
}