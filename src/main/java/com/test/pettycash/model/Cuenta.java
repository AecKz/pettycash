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
@Table(name = "cuenta")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "montocuenta")
	private Double montoCuenta;

	@Column(name = "tipotransaccion")
	private String tipoTransaccion;

	@Column(name = "iddeposito")
	private long idDeposito;

	@Column(name = "idretiro")
	private long idRetiro;

	@Column(name = "fechatransaccion")
	private Timestamp fechaTransaccion;

	protected Cuenta() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getMontoCuenta() {
		return montoCuenta;
	}

	public void setMontoCuenta(Double montoCuenta) {
		this.montoCuenta = montoCuenta;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public long getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(long idDeposito) {
		this.idDeposito = idDeposito;
	}

	public long getIdRetiro() {
		return idRetiro;
	}

	public void setIdRetiro(long idRetiro) {
		this.idRetiro = idRetiro;
	}

	public Timestamp getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Timestamp fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Cuenta(Double montoCuenta, String tipoTransaccion, long idDeposito, long idRetiro,
			Timestamp fechaTransaccion) {
		this.montoCuenta = montoCuenta;
		this.tipoTransaccion = tipoTransaccion;
		this.idDeposito = idDeposito;
		this.idRetiro = idRetiro;
		this.fechaTransaccion = fechaTransaccion;
	}

	@Override
	public String toString() {
		return String.format(
				"Cuenta[id=%d, montoCuenta=%d, tipoTransaccion='%s', idDeposito=%d, idRetiro=%d, fechaTransaccion=='%s']",
				id, montoCuenta, tipoTransaccion, idDeposito, idRetiro, fechaTransaccion);
	}
}