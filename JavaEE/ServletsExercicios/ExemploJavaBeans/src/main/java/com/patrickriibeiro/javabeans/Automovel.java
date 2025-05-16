package com.patrickriibeiro.javabeans;

import java.io.Serializable;

public class Automovel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String marca, modelo;
	private int ano;

	public Automovel(String marca, String modelo, int ano) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMensagem() {
		if (ano > 2009) {
			return "Carro novo";
		} else {
			return "Carro velho";
		}
	}

}
