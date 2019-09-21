package com.poiski.estoquefacilapi.enums;

public enum Categoria {
	
	BEBIDA("Bebida"),
	ALIMENTO("Alimento"),
	EQUIPAMENTO("Equipamento"),
	OUTROS("Outros");
	
	private String label;
	
	private Categoria(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}

}