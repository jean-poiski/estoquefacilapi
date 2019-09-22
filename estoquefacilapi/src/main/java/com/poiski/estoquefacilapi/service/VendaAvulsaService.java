package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CreateException;
import com.alon.spring.crud.service.CrudService;
import com.alon.spring.crud.service.DeleteException;
import com.alon.spring.crud.service.UpdateException;
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
		addBeforeUpdateHook(this::validarProdutoEstoque);
		addBeforeUpdateHook(this::atualizarSaidaEstoque);
		addBeforeDeleteHook(this::excluirSaidaEstoque);
	}

	@Override
	public List<Order> getDefaultSort() {
		return Collections.singletonList(Order.asc("dataInclusao"));
	}
	
	@Override
	public VendaAvulsa read(Long id) {
		
		Optional<VendaAvulsa> venda = this.repository.findById(id);
		
		if(venda.isEmpty())
			throw new UnsupportedOperationException("Venda não encontrada");
		
		return venda.get();
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
	
	private VendaAvulsa atualizarSaidaEstoque(VendaAvulsa venda) throws UpdateException {
		
		SaidaEstoque produtoEstoque = this.saiEstoqueServ.read(venda.getEstoque().getId());
			
		produtoEstoque.setQuantidade(venda.getQuantidade());
		produtoEstoque.setValor(venda.getValor());
		produtoEstoque.setDataAlteracao(new Date());
			
		produtoEstoque = saiEstoqueServ.update(produtoEstoque);
		
		venda.setEstoque(produtoEstoque);
		
		return venda;
	}
	
	private Long excluirSaidaEstoque(Long idVenda) throws DeleteException {
		
		VendaAvulsa venda = this.read(idVenda);
			
		if(venda.getEstoque() != null)
			saiEstoqueServ.delete(venda.getEstoque().getId());
		
		return idVenda;
	}

	public VendaAvulsa registrarVenda(Double valor, Double quantidade, Long idProduto) throws CreateException {
		
		VendaAvulsa novaVenda = new VendaAvulsa();
		novaVenda.setQuantidade(quantidade);
		novaVenda.setValor(valor);
		
		novaVenda.setProduto(produtoServ.read(idProduto));
		
		return this.create(novaVenda);
	}
	
	public VendaAvulsa atualizarVenda(Long idVenda, Double valor, Double quantidade) throws UpdateException {
		
		VendaAvulsa venda = this.read(idVenda);
		venda.setQuantidade(quantidade);
		venda.setValor(valor);
		
		return this.update(venda);
	}
	
	public void excluirVenda(Long idVenda) throws DeleteException {
		
		this.delete(idVenda);
	}

}
