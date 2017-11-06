package com.sinergiass.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.sinergiass.model.Olor;

@ManagedBean
@ApplicationScoped
public class OlorBean {
	
	private Map<Integer, Olor> olores = new HashMap<>();
	private List<Olor> filteredOlores;
	
	private Integer nextId = 0;
	
	public OlorBean(){
		
	}
	
	// Temporal
	@PostConstruct
	public void generarOlores() {
		
		Olor keroseno = new Olor(0, "Keroseno", "#9be7ff");
		Olor gasolina = new Olor(1, "Gasolina", "#ffffce");
		Olor petroleo = new Olor(2, "Petróleo", "#ef9a9a");
		
//		olores[nextId++] = keroseno;
//		olores[nextId++] = gasolina;
//		olores[nextId++] = petroleo;
		
		olores.put(nextId++, keroseno);
		olores.put(nextId++, gasolina);
		olores.put(nextId++, petroleo);
	}

	public List<Olor> getFilteredOlores() {
		return filteredOlores;
	}

	public List<Olor> getOlores() {
		return new ArrayList<Olor>(olores.values());
	}
	
	public void setFilteredOlores(List<Olor> filteredOlores) {
		this.filteredOlores = filteredOlores;
	}
	
	// Methods
	
	public String loadOlor(int id) {
		Olor olor = olores.get(id);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("olor", olor);
		
		return "update_olor_form";
	}
	
	public String addOlor(String nombre, String hexColor) {
		Olor olor = new Olor(nextId++, nombre, hexColor);
		olores.put(olor.getId(), olor);
		
		return "olores";
	}
	
	public String removeOlor(int id) {
		olores.remove(id);
		
		return "olores";
	}
	
	public String updateOlor(Olor olor) {
		olores.put(olor.getId(), olor);
		
		return "olores";
	}
}
