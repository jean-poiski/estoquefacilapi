package com.poiski.estoquefacilapi.repository.custom;

import com.poiski.estoquefacilapi.model.Usuario;

public interface UsuarioRepositoryCustom
{
    Usuario loginUser(final String name, final String pass);
    
    Usuario findByName(final String name);
}
