package br.com.patrickriibeiro.helper;

import br.com.patrickriibeiro.entity.Forum;
import br.com.patrickriibeiro.entity.Usuario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

public class ForumHelper {

    private EntityManager em;

    public ForumHelper(EntityManager em) {
        this.em = em;
    }

    public String salvar(Forum forum) {
        try {
            em.getTransaction().begin();
            em.persist(forum);
            em.getTransaction().commit();
            return "Objeto salvo";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String adicionarUsuario(int idForum, Usuario usuario){
        try {
            Forum f = em.find(Forum.class, idForum);
            usuario.setForum(f);
            f.getUsuarios().add(usuario);
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return "Inclusão realizada!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
