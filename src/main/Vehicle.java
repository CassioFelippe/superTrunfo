package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle{
	public static Scanner scan = new Scanner(System.in);
	
	public void init(Integer ms, Integer cc, Integer zh, Integer st, Integer sz, Integer wg) {
		generateAttributes(ms, cc, zh, st, sz, wg);
	}
	
	public Vehicle(){
		this(null);
	}
	
	public Vehicle(String name){
//		super(Vehicle.class, name, cc, strength, maxSpeed, zeroToHundred, size, weight);
	}

	public static Integer idAttribute = 0;

	public static Integer generateAttributeId() {
		return ++idAttribute;
	}
	
	private final int id = Main.generateVehicleId();
	private String name = "";
	private static List<Attribute> attributes = new ArrayList<Attribute>();
	
	public static void generateAttributes(Integer ms, Integer cc, Integer zh, Integer st, Integer sz, Integer wg) {
		attributes.clear();
		
		Attribute attribute = new Attribute();
		
		attribute = new Attribute("MaxSpeed", null, "KM/H");
		attribute.setValue(ms);
		attributes.add(attribute);
		
		attribute = new Attribute("Cc", null, "CC");
		attribute.setValue(cc);
		attributes.add(attribute);
		
		attribute = new Attribute("zeroToHundred", null, "s");
		attribute.setValue(zh);
		attributes.add(attribute);
		
		attribute = new Attribute("strength", null, "CV");
		attribute.setValue(st);
		attributes.add(attribute);
		
		attribute = new Attribute("size", null, "cm");
		attribute.setValue(sz);
		attributes.add(attribute);
		
		attribute = new Attribute("weight", null, "kg");
		attribute.setValue(wg);
		attributes.add(attribute);
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
}
