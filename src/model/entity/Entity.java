package model.entity;

import java.util.*;

/**
 * Class which represent every living being
 */
public class Entity {

	/**
	 * the speed of the entity
	 */
	private int speed;
	/**
	 * the location of the entity
	 */
	private Vector location;
	/**
	 * the targeted location of the entity
	 */
	private Vector destination;

    /**
     * this method should be called at every frame
     *
     * @param now the time between this call of the method and the last call
     */
	public void update(long now) {
		// TODO
	}

}