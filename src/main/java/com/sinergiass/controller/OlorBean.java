package com.sinergiass.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sinergiass.model.Olor;

@ManagedBean
@SessionScoped
public class OlorBean {
	
	private List<Olor> olores = new ArrayList<Olor>();
	private List<Olor> filteredOlores;
	
	public OlorBean(){
		
	}
	
	// Temporal
	@PostConstruct
	public void generarOlores() {
		
		Olor keroseno = new Olor("Keroseno", "#9be7ff");
		Olor gasolina = new Olor("Gasolina", "#ffffce");
		Olor petroleo = new Olor("Petróleo", "#ef9a9a");
		
		olores.add(keroseno);
		olores.add(gasolina);
		olores.add(petroleo);
		
	}

	public List<Olor> getOlores() {
		return olores;
	}

	public void setOlores(List<Olor> olores) {
		this.olores = olores;
	}

	public List<Olor> getFilteredOlores() {
		return filteredOlores;
	}

	public void setFilteredOlores(List<Olor> filteredOlores) {
		this.filteredOlores = filteredOlores;
	}
	
	public String addOlor(String nombre, String hexColor) {
		Olor olor = new Olor(nombre, hexColor);
		olores.add(olor);
		
		return "olores";
	}
}
