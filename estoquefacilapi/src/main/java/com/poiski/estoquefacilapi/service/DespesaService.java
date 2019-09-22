package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.Despesa;
import com.poiski.estoquefacilapi.repository.DespesaRepository;

@Service
public class DespesaService extends CrudService<Despesa, DespesaRepository> {

	public DespesaService(DespesaRepository repository) {
		super(repository);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.desc("dataInclusao"));
	}
	
	@Override
	public Despesa read(Long id) {
		Optional<Despesa> registro = this.repository.findById(id);
		
		if(registro.isEmpty())
			throw new UnsupportedOperationException("Despesa não encontrada");
			
		return registro.get();
	}
	

}
