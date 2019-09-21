package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.Produto;
import com.poiski.estoquefacilapi.repository.ProdutoRepository;

@Service
public class ProdutoService extends CrudService<Produto, ProdutoRepository> {

	public ProdutoService(ProdutoRepository repository) {
		super(repository);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("descricao"));
	}

}
