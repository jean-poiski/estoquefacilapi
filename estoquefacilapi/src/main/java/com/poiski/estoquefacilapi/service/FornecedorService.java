package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.Fornecedor;
import com.poiski.estoquefacilapi.repository.FornecedorRepository;

@Service
public class FornecedorService extends CrudService<Fornecedor, FornecedorRepository> {
	
	@Autowired
	public FornecedorService(FornecedorRepository repository) {
		super(repository);
	}
	
	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("cnpj"));
	}



}
