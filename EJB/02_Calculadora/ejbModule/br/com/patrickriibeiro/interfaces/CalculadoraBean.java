package br.com.patrickriibeiro.interfaces;

import javax.ejb.Stateless;

@Stateless
public class CalculadoraBean implements CalculadoraLocal {

	@Override
	public double somar(double x, double y) {
		return x + y;
	}

	@Override
	public double subtrair(double x, double y) {
		return x - y;
	}

	@Override
	public double multiplicar(double x, double y) {
		return x * y;
	}

	@Override
	public double dividir(double x, double y) {
		return x / y;
	}

}
