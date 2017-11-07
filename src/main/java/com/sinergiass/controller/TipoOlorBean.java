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

import com.sinergiass.model.TipoOlor;

@ManagedBean
@ApplicationScoped
public class TipoOlorBean {
	
	private Map<Integer, TipoOlor> olores = new HashMap<>();
	private List<TipoOlor> filteredOlores;
	private TipoOlor olor;
	
	private Integer nextId = 0;
	
	public TipoOlorBean(){
		
	}
	
	// Temporal
	@PostConstruct
	public void generarOlores() {
		olor = new TipoOlor();
		
		TipoOlor keroseno = new TipoOlor(0, "Keroseno", "9be7ff");
		TipoOlor gasolina = new TipoOlor(1, "Gasolina", "ffffce");
		TipoOlor petroleo = new TipoOlor(2, "Petróleo", "ef9a9a");
		
		olores.put(nextId++, keroseno);
		olores.put(nextId++, gasolina);
		olores.put(nextId++, petroleo);
	}

	public List<TipoOlor> getFilteredOlores() {
		return filteredOlores;
	}

	public List<TipoOlor> getOlores() {
		return new ArrayList<TipoOlor>(olores.values());
	}
	
	public void setFilteredOlores(List<TipoOlor> filteredOlores) {
		this.filteredOlores = filteredOlores;
	}
	
	// Methods
	
	public String loadOlor(int id) {
		TipoOlor olor = olores.get(id);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("olor", olor);
		
		return "update_olor_form";
	}
	
	public void addOlor() {
		olor.setId(nextId);
		olores.put(olor.getId(), olor);
		
		olor = new TipoOlor();
		
	}
	
	public void removeOlor(int id) {
		olores.remove(id);
		
	}
	
	public void updateOlor(TipoOlor olor) {
		try {
			this.olor = olor.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public TipoOlor getOlor() {
		return olor;
	}

	public void setOlor(TipoOlor olor) {
		this.olor = olor;
	}
	
	
}
