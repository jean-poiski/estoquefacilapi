package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.Produto;
import com.poiski.estoquefacilapi.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoResource extends CrudResource<Produto, ProdutoService> {

	public ProdutoResource(ProdutoService service) {
		super(service);
	}

}
