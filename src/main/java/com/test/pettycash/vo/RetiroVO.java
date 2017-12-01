package com.test.pettycash.vo;

import java.sql.Timestamp;

public class RetiroVO {

	private String nombre;
	private Double monto;

	private Timestamp fechaAprueba;

	public RetiroVO() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Timestamp getFechaAprueba() {
		return fechaAprueba;
	}

	public void setFechaAprueba(Timestamp fechaAprueba) {
		this.fechaAprueba = fechaAprueba;
	}

}