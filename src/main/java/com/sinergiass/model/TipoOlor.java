package com.sinergiass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TipoOlor implements Cloneable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String name;
	private String hexColor;
	
	public TipoOlor(Integer id, String name, String hexColor) {
		this.id = id;
		this.name = name;
		this.hexColor = hexColor;
		
	}
	
	public TipoOlor() {
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
	
	@Override
	public TipoOlor clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (TipoOlor) super.clone();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
