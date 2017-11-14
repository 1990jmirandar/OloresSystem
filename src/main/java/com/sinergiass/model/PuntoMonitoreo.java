package com.sinergiass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PUNTOMONITOREO")
public class PuntoMonitoreo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String name;
	private String latitud;
	private String longitud;

	public PuntoMonitoreo() {
	}

	public PuntoMonitoreo(int id, String name, String latitud, String longitud) {
		super();
		this.id = id;
		this.name = name;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}
