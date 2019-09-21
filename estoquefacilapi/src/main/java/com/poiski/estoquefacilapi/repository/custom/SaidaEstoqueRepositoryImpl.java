package com.poiski.estoquefacilapi.repository.custom;

import static com.poiski.estoquefacilapi.model.QSaidaEstoque.saidaEstoque;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class SaidaEstoqueRepositoryImpl implements SaidaEstoqueRepositoryCustom {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Double getQtdSumByProduct(Long productId) {
		
		Double result = new JPAQueryFactory(em).select(saidaEstoque.quantidade.sum())
											    .from(saidaEstoque)
												.where(saidaEstoque.produto.id.eq(productId))
												.fetchFirst();
		
		if(result == null)
			result = 0D;
		
		return result;
	}

}
