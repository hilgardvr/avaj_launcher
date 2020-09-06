package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

public interface Flyable {
	void	updateConditions();
	void	registerTower(WeatherTower weatherTower);
}
