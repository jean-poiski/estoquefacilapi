package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.SaidaEstoque;
import com.poiski.estoquefacilapi.repository.SaidaEstoqueRepository;

@Service
public class SaidaEstoqueService extends CrudService<SaidaEstoque, SaidaEstoqueRepository> {

	public SaidaEstoqueService(SaidaEstoqueRepository repository) {
		super(repository);
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