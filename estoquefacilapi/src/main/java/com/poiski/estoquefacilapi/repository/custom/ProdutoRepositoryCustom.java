package com.poiski.estoquefacilapi.repository.custom;

import com.poiski.estoquefacilapi.model.Produto;
import java.util.List;

public interface ProdutoRepositoryCustom
{
    List<Produto> findByTerm(final String term);
}
