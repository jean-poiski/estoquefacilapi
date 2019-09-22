package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CreateException;
import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.poiski.estoquefacilapi.model.SaidaEstoque;
import com.poiski.estoquefacilapi.model.VendaAvulsa;
import com.poiski.estoquefacilapi.repository.VendaAvulsaRepository;

@Service
public class VendaAvulsaService extends CrudService<VendaAvulsa, VendaAvulsaRepository> {
	
	@Autowired
	private EntradaEstoqueService entEstoqueServ;
	
	@Autowired
	private SaidaEstoqueService saiEstoqueServ;
	
	@Autowired
	private ProdutoService produtoServ;

	public VendaAvulsaService(VendaAvulsaRepository repository) {
		super(repository);
		
		addBeforeCreateHook(this::validarProdutoEstoque);
		addBeforeCreateHook(this::registrarSaidaEstoque);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("dataInclusao"));
	}
	
	private VendaAvulsa validarProdutoEstoque(VendaAvulsa venda) throws CreateException {
		
		EntradaEstoque produtoEstoque = entEstoqueServ.buscarPorProduto(venda.getProduto().getId());
		
		if(produtoEstoque == null || produtoEstoque.getQuantidade() <= 0L)
			throw new CreateException(String.format("Produto %s não disponível no estoque.", venda.getProduto().getDescricao()));
		
		Double somaSaidas = this.saiEstoqueServ.buscarSomaSaidasPorProduto(venda.getProduto().getId());
		
		if(produtoEstoque.getQuantidade() < (somaSaidas + venda.getQuantidade()))
			throw new CreateException("A quantidade vendida ultrapassa a quantia disponível em estoque.");
		
		return venda;
	}
	
	private VendaAvulsa registrarSaidaEstoque(VendaAvulsa venda) throws CreateException {
		
		SaidaEstoque produtoEstoque = new SaidaEstoque();
			
		produtoEstoque.setProduto(venda.getProduto());
		produtoEstoque.setQuantidade(venda.getQuantidade());
		produtoEstoque.setValor(venda.getValor());
		produtoEstoque.setDataInclusao(new Date());
			
		produtoEstoque = saiEstoqueServ.create(produtoEstoque);
		
		venda.setEstoque(produtoEstoque);
		
		return venda;
	}
	
	public VendaAvulsa registrarVenda(Double valor, Double quantidade, Long idProduto) throws CreateException {
		
		VendaAvulsa novaVenda = new VendaAvulsa();
		novaVenda.setQuantidade(quantidade);
		novaVenda.setValor(valor);
		
		novaVenda.setProduto(produtoServ.read(idProduto));
		
		return this.create(novaVenda);
	}

}
