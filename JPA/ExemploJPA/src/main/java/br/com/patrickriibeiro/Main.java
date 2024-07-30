package br.com.patrickriibeiro;

import br.com.patrickriibeiro.entity.Forum;
import br.com.patrickriibeiro.entity.Usuario;
import br.com.patrickriibeiro.helper.ForumHelper;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Forum");
        EntityManager em = emf.createEntityManager();
        ForumHelper dao = new ForumHelper(em);

        Forum forum = new Forum();
        forum.setAssunto("JPA");
        forum.setDescricao("Java Persistence API");

        System.out.println(dao.salvar(forum));

        Usuario usuario = new Usuario();
        usuario.setNome("Joaquim");
        usuario.setEmail("joaquim@ead.com.br");
        System.out.println(dao.adicionarUsuario(forum.getId(), usuario));
    }
}