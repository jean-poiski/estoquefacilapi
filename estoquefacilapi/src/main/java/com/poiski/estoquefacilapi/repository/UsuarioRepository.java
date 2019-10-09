package com.poiski.estoquefacilapi.repository;

import com.poiski.estoquefacilapi.repository.custom.UsuarioRepositoryCustom;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.poiski.estoquefacilapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>, UsuarioRepositoryCustom
{
}
