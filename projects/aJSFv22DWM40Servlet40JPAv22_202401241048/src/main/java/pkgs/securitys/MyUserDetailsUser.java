package pkgs.securitys;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import pkgs.models.Usuario;

public class MyUserDetailsUser extends User {

	private static final long serialVersionUID = 20240310070601L;

	private Usuario usuario;

	public MyUserDetailsUser(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
