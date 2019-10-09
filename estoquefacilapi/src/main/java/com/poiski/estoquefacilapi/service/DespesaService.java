package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.Despesa;
import com.poiski.estoquefacilapi.repository.DespesaRepository;

@Service
public class DespesaService extends CrudService<Despesa, DespesaRepository> {

	public DespesaService(DespesaRepository repository) {
		super(repository);
        this.addBeforeCreateHook(this::onBeforeCreate);
        this.addBeforeUpdateHook(this::onBeforeUpdate);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
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
    
    private Despesa onBeforeCreate(final Despesa desp) {
        desp.setDataInclusao(new Date());
        return desp;
    }
    
    private Despesa onBeforeUpdate(final Despesa desp) {
        desp.setDataAlteracao(new Date());
        return desp;
    }
    
    public Despesa buscarPorEntradaEstoque(final Long idEntradaEstoque) {
        return this.repository.searchByStock(idEntradaEstoque);
    }
}
