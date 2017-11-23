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
		
		attribute = new Attribute();
		attribute.setName("maxSpeed");
		attribute.setValue(ms);
		attribute.setUm("KM/H");
		attributes.add(attribute);
		
		attribute = new Attribute();
		attribute.setName("cc");
		attribute.setValue(cc);
		attribute.setUm("CC");
		attributes.add(attribute);
		
		attribute = new Attribute();
		attribute.setName("zeroToHundred");
		attribute.setValue(zh);
		attribute.setUm("S");
		attributes.add(attribute);
		
		attribute = new Attribute();
		attribute.setName("strength");
		attribute.setValue(st);
		attribute.setUm("CV");
		attributes.add(attribute);
		
		attribute = new Attribute();
		attribute.setName("size");
		attribute.setValue(sz);
		attribute.setUm("CM");
		attributes.add(attribute);
		
		attribute = new Attribute();
		attribute.setName("weight");
		attribute.setValue(wg);
		attribute.setUm("KG");
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
