package br.com.patrickriibeiro.helper;

import br.com.patrickriibeiro.entity.Cliente;
import br.com.patrickriibeiro.entity.Pedidos;

import javax.persistence.EntityManager;
import java.util.Objects;

public class PedidosHelper {

    private EntityManager em;

    public PedidosHelper(EntityManager em) {
        this.em = em;
    }

    public Pedidos findById(Integer id){
        return em.find(Pedidos.class, id);
    }

    public String salvar(Pedidos pedido) {
        try {
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
            return "pedido salvo com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluir(Integer idPedido) {
        try {
            Pedidos pedido = em.find(Pedidos.class, idPedido);
            if (Objects.nonNull(pedido)) {
                em.getTransaction().begin();
                em.remove(pedido);
                em.getTransaction().commit();
                return "pedido excluido";
            } else {
                return "pedido não encontrado";
            }

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String salvarPedidoCliente(Integer idCliente, Pedidos pedido) {
        try {
            Cliente cliente = em.find(Cliente.class, idCliente);
            pedido.setIdCliente(cliente);
            cliente.getListaPedidos().add(pedido);
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return "pedido adicionado com sucesso";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
