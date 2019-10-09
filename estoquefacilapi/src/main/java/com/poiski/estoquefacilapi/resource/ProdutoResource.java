package com.poiski.estoquefacilapi.resource;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alon.spring.crud.service.CrudService;
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

    @GetMapping({ "/codigoBarras/{barras}" })
    public Produto codigoBarras(@PathVariable final String barras) {
        return ((ProdutoService)this.service).buscaPorCodigoBarras(barras);
    }
    
    @GetMapping({ "/buscaDsCdBarra/{termo}" })
    public List<Produto> buscaDsCdBarra(@PathVariable final String termo) {
        return (List<Produto>)((ProdutoService)this.service).buscaPorCodBarrasDescricao(termo);
    }

}
