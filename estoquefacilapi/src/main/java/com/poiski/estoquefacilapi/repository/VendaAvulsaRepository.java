package com.poiski.estoquefacilapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.poiski.estoquefacilapi.model.VendaAvulsa;

public interface VendaAvulsaRepository extends JpaRepository<VendaAvulsa, Long>, JpaSpecificationExecutor<VendaAvulsa> {

}
