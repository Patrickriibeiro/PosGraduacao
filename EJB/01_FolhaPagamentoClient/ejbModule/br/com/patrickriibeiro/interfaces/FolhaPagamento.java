package br.com.patrickriibeiro.interfaces;

public interface FolhaPagamento {

	void setSalario(double salario);

	double calcularInss(double taxa);

	double calcularSalarioLiquido();

	double getSalario();
}
