package com.poiski.estoquefacilapi.repository;

import com.poiski.estoquefacilapi.repository.custom.ProdutoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.poiski.estoquefacilapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto>, ProdutoRepositoryCustom {

    Produto findByCodigoBarras(final String codigoBarras);
}
