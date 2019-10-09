package com.poiski.estoquefacilapi.repository.custom;

import static com.poiski.estoquefacilapi.model.QProduto.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.poiski.estoquefacilapi.model.Produto;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom
{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Produto> findByTerm(final String term) {
        return new JPAQueryFactory(this.em).selectFrom(produto)
        									.where(produto.codigoBarras.eq(term).or(produto.descricao.toLowerCase().like(term.toLowerCase()+"%"))).fetch();
    }
}
