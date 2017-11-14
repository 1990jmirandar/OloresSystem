package com.sinergiass.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.sinergiass.dao.TipoOlorDao;
import com.sinergiass.model.TipoOlor;

@ManagedBean
@ApplicationScoped
public class TipoOlorBean {
	
	private Map<Integer, TipoOlor> olores = new HashMap<>();
	private List<TipoOlor> filteredOlores;
	private TipoOlor olor;
	
	
	public TipoOlorBean(){
		olor = new TipoOlor();
	}
	
	// Temporal
	@PostConstruct
	public void generarOlores() {
		olor = new TipoOlor();
	}

	public List<TipoOlor> getFilteredOlores() {
		return filteredOlores;
	}

	public List<TipoOlor> getOlores() {
		TipoOlorDao dao = new TipoOlorDao();
		
		try {
			 return dao.consultar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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
	
	public void insertarOlor() {
		TipoOlorDao dao = new TipoOlorDao();
		
		try {
			dao.insertar(olor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeOlor(TipoOlor olor) {
		this.olor = olor;
		TipoOlorDao dao = new TipoOlorDao();
		
		try {
			dao.eliminar(olor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String updateOlor() {
		TipoOlorDao dao = new TipoOlorDao();
		
		try {
			dao.actualizar(this.olor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "olores";
	}

	public TipoOlor getOlor() {
		return olor;
	}

	public void setOlor(TipoOlor olor) {
		this.olor = olor;
	}
	
	public String toUpdateForm(TipoOlor olor) {
		this.olor = olor;
		return "update_olor_form";
	}
	
}
