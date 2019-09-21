package com.poiski.estoquefacilapi.repository.custom;

import static com.poiski.estoquefacilapi.model.QEntradaEstoque.entradaEstoque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class EntradaEstoqueRepositoryImpl implements EntradaEstoqueRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public EntradaEstoque findByProduct(Long productId) {
		
		return new JPAQueryFactory(em).selectFrom(entradaEstoque)
									  .where(entradaEstoque.produto.id.eq(productId))
									  .fetchFirst();
	}

}
