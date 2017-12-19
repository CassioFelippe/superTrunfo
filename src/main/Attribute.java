package main;

public class Attribute{
	
	private final Integer id = Vehicle.generateAttributeId();
	private String name = "";
	private Integer value;
	private Boolean negative;
	private String um = "";
	
	public Attribute(){
		this(null, null, null, null);
	}

	public Attribute(String name){
		this.name = name;
	}
	
	public Attribute(String name, Integer value, String um){
		this.name = name;
		this.value = value;
		this.um = um;
	}
	
	public Attribute(String name, Integer value, String um, Boolean negative){
		this.name = name;
		this.value = value;
		this.um = um;
		this.negative = negative;
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
	
	public Boolean getNegative() {
		return negative;
	}
	
	public void setNegative(Boolean negative) {
		this.negative = negative;
	}
}
