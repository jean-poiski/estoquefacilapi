package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.EntradaEstoque;
import com.poiski.estoquefacilapi.service.EntradaEstoqueService;

@RestController
@RequestMapping("/entradaestoque")
@CrossOrigin
public class EntradaEstoqueResource extends CrudResource<EntradaEstoque, EntradaEstoqueService> {

	public EntradaEstoqueResource(EntradaEstoqueService service) {
		super(service);
	}

}
