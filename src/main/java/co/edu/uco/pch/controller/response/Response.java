package co.edu.uco.pch.controller.response;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {
	
	private List<String> mensajes = new ArrayList<String>();
	private List<String> datos;
	
	public final void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}
	public final void setDatos(List<String> datos) {
		this.datos = datos;
	}
	public List<String> getMensajes() {
		return mensajes;
	}
	public final List<String> getDatos() {
		return datos;
	}
	
	
}