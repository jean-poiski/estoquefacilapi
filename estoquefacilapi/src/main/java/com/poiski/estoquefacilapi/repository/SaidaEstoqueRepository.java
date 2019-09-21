package com.poiski.estoquefacilapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.poiski.estoquefacilapi.model.SaidaEstoque;
import com.poiski.estoquefacilapi.repository.custom.SaidaEstoqueRepositoryCustom;

public interface SaidaEstoqueRepository extends JpaRepository<SaidaEstoque, Long>, JpaSpecificationExecutor<SaidaEstoque>, SaidaEstoqueRepositoryCustom {

}
