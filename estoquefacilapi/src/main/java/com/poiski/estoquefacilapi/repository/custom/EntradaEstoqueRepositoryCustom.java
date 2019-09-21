package com.poiski.estoquefacilapi.repository.custom;

import com.poiski.estoquefacilapi.model.EntradaEstoque;

public interface EntradaEstoqueRepositoryCustom {
	
	EntradaEstoque findByProduct(Long productId);
	
}
