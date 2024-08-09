package br.com.patrickriibeiro;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import br.com.patrickriibeiro.interfaces.CalculadoraLocal;

@ManagedBean(name = "calcMB")
public class CalculadoraManagedBean {

	// informamos o local do EJB via JNDI
	@EJB(lookup = "ejb:/02_Calculadora/CalculadoraBean!br.com.ead.interfaces.CalculadoraLocal")
	private CalculadoraLocal calc;

	private double x, y;
	private String resultado;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getResultado() {
		return resultado;
	}

	public void somar() {
		double result = calc.somar(x, y);
		resultado = "Soma = " + result;
	}

	public void subtrair() {
		double result = calc.subtrair(x, y);
		resultado = "Subtração = " + result;
	}

	public void multiplicar() {
		double result = calc.multiplicar(x, y);
		resultado = "Multiplicação = " + result;
	}

	public void dividir() {
		double result = calc.dividir(x, y);
		resultado = "Divisão = " + result;
	}

}
