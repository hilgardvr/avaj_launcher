package com.gmail.hilgardvr.avaj_launcher.src.aircraft;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon (String name, Coordinates coordinates) {
		super(name, coordinates);
		this.coordinates = coordinates;
	}

	@Override
	public void updateConditions() {
		this.weatherTower.conditionsChanged(this);
	}
	
	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
}
