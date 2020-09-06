package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

import java.io.*;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.id = this.nextId();
		this.coordinates = coordinates;
	}
	
	private long nextId() {
		return ++Aircraft.idCounter;
	}

	static long getCounter() {
		return Aircraft.idCounter;
	}

	public String getName() {
		return this.name;
	}

	public long getId() {
		return this.id;
	}

	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	public void	setCoordinates(Coordinates newCoord) {
		this.coordinates = newCoord;
	}
}
