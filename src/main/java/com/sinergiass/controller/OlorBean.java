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
	private Olor olor;
	
	private Integer nextId = 0;
	
	public OlorBean(){
		
	}
	
	// Temporal
	@PostConstruct
	public void generarOlores() {
		olor = new Olor();
		
		Olor keroseno = new Olor(0, "Keroseno", "9be7ff");
		Olor gasolina = new Olor(1, "Gasolina", "ffffce");
		Olor petroleo = new Olor(2, "Petróleo", "ef9a9a");
		
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
	
	public void addOlor() {
		olor.setId(nextId);
		olores.put(olor.getId(), olor);
		
		olor = new Olor();
		
	}
	
	public void removeOlor(int id) {
		olores.remove(id);
		
	}
	
	public void updateOlor(Olor olor) {
		try {
			this.olor = olor.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public Olor getOlor() {
		return olor;
	}

	public void setOlor(Olor olor) {
		this.olor = olor;
	}
	
	
}
