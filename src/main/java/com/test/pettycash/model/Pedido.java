package com.test.pettycash.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "montopedido")
	private Double montoPedido;

	@Column(name = "estado")
	private String estado;

	@Column(name = "fechapedido")
	private Timestamp fechaPedido;

	protected Pedido() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getMontoPedido() {
		return montoPedido;
	}

	public void setMontoPedido(Double montoPedido) {
		this.montoPedido = montoPedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Timestamp fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Pedido(String nombre, Double montoPedido, String estado, Timestamp fechaPedido) {
		this.nombre = nombre;
		this.montoPedido = montoPedido;
		this.estado = estado;
		this.fechaPedido = fechaPedido;
	}

	@Override
	public String toString() {
		return String.format("Pedido[id=%d, nombre='%s', montoPedido=%d, estado='%s', fechaPedido='%s']", id, nombre, montoPedido, estado, fechaPedido);
	}
}