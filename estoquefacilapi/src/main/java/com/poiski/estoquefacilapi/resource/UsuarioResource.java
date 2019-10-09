package com.poiski.estoquefacilapi.resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alon.spring.crud.resource.CrudResource;
import com.poiski.estoquefacilapi.model.Usuario;
import com.poiski.estoquefacilapi.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioResource extends CrudResource<Usuario, UsuarioService>
{
    public UsuarioResource(final UsuarioService service) {
        super(service);
    }
    
    @PostMapping({ "/logar" })
    public Boolean logar(@RequestBody Login login) {
        try {
            this.service.efetuarLogin(login.usuario, login.senha);
        }
        catch (Exception e) {
            throw new UnsupportedOperationException(String.format("O login falhou: %s", e.getMessage()), e);
        }
        return true;
    }
}
