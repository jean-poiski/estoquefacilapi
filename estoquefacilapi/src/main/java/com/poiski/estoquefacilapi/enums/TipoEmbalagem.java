package com.poiski.estoquefacilapi.enums;

public enum TipoEmbalagem {
	UNIDADE("Unidade"),
	PESO("Peso"),
	CAIXA("Caixa");
	
	private String label;
	
	private TipoEmbalagem(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}
}
