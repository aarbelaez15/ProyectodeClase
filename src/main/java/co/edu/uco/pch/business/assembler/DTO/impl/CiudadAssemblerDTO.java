package co.edu.uco.pch.business.assembler.DTO.impl;

import co.edu.uco.pch.business.assembler.DTO.AssemblerDTO;
import co.edu.uco.pch.business.domain.CiudadDomain;
import co.edu.uco.pch.business.domain.DepartamentoDomain;
import co.edu.uco.pch.dto.CiudadDTO;
import co.edu.uco.pch.dto.DepartamentoDTO;

import static co.edu.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

public final class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {

    private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO.getInstance();
    private static final CiudadAssemblerDTO instance = new CiudadAssemblerDTO();

    private CiudadAssemblerDTO() {
        super();
    }

    public static AssemblerDTO<CiudadDomain, CiudadDTO> getInstance() {
        return instance;
    }

    @Override
    public CiudadDomain toDomain(final CiudadDTO data) {
        var ciudadDtoTmp = getObjectHelper().getDefaultValue(data, CiudadDTO.build());
        var departamentoDomain = departamentoAssembler.toDomain(ciudadDtoTmp.getDepartamento());
        return CiudadDomain.build(ciudadDtoTmp.getId(), ciudadDtoTmp.getNombre(), departamentoDomain);
    }

    @Override
    public CiudadDTO toDTO(final CiudadDomain domain) {
        var ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
        var departamentoDto = departamentoAssembler.toDTO(ciudadDomainTmp.getDepartamento());
        return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDto);
    }
}

