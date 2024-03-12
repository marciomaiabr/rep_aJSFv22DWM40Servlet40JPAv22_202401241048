package pkgs.repositoryJPA;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import pkgs.models.Usuario;
import pkgs.repositoryEspec.UsuarioRepositoryEspec;

public class UsuarioRepositoryJPA implements Serializable, UsuarioRepositoryEspec {

	private static final long serialVersionUID = 20240221040803L;

	@Inject
	private EntityManager em;

	@Override
	public Usuario porEmail(String email) {
		Usuario usuario = null;

		TypedQuery<Usuario> tq = em.createQuery(" from Usuario where lower(email) = :email ", Usuario.class);
		tq.setParameter("email", email.toLowerCase());
		try {
			usuario = tq.getSingleResult();
		} catch (NoResultException e) {
		} catch (NonUniqueResultException e) {
		}

		return usuario;
	}

}
