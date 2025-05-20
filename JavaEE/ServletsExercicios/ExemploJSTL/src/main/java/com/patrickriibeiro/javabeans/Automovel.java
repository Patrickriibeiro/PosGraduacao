package com.patrickriibeiro.javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	public Automovel() {
		super();
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

	public List<Automovel> getListaVeiculos() {
		List<Automovel> lista = new ArrayList<Automovel>();
		lista.add(new Automovel("Forda", "Fiesta", 2012));
		lista.add(new Automovel("Peugeot", "208", 2014));
		lista.add(new Automovel("GM", "Corsa", 2009));

		return lista;
	}

}
