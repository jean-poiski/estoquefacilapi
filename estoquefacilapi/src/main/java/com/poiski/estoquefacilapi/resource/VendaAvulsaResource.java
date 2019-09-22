package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/registra")
	public VendaAvulsa registra(@RequestBody ParamVenda params) throws Exception {
		
		return this.service.registrarVenda(params.valor, params.quantidade, params.produto);
	}
	
	@PostMapping("/atualiza")
	public VendaAvulsa atualiza(@RequestBody ParamVenda params) throws Exception {
		
		return this.service.atualizarVenda(params.venda, params.valor, params.quantidade);
	}
	
	
	@DeleteMapping("/exclui/{venda}")
	public void exclui(@PathVariable Long venda) throws Exception {
		this.service.excluirVenda(venda);
	}

	

}
