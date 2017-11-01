package com.sinergiass.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sinergiass.models.Olor;

@ManagedBean(name = "olor", eager = true)
@SessionScoped
public class OlorManagedBean {
	
	private List<Olor> olores = new ArrayList<Olor>();
	
	public OlorManagedBean(){
		
	}
	
	// Temporal
	@PostConstruct
	public void generarOlores() {
		for (int i = 0; i < 10; i++) {
			Olor olor = new Olor();
			olor.setName("Olor#" + i);
			olor.setHexColor("color-" + i);
			this.olores.add(olor);
		}
	}

	public List<Olor> getOlores() {
		return olores;
	}

	public void setOlores(List<Olor> olores) {
		this.olores = olores;
	}
	
}
