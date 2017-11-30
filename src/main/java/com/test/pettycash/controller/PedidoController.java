package com.test.pettycash.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.pettycash.message.Response;
import com.test.pettycash.model.Cuenta;
import com.test.pettycash.model.Pedido;
import com.test.pettycash.model.Retiro;
import com.test.pettycash.repo.CuentaRepository;
import com.test.pettycash.repo.PedidoRepository;
import com.test.pettycash.repo.RetiroRepository;

@RestController
public class PedidoController {

	@Autowired
	PedidoRepository repository;
	@Autowired
	RetiroRepository retiroRepository;
	@Autowired
	CuentaRepository cuentaRepository;

	@RequestMapping(value = "/postpedido", method = RequestMethod.POST)
	public void postPedido(@RequestBody Pedido pedido) {
		Instant instant = Instant.now();
		Timestamp ts = instant != null ? new Timestamp(instant.toEpochMilli()) : null;
		repository.save(new Pedido(pedido.getNombre(), pedido.getMontoPedido(), "Pedido", ts));
	}

	@RequestMapping("custodio/verPedidos")
	public Response findAll() {
		Iterable<Pedido> listaPedidos = repository.findByEstado("Pedido");
		return new Response("Done", listaPedidos);
	}

	@RequestMapping("custodio/aprobarPedido")
	public Response findByLastName(@RequestParam("id") long id) {
		Pedido pedido = new Pedido();
		pedido = repository.findOne(id);
		pedido.setEstado("Aprobado");
		repository.save(pedido);
		Instant instant = Instant.now();
		Timestamp ts = instant != null ? new Timestamp(instant.toEpochMilli()) : null;
		retiroRepository.save(new Retiro(pedido.getId(), ts));
		// Cambio en estado de cuenta
		List<Cuenta> cuentas = cuentaRepository.findTop10ByOrderByFechaTransaccionDesc();
		Double montoActual = cuentas.get(0).getMontoCuenta();
		cuentaRepository.save(new Cuenta((montoActual - pedido.getMontoPedido()), "RETIRO", ts));
		return new Response("Done", pedido);
	}
}
