package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort.Order;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.SaidaEstoque;
import com.poiski.estoquefacilapi.repository.SaidaEstoqueRepository;

public class SaidaEstoqueService extends CrudService<SaidaEstoque, SaidaEstoqueRepository> {

	public SaidaEstoqueService(SaidaEstoqueRepository repository) {
		super(repository);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("dataInclusao"));
	}

}
