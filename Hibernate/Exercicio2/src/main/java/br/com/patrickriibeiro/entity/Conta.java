package br.com.patrickriibeiro.entity;

import java.io.Serializable;

public class Conta implements Serializable {

    private int agencia;
    private String contaCorrente;
    private String cpf;
    private double saldo;

    public Conta() {
    }

    public Conta(int agencia, String contaCorrente, String cpf, double saldo) {
        this.agencia = agencia;
        this.contaCorrente = contaCorrente;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
