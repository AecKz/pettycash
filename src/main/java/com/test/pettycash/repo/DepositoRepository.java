package com.test.pettycash.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.pettycash.model.Deposito;

public interface DepositoRepository extends CrudRepository<Deposito, Long> {
	List<Deposito> findByIdUsuario(long idUsuario);
}