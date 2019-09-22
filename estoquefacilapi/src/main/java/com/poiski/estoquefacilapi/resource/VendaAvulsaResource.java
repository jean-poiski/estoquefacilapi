package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.VendaAvulsa;
import com.poiski.estoquefacilapi.service.VendaAvulsaService;

@RestController
@RequestMapping("/venda/avulsa")
@CrossOrigin
public class VendaAvulsaResource extends CrudResource<VendaAvulsa, VendaAvulsaService> {

	public VendaAvulsaResource(VendaAvulsaService service) {
		super(service);
	}
	
	@PostMapping
	public VendaAvulsa registra(@PathVariable Double valor, @PathVariable Double quantidade, @PathVariable Long produto) throws Exception {
		
		return this.service.registrarVenda(valor, quantidade, produto);
	}

}
