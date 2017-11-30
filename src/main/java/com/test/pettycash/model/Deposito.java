package com.test.pettycash.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deposito")
public class Deposito implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "idusuario")
	private long idUsuario;

	@Column(name = "montodeposito")
	private Double montoDeposito;

	protected Deposito() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Double getMontoDeposito() {
		return montoDeposito;
	}

	public void setMontoDeposito(Double montoDeposito) {
		this.montoDeposito = montoDeposito;
	}

	public Deposito(long idUsuario, Double montoDeposito) {
		this.idUsuario = idUsuario;
		this.montoDeposito = montoDeposito;
	}

	@Override
	public String toString() {
		return String.format("Deposito[id=%d, idUsuario=%d, montoDeposito=%d]", id, idUsuario, montoDeposito);
	}
}