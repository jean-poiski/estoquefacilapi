package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CreateException;
import com.alon.spring.crud.service.CrudService;
import com.alon.spring.crud.service.UpdateException;
import com.poiski.estoquefacilapi.model.SaidaEstoque;
import com.poiski.estoquefacilapi.repository.SaidaEstoqueRepository;

@Service
public class SaidaEstoqueService extends CrudService<SaidaEstoque, SaidaEstoqueRepository> {

    @Autowired
    private EntradaEstoqueService entEstoqueServ;
    
	public SaidaEstoqueService(SaidaEstoqueRepository repository) {
		super(repository);
        this.addBeforeCreateHook(this::onBeforeCreate);
        this.addBeforeUpdateHook(this::onBeforeUpdate);
	}
    private SaidaEstoque onBeforeCreate(final SaidaEstoque saida) throws CreateException {
        final Double somaEntradas = this.entEstoqueServ.buscaSomaQtdPorProduto(saida.getProduto().getId());
        if (somaEntradas == null || somaEntradas <= 0.0) {
            throw new CreateException(String.format("Produto %s não disponível no estoque.", saida.getProduto().getDescricao()));
        }
        final Double somaSaidas = this.buscarSomaSaidasPorProduto(saida.getProduto().getId());
        if (somaEntradas < somaSaidas) {
            throw new CreateException("A quantidade vendida ultrapassa a quantia disponível em estoque.");
        }
        saida.setDataInclusao(new Date());
        return saida;
    }
    
    private SaidaEstoque onBeforeUpdate(final SaidaEstoque saida) throws UpdateException {
        saida.setDataAlteracao(new Date());
        return saida;
    }
    
	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("dataInclusao"));
	}
	
	@Override
	public SaidaEstoque read(Long id) {
		Optional<SaidaEstoque> registro = this.repository.findById(id);
		
		if(registro.isEmpty())
			throw new UnsupportedOperationException("Registro de saída do estoque não encontrado");
			
		return registro.get();
	}
	
	public SaidaEstoque buscarPorProduto(Long idProduto) {
		
		Optional<SaidaEstoque> result = this.repository.findOne(new Specification<SaidaEstoque>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<SaidaEstoque> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.equal(root.get("produtoId"), idProduto);
			}
		});
		
		if(result.isPresent())
			return result.get();
		
		return null;
	}
	
	public Double buscarSomaSaidasPorProduto(Long idProduto) {
		return this.repository.getQtdSumByProduct(idProduto);
	}
	

}