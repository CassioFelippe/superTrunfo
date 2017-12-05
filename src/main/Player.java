package main;

import java.util.Collection;

public class Player{
	private final Integer id = Main.generatePlayerId();
	private String name = "";
	private Collection<Vehicle> vehicles;
	private Integer score = 0;
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}

	public Integer getScore() {
		return score;
	}
	
	public void addScore() {
		this.score = this.score++;
	}
}
