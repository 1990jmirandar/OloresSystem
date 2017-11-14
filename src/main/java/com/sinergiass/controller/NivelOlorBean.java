package com.sinergiass.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.sinergiass.dao.NivelOlorDao;
import com.sinergiass.model.NivelOlor;

@ManagedBean
@ApplicationScoped
public class NivelOlorBean {

	private Map<Integer, NivelOlor> niveles = new HashMap<>();
	private List<NivelOlor> filteredNiveles;
	private NivelOlor nivel;
	
	
	public NivelOlorBean(){
		nivel = new NivelOlor();
	}
	
	// Temporal
	@PostConstruct
	public void generarNiveles() {
		nivel = new NivelOlor();
	}

	public List<NivelOlor> getFilteredNiveles() {
		return filteredNiveles;
	}

	public List<NivelOlor> getNiveles() {
		NivelOlorDao dao = new NivelOlorDao();
		
		try {
			 return dao.consultar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void setFilteredNiveles(List<NivelOlor> filteredNiveles) {
		this.filteredNiveles = filteredNiveles;
	}
	
	
	public String loadNivel(int id) {
		NivelOlor nivel = niveles.get(id);
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("nivel", nivel);
		
		return "update_nivel_form";
	}
	
	public void insertarNivel() {
		NivelOlorDao dao = new NivelOlorDao();
		
		try {
			dao.insertar(nivel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeNivel(NivelOlor nivel) {
		this.nivel = nivel;
		NivelOlorDao dao = new NivelOlorDao();
		
		try {
			dao.eliminar(nivel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String updateNivel() {
		NivelOlorDao dao = new NivelOlorDao();
		
		try {
			dao.actualizar(this.nivel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "niveles";
	}

	public NivelOlor getNivel() {
		return nivel;
	}

	public void setNivel(NivelOlor nivel) {
		this.nivel = nivel;
	}
	
	public String toUpdateForm(NivelOlor nivel) {
		this.nivel = nivel;
		return "update_nivel_form";
	}
}
