package com.poiski.estoquefacilapi.repository.custom;

import static com.poiski.estoquefacilapi.model.QDespesa.despesa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.poiski.estoquefacilapi.model.Despesa;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class DespesaRepositoryImpl implements DespesaRepositoryCutsom
{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Despesa searchByStock(final Long idStock) {
        return new JPAQueryFactory(this.em).selectFrom(despesa).where(despesa.estoque.id.eq(idStock)).fetchFirst();
    }
}
