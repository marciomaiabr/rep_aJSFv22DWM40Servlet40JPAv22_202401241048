package pkgs.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPessoa;
	private String nomePessoa;

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Pessoa() {
	}

	public Pessoa(Integer idPessoa, String nomePessoa) {
		super();
		this.idPessoa = idPessoa;
		this.nomePessoa = nomePessoa;
	}

	public Pessoa(String nomePessoa) {
		super();
		this.nomePessoa = nomePessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nomePessoa=" + nomePessoa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idPessoa, other.idPessoa);
	}

}
