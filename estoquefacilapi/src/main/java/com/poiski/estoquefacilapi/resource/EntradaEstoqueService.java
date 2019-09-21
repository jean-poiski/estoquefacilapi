package com.poiski.estoquefacilapi.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort.Order;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.poiski.estoquefacilapi.repository.EntradaEstoqueRepository;

public class EntradaEstoqueService extends CrudService<EntradaEstoque, EntradaEstoqueRepository> {

	public EntradaEstoqueService(EntradaEstoqueRepository repository) {
		super(repository);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.desc("dataInclusao"));
	}

}
