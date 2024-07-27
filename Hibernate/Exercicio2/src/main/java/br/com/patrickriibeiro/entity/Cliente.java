package br.com.patrickriibeiro.entity;

import java.io.Serializable;
import java.util.Date;

public class Cliente implements Serializable {

    private String cpf;
    private String nome;
    private Date dataNasc;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, Date dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
}
