package com.test.pettycash.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.pettycash.model.Pedido;
import com.test.pettycash.repo.PedidoRepository;

@RestController
public class PedidoController {

	@Autowired
	PedidoRepository repository;

	@RequestMapping(value = "/postpedido", method = RequestMethod.POST)
	public void postPedido(@RequestBody Pedido pedido) {
		Instant instant = Instant.now();
		Timestamp ts = instant != null ? new Timestamp(instant.toEpochMilli()) : null;
		repository.save(new Pedido(pedido.getNombre(), pedido.getMontoPedido(), "Pedido", ts));
	}

}
