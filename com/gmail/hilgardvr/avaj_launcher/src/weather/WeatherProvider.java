package com.gmail.hilgardvr.avaj_launcher.src.weather;

import java.util.Random;
import com.gmail.hilgardvr.avaj_launcher.src.aircraft.*;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather;
	private Random random;

	WeatherProvider() {
		random = new Random();
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int total = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();
		int rand = random.nextInt(total);
		if (rand % 4 == 0) {
			return "RAIN";
		} else if (rand % 4 == 1) {
			return "FOG";
		} else if (rand % 4 == 2) {
			return "SUN";
		} else {
			return "SNOW";
		}
	}
}
