package com.test.pettycash.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.pettycash.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
	List<Pedido> findByEstado(String estado);
}