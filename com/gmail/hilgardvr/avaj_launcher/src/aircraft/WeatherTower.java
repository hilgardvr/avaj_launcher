package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

import java.util.*;
import com.gmail.hilgardvr.avaj_launcher.src.weather.WeatherProvider;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		WeatherProvider provider = WeatherProvider.getProvider();
		return provider.getCurrentWeather(coordinates);
	}

	void changeWeather() {
		List<Flyable> flys = this.getList();
		List<Flyable> toRemove = new LinkedList<Flyable>();
		
		for (Iterator<Flyable> iter = flys.listIterator(); iter.hasNext();) {
			Flyable fly = iter.next();
			fly.updateConditions();
			if ( ((Aircraft)fly).getCoordinates().getHeight() <= 0) {
				unregister(fly);
				iter.remove();
			}

		}
	}
}
