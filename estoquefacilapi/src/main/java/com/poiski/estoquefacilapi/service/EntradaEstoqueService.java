package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.poiski.estoquefacilapi.repository.EntradaEstoqueRepository;

@Service
public class EntradaEstoqueService extends CrudService<EntradaEstoque, EntradaEstoqueRepository> {

	public EntradaEstoqueService(EntradaEstoqueRepository repository) {
		super(repository);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("dataInclusao"));
	}

}
