package co.edu.uco.pch.business.assembler.DTO.impl;

import co.edu.uco.pch.business.assembler.DTO.AssemblerDTO;
import co.edu.uco.pch.business.domain.PaisDomain;
import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;
import co.edu.uco.pch.dto.PaisDTO;

public final class PaisAssemblerDTO implements AssemblerDTO <PaisDomain, PaisDTO> {

	private static final AssemblerDTO <PaisDomain, PaisDTO> instance = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {
		super();
		
	}
	
	public static final AssemblerDTO <PaisDomain, PaisDTO> getInstance() {
		return instance;
	}
	
	@Override
	public PaisDomain toDomain(final PaisDTO data) {
		var paisDtoTmp = getObjectHelper().getDefaultValue(data, PaisDTO.build());	
		return PaisDomain.build(data.getId(), paisDtoTmp.getNombre());
		
	}

	@Override
	public PaisDTO toDTO(final PaisDomain domain) {
		var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());	
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());

	}

}
