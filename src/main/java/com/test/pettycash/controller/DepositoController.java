package com.test.pettycash.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.pettycash.model.Cuenta;
import com.test.pettycash.model.Deposito;
import com.test.pettycash.repo.CuentaRepository;
import com.test.pettycash.repo.DepositoRepository;

@RestController
public class DepositoController {

	@Autowired
	DepositoRepository depositoRepository;
	@Autowired
	CuentaRepository cuentaRepository;

	@RequestMapping(value = "custodio/postdeposito", method = RequestMethod.POST)
	public void postDeposito(@RequestBody Deposito deposito) {
		depositoRepository.save(new Deposito(deposito.getIdUsuario(),deposito.getMontoDeposito()));
		//Cambio en el estado de cuenta		
		List<Cuenta> cuentas = cuentaRepository.findTop10ByOrderByFechaTransaccionDesc();
		Double montoActual = cuentas.get(0).getMontoCuenta();
		Instant instant = Instant.now();
		Timestamp ts = instant != null ? new Timestamp(instant.toEpochMilli()) : null;
		cuentaRepository.save(new Cuenta((montoActual + deposito.getMontoDeposito()),"DEPOSITO",ts));
	}

}
