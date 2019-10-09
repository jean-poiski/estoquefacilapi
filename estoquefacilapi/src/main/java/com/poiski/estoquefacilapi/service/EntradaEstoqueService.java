package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CreateException;
import com.alon.spring.crud.service.CrudService;
import com.alon.spring.crud.service.DeleteException;
import com.alon.spring.crud.service.UpdateException;
import com.poiski.estoquefacilapi.model.Despesa;
import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.poiski.estoquefacilapi.repository.EntradaEstoqueRepository;

@Service
public class EntradaEstoqueService extends CrudService<EntradaEstoque, EntradaEstoqueRepository> {
	
	@Autowired
	private DespesaService despesaServ;

	public EntradaEstoqueService(EntradaEstoqueRepository repository) {
		super(repository);
		
		addBeforeCreateHook(this::onBeforeCreate);
		addBeforeUpdateHook(this::onBeforeUpdate);
		addBeforeDeleteHook(this::excluirDespesa);
		addAfterCreateHook(this::gerarDespesa);
		addAfterUpdateHook(this::gerarDespesa);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("dataInclusao"));
	}
	
	public EntradaEstoque buscarPorProduto(Long idProduto) {
		return this.repository.findByProduct(idProduto);
	}
    
    public Double buscaSomaQtdPorProduto(final Long idProduto) {
        return this.repository.getQtdSumByProduct(idProduto);
    }
    
    private EntradaEstoque onBeforeCreate(final EntradaEstoque entrada) throws CreateException {
        entrada.setDataInclusao(new Date());
        return entrada;
    }
    
    private EntradaEstoque onBeforeUpdate(final EntradaEstoque entrada) throws UpdateException {
        entrada.setDataAlteracao(new Date());
        return entrada;
    }
    
    private EntradaEstoque gerarDespesa(final EntradaEstoque entrada) throws CreateException, UpdateException {
        final Despesa novaDespesa = new Despesa();
        novaDespesa.setDataInclusao(new Date());
        novaDespesa.setDescricao(String.format("Entrada do produto %s em estoque", entrada.getProduto().getDescricao()));
        novaDespesa.setObservacoes(String.format("Despesa gerada automaticamente a partir da entrada de %s itens do produto %s", entrada.getQuantidade(), entrada.getProduto().getDescricao()));
        novaDespesa.setValor(entrada.getQuantidade() * entrada.getValor());
        novaDespesa.setEstoque(entrada);
        this.despesaServ.create(novaDespesa);
        return entrada;
    }
    
    private Long excluirDespesa(final Long idEntradaEstoque) throws DeleteException {
        final Despesa desp = this.despesaServ.buscarPorEntradaEstoque(idEntradaEstoque);
        if (desp != null) {
            this.despesaServ.delete(desp.getId());
        }
        return idEntradaEstoque;
    }
}
