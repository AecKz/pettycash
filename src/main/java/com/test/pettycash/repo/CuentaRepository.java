package com.test.pettycash.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.pettycash.model.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
	List<Cuenta> findByTipoTransaccion(String tipoTransaccion);
	List<Cuenta> findTop10ByOrderByFechaTransaccionDesc();
}