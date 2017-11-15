package com.sinergiass.controller;

import java.util.ArrayList;
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
	
	private List<TipoOlor> olores;
	private List<TipoOlor> filteredOlores;
	private TipoOlor olor;
	
	
	public TipoOlorBean(){
		olor = new TipoOlor();
	}
	
	// getters & setters
	
	public List<TipoOlor> getFilteredOlores() {
		return filteredOlores;
	}

	public void setFilteredOlores(List<TipoOlor> filteredOlores) {
		this.filteredOlores = filteredOlores;
	}
	
	
	public TipoOlor getOlor() {
		return olor;
	}

	public void setOlor(TipoOlor olor) {
		this.olor = olor;
	}
	
	
	// TODO: Cargar los olores de la base una sola vez al crear el bean.
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
	
	// FIN: getters & setters
	
	// Métodos CRUD
	
//	public String loadOlor(int id) {
//		TipoOlor olor = olores.get(id);
//		
//		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//		
//		Map<String, Object> requestMap = externalContext.getRequestMap();
//		requestMap.put("olor", olor);
//		
//		return "update_olor_form";
//	}
	
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

	public String toUpdateForm(TipoOlor olor) {
		this.olor = olor;
		return "update_olor_form";
	}
	
}
