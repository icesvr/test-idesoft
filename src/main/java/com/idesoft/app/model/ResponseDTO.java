package com.idesoft.app.model;

public class ResponseDTO {
	
	
	
	private String nombreLocal;
	private String direccion;
	private String telefono;
	private String latitud;
	private String longitud;
	
	public ResponseDTO() {}
	
	public ResponseDTO(String nombreLocal, String direccion, String telefono, String latitud, String longitud) {
		this.nombreLocal = nombreLocal;
		this.direccion = direccion;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
