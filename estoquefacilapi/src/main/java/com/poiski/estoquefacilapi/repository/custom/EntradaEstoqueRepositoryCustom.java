package com.poiski.estoquefacilapi.repository.custom;

import com.poiski.estoquefacilapi.model.EntradaEstoque;

public interface EntradaEstoqueRepositoryCustom
{
    EntradaEstoque findByProduct(final Long productId);
    
    Double getQtdSumByProduct(final Long productId);
}
