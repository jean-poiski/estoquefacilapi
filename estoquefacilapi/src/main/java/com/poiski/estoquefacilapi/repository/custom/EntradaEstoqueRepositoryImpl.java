package com.poiski.estoquefacilapi.repository.custom;

import static com.poiski.estoquefacilapi.model.QEntradaEstoque.entradaEstoque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class EntradaEstoqueRepositoryImpl implements EntradaEstoqueRepositoryCustom
{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public EntradaEstoque findByProduct(final Long productId) {
        return new JPAQueryFactory(this.em).selectFrom(entradaEstoque)
							        		.where(entradaEstoque.produto.id.eq(productId))
							        		.fetchFirst();
    }
    
    @Override
    public Double getQtdSumByProduct(final Long productId) {
        Double result = new JPAQueryFactory(this.em).select(entradaEstoque.quantidade.sum())
        											.from(entradaEstoque)
													.where(entradaEstoque.produto.id.eq(productId))
													.fetchFirst();
        if (result == null) {
            result = 0.0;
        }
        return result;
    }
}
