package com.test.pettycash.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.pettycash.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	List<Usuario> findByUsuarioAndClave(String usuario, String clave);
}