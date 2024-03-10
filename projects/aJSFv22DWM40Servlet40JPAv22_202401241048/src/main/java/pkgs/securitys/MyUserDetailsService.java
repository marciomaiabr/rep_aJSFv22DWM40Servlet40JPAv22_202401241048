package pkgs.securitys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pkgs.models.Usuario;
import pkgs.repositoryEspec.UsuarioRepositoryEspec;
import pkgs.utils.CDIServiceLocator;

public class MyUserDetailsService implements Serializable , UserDetailsService {

	private static final long serialVersionUID = 20240310070601L;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UsuarioRepositoryEspec ur = CDIServiceLocator.getBean(UsuarioRepositoryEspec.class);
		Usuario usuario = ur.porEmail(email);

		if (usuario != null) {
			UserDetails userDetails = new MyUserDetailsUser(usuario, getAuthorities(usuario));
			return userDetails;
		}

		return null;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		usuario.getGruposUsuario().forEach(gu -> {authorities.add(new SimpleGrantedAuthority(gu.getNome().toUpperCase()));});
		return authorities;
	}

}
