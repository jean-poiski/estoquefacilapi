package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.alon.spring.crud.service.CreateException;
import com.poiski.estoquefacilapi.model.Produto;
import com.poiski.estoquefacilapi.model.VendaAvulsa;
import com.poiski.estoquefacilapi.service.VendaAvulsaService;

@RestController
@RequestMapping("/vendaavulsa")
@CrossOrigin
public class VendaAvulsaResource extends CrudResource<VendaAvulsa, VendaAvulsaService> {

	public VendaAvulsaResource(VendaAvulsaService service) {
		super(service);
	}
	
	@PostMapping
	public VendaAvulsa registrarVenda(@PathVariable Double valor, @PathVariable Double quantidade, @PathVariable Long produto) throws CreateException {
		
		VendaAvulsa novaVenda = new VendaAvulsa();
		novaVenda.setQuantidade(quantidade);
		novaVenda.setValor(valor);
		
		novaVenda.setProduto(new Produto());
		novaVenda.getProduto().setId(produto);
		
		return this.service.registrarVenda(novaVenda);
	}

}
