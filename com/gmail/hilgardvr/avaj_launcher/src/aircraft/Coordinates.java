package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
	
	public void setLongitude(int lon) {
		this.longitude = lon;
	}

	public void setLatitude(int lat) {
		this.latitude = lat;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
