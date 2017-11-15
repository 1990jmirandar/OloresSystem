package com.sinergiass.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.sinergiass.model.NivelOlor;
import com.sinergiass.model.PuntoMonitoreo;

@ManagedBean
@ApplicationScoped
public class PuntoMonitoreoBean {

	private Map<Integer, PuntoMonitoreo> puntos = new HashMap<>();
	private List<PuntoMonitoreo> filteredPuntos;
	private PuntoMonitoreo punto;
	
	public PuntoMonitoreoBean(){
		punto = new PuntoMonitoreo();
	}

	public Map<Integer, PuntoMonitoreo> getPuntos() {
		return puntos;
	}

	// getters & setters
	
	public List<PuntoMonitoreo> getFilteredPuntos() {
		return filteredPuntos;
	}

	public void setFilteredPuntos(List<PuntoMonitoreo> filteredPuntos) {
		this.filteredPuntos = filteredPuntos;
	}

	public PuntoMonitoreo getPunto() {
		return punto;
	}

	public void setPunto(PuntoMonitoreo punto) {
		this.punto = punto;
	}
	
	
	
	
	
}
