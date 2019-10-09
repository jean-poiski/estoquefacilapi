package com.poiski.estoquefacilapi.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.alon.spring.crud.service.CreateException;
import com.alon.spring.crud.service.CrudService;
import com.poiski.estoquefacilapi.model.Usuario;
import com.poiski.estoquefacilapi.repository.UsuarioRepository;

@Service
public class UsuarioService extends CrudService<Usuario, UsuarioRepository>
{
    private static Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);
    
    public UsuarioService(final UsuarioRepository repository) {
        super(repository);
        Usuario admin = this.repository.findByName("admin");
        if (admin == null) {
            admin = new Usuario("admin", "admin@estoquefacil!", "jean.poiski@icloud.com");
            try {
                this.create(admin);
            }
            catch (CreateException e) {
                LOGGER.error(String.format("Erro ao cadastrar o usu\u00e1rio admin automaticamente: %s", e.getMessage()), (Throwable)e);
            }
        }
    }
    
    @Override
    public List<Order> getDefaultSort() {
        return Collections.singletonList(Order.desc("dataInclusao"));
    }
    
    public Usuario efetuarLogin(final String nome, final String senha) throws Exception {
        final Usuario user = this.repository.loginUser(nome, senha);
        if (user == null) {
            throw new Exception(String.format("Não encontramos o usuário '%s' :(", nome));
        }
        return user;
    }
}
