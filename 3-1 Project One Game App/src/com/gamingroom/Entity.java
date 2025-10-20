package com.gamingroom;

/**
 * A simple class to house shared variables among the various classes
 * @author Cristiano Miranda
 *
 */
public class Entity {
	private long id;
	private String name;
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Entity() {
	}

	// Constructor with an id and name
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the id and name in a string
	 */
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}
}
