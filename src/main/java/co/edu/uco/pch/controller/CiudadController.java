package co.edu.uco.pch.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.pch.controller.response.CiudadResponse;
import co.edu.uco.pch.crosscutting.exceptions.PCHException;
import co.edu.uco.pch.dto.CiudadDTO;

@RestController
@RequestMapping("/api/v1/ciudades")

public class CiudadController {
	
	
	@GetMapping("/dummy")
	public CiudadDTO dummy() {
		return CiudadDTO.build();
		
	}
	
	@GetMapping
	public ResponseEntity<CiudadResponse> consultar(){
		
		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CiudadResponse();
		
		try {
			
		}catch (final PCHException exepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(exepcion.getMensajeUsuario());
			exepcion.printStackTrace();
			
		}catch(final Exception excepcion){
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			
			var mensajeUsuario = "Se ha presentado un problema";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			
			
			excepcion.printStackTrace();
		}
		
		
		return new ResponseEntity<>(ciudadResponse,httpStatusCode);
		
	}
	
}

