package co.edu.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import co.edu.uco.pch.crosscutting.exceptions.custom.DataPCHException;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.pch.crosscutting.exceptions.messagecatalog.data.CodigoMensaje;
import co.edu.uco.pch.crosscutting.helpers.SQLHelper;

public class SqlConnection {
	
	private Connection conexion;

	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}
	
	protected final Connection getConexion() {
		return conexion;
	}

	private final void setConexion(final Connection conexion) {
		
		if(!SQLHelper.isOpen(conexion)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = "No es posible crear el DAO deseado con una conexión cerrada";
			
			throw new DataPCHException(mensajeTecnico,mensajeUsuario);
		}
				
		this.conexion = conexion;
	}
	
	

}