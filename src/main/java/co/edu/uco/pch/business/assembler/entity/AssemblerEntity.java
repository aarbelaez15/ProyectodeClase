package co.edu.uco.pch.business.assembler.entity;

import co.edu.uco.pch.business.assembler.Assembler;

public interface AssemblerEntity <K, D> extends Assembler<D, K>{
	
	K toEntity(D domain);

}
