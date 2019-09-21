package com.poiski.estoquefacilapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.poiski.estoquefacilapi.model.EntradaEstoque;

public interface EntradaEstoqueRepository extends JpaRepository<EntradaEstoque, Long>, JpaSpecificationExecutor<EntradaEstoque> {

}
