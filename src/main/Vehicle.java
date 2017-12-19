package main;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle{
	public static Scanner scan = new Scanner(System.in);
	
	public void init(Integer ms, Integer cc, Integer zh, Integer st, Integer sz, Integer wg) {
//		generateAttributes(ms, cc, zh, st, sz, wg);
	}
	
	public Vehicle(){
		this(null);
	}
	
	public Vehicle(String name){
		this.name = name;
	}

	public static Integer idAttribute = 0;

	public static Integer generateAttributeId() {
		return idAttribute++;
	}
	
	private final int id = Main.generateVehicleId();
	private String name = "";
	private List<Attribute> attributes = new ArrayList<Attribute>();
	
	public void generateAttributes(Integer ms, Integer cc, Integer zh, Integer st, Integer sz, Integer wg) {
		attributes.clear();
		attributes.add(new Attribute("maxSpeed", ms, "KM/H", FALSE));
		attributes.add(new Attribute("cc", cc, "CC", FALSE));
		attributes.add(new Attribute("zeroToHundred", zh, "S", TRUE));
		attributes.add(new Attribute("strength", st, "CV", FALSE));
		attributes.add(new Attribute("size", sz, "CM", FALSE));
		attributes.add(new Attribute("weight", wg, "KG", FALSE));
		idAttribute = 0;
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
