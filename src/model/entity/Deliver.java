package model.entity;

import model.resource.Resource;

/**
 * Class which represent every Person who deliver a resource
 */
public class Deliver extends Person {

	/**
	 * the amount of resources remaining
	 */
	private int quantity;
	/**
	 * the max distance allowed between the building and the Person
	 */
	private double maxDist;
	/**
	 * the resource which the person is delivering
	 */
	private Resource resource;

}