package co.edu.uco.pch.controller.response;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.pch.dto.CiudadDTO;

public class CiudadResponse extends Response<CiudadDTO> {
	
	public CiudadResponse () {
		setMensajes(new ArrayList<String>());
		setDatos(new ArrayList<>());
		
	}

	public List<String> getMensajes() {
		// TODO Auto-generated method stub
		return null;
	}

}
