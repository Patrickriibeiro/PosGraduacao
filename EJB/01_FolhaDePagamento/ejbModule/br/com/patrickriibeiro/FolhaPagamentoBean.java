package br.com.patrickriibeiro;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.patrickriibeiro.interfaces.FolhaPagamento;

@Stateless
@Local(FolhaPagamento.class)
public class FolhaPagamentoBean implements FolhaPagamento {
	
	private double salario;

	@Override
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public double calcularInss(double taxa) {
		return salario * taxa / 100;
	}

	@Override
	public double calcularSalarioLiquido() {
		return salario - calcularInss(10);
	}

	@Override
	public double getSalario() {
		return salario;
	}

}
