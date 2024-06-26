package co.edu.uco.pch.dto;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.ObjectHelper;

public class DepartamentoDTO {
    private UUID id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO() {
        super();
    }

    public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public static final DepartamentoDTO build() {
        return new DepartamentoDTO();
    }

    public final UUID getId() {
        return id;
    }

    public final DepartamentoDTO setId(final UUID id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public final DepartamentoDTO setNombre(final String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public final DepartamentoDTO setPais(final PaisDTO pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefaultValue(pais, new PaisDTO());
        return this;
    }
}

