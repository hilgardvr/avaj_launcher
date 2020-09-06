package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

import java.io.*;
import com.gmail.hilgardvr.avaj_launcher.src.logger.Logger;

class InvalidCoord extends Exception {
	InvalidCoord(String message) {
		super(message);
	}
}

abstract class AircraftFactory {	
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) 
			throws ClassNotFoundException, InvalidCoord {
		
		if (longitude <= 0 || latitude <= 0 || height <= 0) {
			throw new InvalidCoord("Negative coords not allowed");
		}
		Coordinates coords = new Coordinates(longitude, latitude, height);
		if (type.equals("Helicopter")) {
			return new Helicopter(name, coords);
		} else if (type.equals("Baloon")) {
			return new Baloon(name, coords);
		} else if (type.equals("JetPlane")) {
			return new JetPlane(name, coords);
		} else {
			throw new ClassNotFoundException("Type: " + type + " does not exist");
		}
	}

	public static void main(String args[]) {
		if (args.length != 1) {
			System.out.println(args.length + " is invalid number of arguments - usage: java main scenario-file - exiting");
			return;
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null) {
				WeatherTower tower = new WeatherTower();
				int simulations = Integer.parseInt(line.split(" ")[0]);
				if (simulations < 0) {
					System.out.println("Invalid sim count - exiting");
					return;
				} else {
					Logger.createFile("simulation.txt"); //creating file in logger
					while ((line = reader.readLine()) != null) {
						Flyable flyable = newAircraft(line.split(" ")[0], line.split(" ")[1],
								Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
								Integer.parseInt(line.split(" ")[4]));
						flyable.registerTower(tower);
					}
				}
				for (int i = 0; i < simulations; i++) {
					tower.changeWeather();
				}
			}
		} catch (InvalidCoord e) {
			System.out.println("Problem encountered: ");
			e.printStackTrace();
			System.out.println("Exiting...");
			return;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Problem encountered: ");
			e.printStackTrace();
			System.out.println("Exiting...");
			return;
		} catch (NumberFormatException e) {
			System.out.println("Problem encountered: ");
			e.printStackTrace();
			System.out.println("Exiting...");
			return;
		} catch (ClassNotFoundException e) {
			System.out.println("Problem encountered: ");
			e.printStackTrace();
			System.out.println("Exiting...");
			return;
		} catch (IOException e) {
			System.out.println("Problem encountered: ");
			e.printStackTrace();
			System.out.println("Exiting...");
			return;
		}
		return;
	}
}
