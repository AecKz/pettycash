package com.test.pettycash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.pettycash.message.Response;
import com.test.pettycash.model.Cuenta;
import com.test.pettycash.model.Usuario;
import com.test.pettycash.repo.CuentaRepository;
import com.test.pettycash.repo.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;
	@Autowired
	CuentaRepository cuentaRepository;

	@RequestMapping(value = "custodio/login", method = RequestMethod.POST)
	public Response postLogin(@RequestBody Usuario usuario) {

		List<Usuario> usuarios = repository.findByUsuarioAndClave(usuario.getUsuario(), usuario.getClave());
		if (!usuarios.isEmpty()) {
			return new Response("Done", usuarios.get(0));
		} else {
			return new Response("Error", usuario.getUsuario());
		}

	}

	@RequestMapping("custodio/consultaCuenta")
	public Response getConsultaCuenta() {
		List<Cuenta> cuentas = cuentaRepository.findTop10ByOrderByFechaTransaccionDesc();
		if (!cuentas.isEmpty()) {
			return new Response("Done", cuentas.get(0));
		} else {
			return new Response("Error", cuentas);
		}

	}
}
