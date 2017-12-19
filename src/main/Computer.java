package main;

import java.util.ArrayList;
import java.util.List;

public class Computer{
	private final Integer id = Main.generatePlayerId();
	private String name = "";
	private static List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private Integer score = 0;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	public Computer(String string) {
		this.name = string;
	}

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public void setVehicles(List<Vehicle> vehiclesToBeAdded) {
		vehicles = vehiclesToBeAdded;
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle);
	}

	public Integer getScore() {
		return score;
	}
	
	public void addScore() {
		this.score += 1;
	}
}
