package co.edu.uco.pch.business.usecase.impl.ciudad;

import java.util.List;

import co.edu.uco.pch.business.assembler.entity.CiudadAssemblerEntity;
import co.edu.uco.pch.business.domain.CiudadDomain;

public class ConsultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>>{

	
	public final  List<CiudadDomain> execute(final CiudadDomain data){
		var ciudadEntityFilter=
				CiudadAssemblerEntity.getInstance().toEntity(data);
		var resultados = factory.getCiudadDAO().consultar(null);
		
		var resultadosDomain = CiudadAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);
		
		return resultadosDomain;
	}
	
}
