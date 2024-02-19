package pkgs.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstado;
	private String nomeEstado;
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Estado() {
	}

	public Estado(Integer idEstado, String nomeEstado) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
	}

	public Estado(String nomeEstado) {
		super();
		this.nomeEstado = nomeEstado;
	}

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", nomeEstado=" + nomeEstado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEstado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		return Objects.equals(idEstado, other.idEstado);
	}

}
