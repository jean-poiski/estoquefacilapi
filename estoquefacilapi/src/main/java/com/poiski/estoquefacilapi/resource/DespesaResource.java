package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.Despesa;
import com.poiski.estoquefacilapi.service.DespesaService;

@RestController
@RequestMapping("/despesa")
@CrossOrigin
public class DespesaResource extends CrudResource<Despesa, DespesaService> {

	public DespesaResource(DespesaService service) {
		super(service);
	}

}
