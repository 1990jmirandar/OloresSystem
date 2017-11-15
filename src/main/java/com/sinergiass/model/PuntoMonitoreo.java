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
	private float latitud;			// Latitud va primero cuando se muestra
	private float longitud;

	public PuntoMonitoreo() {
	}

	public PuntoMonitoreo(int id, String name, float latitud, float longitud) {
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

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

}
