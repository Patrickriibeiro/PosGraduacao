package br.com.patrickriibeiro.helper;

import br.com.patrickriibeiro.config.HibernateUtil;
import br.com.patrickriibeiro.entity.Forum;
import br.com.patrickriibeiro.entity.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.HashSet;
import java.util.Set;

public class ForumHelper {

    Session session = null;
    Transaction transaction = null;

    public String salvar(Forum forum) {
        try {
            session = HibernateUtil.
                    getSessionFactory
                            ().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(forum);
            transaction.commit();
            return "Forum Salvo";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String salvar(Usuario forum) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.save(forum);
            transaction.commit();
            return "Usuario Salvo";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String adicionarUsuario(int idForum, int idUsuario) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Forum f = (Forum) session.load(Forum.class, idForum);
            Usuario u = (Usuario) session.load(Usuario.class, idForum);

            f.getUsuarios().add(u);
            session.save(f);
            transaction.commit();
            return "Associação realizada";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String adicionarUsuario(int idForum, Usuario usuario) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Forum f = (Forum) session.load(Forum.class, idForum);

            usuario.setForum(f);

            f.getUsuarios().add(usuario);
            session.update(f);
            transaction.commit();
            return "Inclusao realizada";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Set<Usuario> listarUsuarios(int idForum) {
        Set<Usuario> usuarios = new HashSet<Usuario>();
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            Forum f = (Forum) session.load(Forum.class, idForum);
            usuarios = f.getUsuarios();

        } catch (Exception e) {

        }
        return usuarios;
    }

}
