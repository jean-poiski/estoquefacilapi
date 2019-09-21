package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.Fornecedor;
import com.poiski.estoquefacilapi.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
@CrossOrigin
public class FornecedorResource extends CrudResource<Fornecedor, FornecedorService> {

	public FornecedorResource(FornecedorService service) {
		super(service);
	}

}
