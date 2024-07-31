package br.com.patrickriibeiro.helper;

import br.com.patrickriibeiro.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.Objects;

public class ClienteHelper {

    private EntityManager em;

    public ClienteHelper(EntityManager em) {
        this.em = em;
    }

    public Cliente findById(Integer id){
        return em.find(Cliente.class, id);
    }

    public String salvar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            return "Objeto salvo";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String excluir(Integer idCliente) {
        try {
            Cliente cliente = em.find(Cliente.class, idCliente);
            if (Objects.nonNull(cliente)) {
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
                return "cliente excluido";
            } else {
                return "cliente não encontrado";
            }

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String atualizar(Cliente cliente) {
        try {
            em.getTransaction().begin();
            Cliente clienteManager = em.find(Cliente.class, cliente.getIdCliente());
            if (Objects.nonNull(clienteManager)) {
                if (Objects.nonNull(cliente.getNome()) || !cliente.getNome().isEmpty()) {
                    clienteManager.setNome(cliente.getNome());
                }
                if (Objects.nonNull(cliente.getEmail()) || !cliente.getEmail().isEmpty()) {
                    clienteManager.setEmail(cliente.getEmail());
                }
                em.merge(clienteManager);
                em.getTransaction().commit();
                return "cliente atualizado";
            } else {
                return "cliente não encontrado";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
