 package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CreateException;
import com.alon.spring.crud.service.CrudService;
import com.alon.spring.crud.service.UpdateException;
import com.poiski.estoquefacilapi.model.Produto;
import com.poiski.estoquefacilapi.repository.ProdutoRepository;

@Service
public class ProdutoService extends CrudService<Produto, ProdutoRepository> {

	public ProdutoService(ProdutoRepository repository) {
		super(repository);
        this.addBeforeCreateHook(this::onBeforeCreate);
        this.addBeforeUpdateHook(this::onBeforeUpdate);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("descricao"));
	}
	
	@Override
	public Produto read(Long id) {
		Optional<Produto> registro = this.repository.findById(id);
		
		if(registro.isEmpty())
			throw new UnsupportedOperationException("Produto não encontrado");
			
		return registro.get();
	}
    
    private Produto onBeforeCreate(final Produto prod) throws CreateException {
        prod.setDataInclusao(new Date());
        return prod;
    }
    
    private Produto onBeforeUpdate(final Produto prod) throws UpdateException {
        prod.setDataAlteracao(new Date());
        return prod;
    }
    
    public Produto buscaPorCodigoBarras(final String codigoBarras) {
        return this.repository.findByCodigoBarras(codigoBarras);
    }
    
    public List<Produto> buscaPorCodBarrasDescricao(final String termo) {
        return this.repository.findByTerm(termo);
    }
}
