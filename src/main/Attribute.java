package main;

public class Attribute{
	public Attribute(){
		this(null, null, null);
	}
	public Attribute(
			String name,
			Integer value,
			String um
			){
//		super(Vehicle.class, name, cc, strength, maxSpeed, zeroToHundred, size, weight);
	}
	private final Integer id = Vehicle.generateAttributeId();
	private String name = "";
	private Integer value;
	private String um = "";

	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String getUm() {
		return um;
	}
	
	public void setUm(String um) {
		this.um = um;
	}
}
