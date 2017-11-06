package com.sinergiass.model;

public class Olor {
	
	private Integer id;
	private String name;
	private String hexColor;
	
	public Olor(Integer id, String name, String hexColor) {
		this.id = id;
		this.name = name;
		this.hexColor = hexColor;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer olorId) {
		this.id = olorId;
	}
	
	public String getHexColor() {
		return hexColor;
	}
	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
