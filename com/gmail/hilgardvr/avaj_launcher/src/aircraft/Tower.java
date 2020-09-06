package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

import java.util.*;
import com.gmail.hilgardvr.avaj_launcher.src.logger.Logger;

abstract class Tower {
	private List<Flyable> observers = new LinkedList<Flyable>();

	public void register(Flyable flyable) {
		String theClass = String.valueOf(flyable.getClass());
		String[] classParts = theClass.split("\\.");
		Logger.writeToFile("Tower says: " + classParts[classParts.length - 1] + "#" + 
				((Aircraft)flyable).getName() + "(" + ((Aircraft)flyable).getId() + ")" 
				+ ": " + "registered to weather tower");
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		String theClass = String.valueOf(flyable.getClass());
		String[] classParts = theClass.split("\\.");
		Logger.writeToFile(classParts[classParts.length - 1] + "#" + 
				((Aircraft)flyable).getName() + "(" + ((Aircraft)flyable).getId() + ")" 
				+ " landing");
		Logger.writeToFile("Tower says: " + classParts[classParts.length - 1] + "#" + 
				((Aircraft)flyable).getName() + "(" + ((Aircraft)flyable).getId() + ")" 
				+ ": " + "unregistered form weather tower");
	}

	protected List<Flyable> getList() {
		return this.observers;
	}

	protected void conditionsChanged(Flyable flyable) {
		if (!(flyable instanceof Aircraft))
			return;
		WeatherTower wt = new WeatherTower();
		String weather = wt.getWeather( ((Aircraft)flyable).getCoordinates() );
		int lon = ((Aircraft)flyable).coordinates.getLongitude();
		int lat = ((Aircraft)flyable).coordinates.getLatitude();
		int height = ((Aircraft)flyable).coordinates.getHeight();
		//System.out.print(lon + " " + lat + " " + height + " ");
		if (flyable instanceof Helicopter) {
			if (weather.equals("SUN")) {
				Logger.writeToFile("Helicopter" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Nice and sunny");
				lon += 10;
				height += 2;
			} else if (weather.equals("RAIN")) {
				Logger.writeToFile("Helicopter" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "In the rain");
				lon += 5;
			} else if (weather.equals("FOG")) {
				Logger.writeToFile("Helicopter" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Foggy");
				lon += 1;
			} else if (weather.equals("SNOW")) {
				Logger.writeToFile("Helicopter" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Snowy");
				height -= 12;
			}
		} else if (flyable instanceof JetPlane) { 
			if (weather.equals("SUN")) {
				Logger.writeToFile("JetPlane" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Nice and sunny");
				lat += 10;
				height += 2;
			} else if (weather.equals("RAIN")) {
				Logger.writeToFile("JetPlane" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "In the rain");
				lat += 5;
			} else if (weather.equals("FOG")) {
				Logger.writeToFile("JetPlane" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Foggy");
				lat += 1;	
			} else if (weather.equals("SNOW")) {
				Logger.writeToFile("JetPlane" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Snowy");
				height -= 7;
			}
		} else if (flyable instanceof Baloon) { 
			if (weather.equals("SUN")) {
				Logger.writeToFile("Baloon" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Nice and sunny");
				lon += 2;
				height += 4;
			} else if (weather.equals("RAIN")) {
				Logger.writeToFile("Baloon" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "In the rain");
				height -= 5;
			} else if (weather.equals("FOG")) {
				Logger.writeToFile("Baloon" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Foggy");
				height -= 3;
			} else if (weather.equals("SNOW")) {
				Logger.writeToFile("Baloon" + "#" + ((Aircraft)flyable).getName() 
						+ "(" + ((Aircraft)flyable).getId() + ")" + ": " + "Snowy");
				height -= 15;
			}
		}
		if (height < 0) {
			height = 0;
		} else if (height > 100) {
			height = 100;
		}
		if (lat < 0) {
			lat = 0;
		}
		if (lon < 0) {
			lon = 0;
		}
		((Aircraft)flyable).coordinates.setLatitude(lat);
		((Aircraft)flyable).coordinates.setLongitude(lon);
		((Aircraft)flyable).coordinates.setHeight(height);
	}

	protected void removeLanded(List<Flyable> flys) {
		observers.removeAll(flys);
	}
}
