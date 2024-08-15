package br.com.patrickriibeiro;

import br.com.patrickriibeiro.entity.Cliente;
import br.com.patrickriibeiro.entity.Pedidos;
import br.com.patrickriibeiro.helper.ClienteHelper;
import br.com.patrickriibeiro.helper.PedidosHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
        EntityManager em = emf.createEntityManager();
        ClienteHelper clienteDao = new ClienteHelper(em);
        PedidosHelper pedidosDao = new PedidosHelper(em);

        Cliente cliente = new Cliente();
        cliente.setNome("Patrick");
        cliente.setEmail("teste");
        clienteDao.salvar(cliente);

        Pedidos pedidos = new Pedidos();
        pedidos.setDescricao("teste");
        pedidos.setValor(2.0);
        pedidos.setData(new Date());
        pedidosDao.salvar(pedidos);

        pedidosDao.salvarPedidoCliente(pedidosDao.findById(1).getIdPedido(),pedidos);

    }
}