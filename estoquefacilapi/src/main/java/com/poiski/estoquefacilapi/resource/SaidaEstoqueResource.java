package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.SaidaEstoque;
import com.poiski.estoquefacilapi.service.SaidaEstoqueService;

@RestController
@RequestMapping("/saidaestoque")
@CrossOrigin
public class SaidaEstoqueResource extends CrudResource<SaidaEstoque, SaidaEstoqueService> {

	public SaidaEstoqueResource(SaidaEstoqueService service) {
		super(service);
	}

}
