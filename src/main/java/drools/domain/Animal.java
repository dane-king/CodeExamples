package drools.domain;

import java.util.Arrays;
import java.util.List;

public class Animal {
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String type;
	private List<String> attributes;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean hasAttribute(String attribute){
		return attributes.contains(attribute);
	}
	public void addAttribute(String attr){
		attributes.add(attr);
	}
	public void addAttributes(String...attrs){
		attributes.addAll(Arrays.asList(attrs));
	}
	
	public Animal(int id,String...attrs ) {
		super();
		this.id=id;
		this.attributes =Arrays.asList(attrs);
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", type=" + type + ", attributes="
				+ attributes + "]";
	}
	

}
