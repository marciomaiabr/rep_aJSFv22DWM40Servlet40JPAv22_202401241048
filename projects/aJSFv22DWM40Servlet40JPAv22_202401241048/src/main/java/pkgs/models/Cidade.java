package pkgs.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCidade;
	private String nomeCidade;
	@ManyToOne
	private Estado estado;

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade() {
	}

	public Cidade(Estado estado, Integer idCidade, String nomeCidade) {
		super();
		this.estado = estado;
		this.idCidade = idCidade;
		this.nomeCidade = nomeCidade;
	}

	public Cidade(Estado estado, String nomeCidade) {
		super();
		this.estado = estado;
		this.nomeCidade = nomeCidade;
	}

	@Override
	public String toString() {
		return "Cidade [idCidade=" + idCidade + ", nomeCidade=" + nomeCidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(idCidade, other.idCidade);
	}

}
