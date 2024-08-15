package br.com.patrickriibeiro;

import br.com.patrickriibeiro.entity.Forum;
import br.com.patrickriibeiro.entity.Usuario;
import br.com.patrickriibeiro.helper.ForumHelper;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        incluirForum();
        incluirUsuarionoForum();
        listarUsuariosPorForum();
    }

    private static void incluirForum() {
        Forum forum = new Forum();
        forum.setIdForum(10);
        forum.setAssunto("Avaliação");
        forum.setDescricao("Avaliação da disciplina Persistência");

        ForumHelper helper = new ForumHelper();
        System.out.println(helper.salvar(forum));
    }

    private static void incluirUsuarionoForum() {
        ForumHelper helper = new ForumHelper();
        Usuario u1 = new Usuario();
        u1.setNome("teresa");
        u1.setEmail("teresa @mail.com");
        u1.setIdUsuario(1);

        Usuario u2 = new Usuario();
        u2.setNome("jonas");
        u2.setEmail("joas @mail.com");
        u2.setIdUsuario(2);

        Usuario u3 = new Usuario();
        u3.setNome("abilio");
        u3.setEmail("abilio @mail.com");
        u3.setIdUsuario(3);

        System.out.println(helper.adicionarUsuario(10, u1));
        System.out.println(helper.adicionarUsuario(10, u2));
        System.out.println(helper.adicionarUsuario(10, u3));
    }

    private static void listarUsuariosPorForum() {
        ForumHelper helper = new ForumHelper();
        Set<Usuario> usuarios = helper.listarUsuarios(10);
        for (Usuario usuario : usuarios) {
            System.out.println("ID Usuario: " + usuario.getIdUsuario());
            System.out.println("Nome Usuario: " + usuario.getNome());
            System.out.println("Email Usuario: " + usuario.getEmail());
            System.out.println("--------------------------------");
        }
    }
}