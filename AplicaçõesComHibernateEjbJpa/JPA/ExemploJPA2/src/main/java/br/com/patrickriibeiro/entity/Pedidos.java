package br.com.patrickriibeiro.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedidos", schema = "loja")
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @Column(name = "DESCRICAO", length = 45)
    private String descricao;

    @Column(name = "VALOR")
    private Double valor;

    public Pedidos(Integer idPedido, Cliente cliente, Date data, String descricao, Double valor) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Pedidos() {
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
}
