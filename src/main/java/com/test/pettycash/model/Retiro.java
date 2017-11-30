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
@Table(name = "retiro")
public class Retiro implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "idpedido")
	private long idPedido;

	@Column(name = "fechaaprueba")
	private Timestamp fechaAprueba;

	protected Retiro() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}


	public Timestamp getFechaAprueba() {
		return fechaAprueba;
	}

	public void setFechaAprueba(Timestamp fechaAprueba) {
		this.fechaAprueba = fechaAprueba;
	}

	public Retiro(long idPedido, Timestamp fechaAprueba) {
		this.idPedido = idPedido;
		this.fechaAprueba = fechaAprueba;
	}

	@Override
	public String toString() {
		return String.format("Retiro[id=%d, idPedido=%d, fechaAprueba=='%s']", id, idPedido, fechaAprueba);
	}
}