package com.poiski.estoquefacilapi.repository.custom;

import static com.poiski.estoquefacilapi.model.QUsuario.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.poiski.estoquefacilapi.model.Usuario;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom
{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Usuario loginUser(final String name, final String pass) {
        return new JPAQueryFactory(this.em).selectFrom(usuario)
        		.where(usuario.nome.equalsIgnoreCase(name).and(usuario.senha.eq(pass)))
        		.fetchFirst();
    }
    
    @Override
    public Usuario findByName(final String name) {
        return new JPAQueryFactory(this.em).selectFrom(usuario)
        		.where(usuario.nome.equalsIgnoreCase(name))
        		.fetchFirst();
    }
}
