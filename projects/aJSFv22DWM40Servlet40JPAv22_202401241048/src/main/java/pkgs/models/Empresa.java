package pkgs.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String razaoSocial;
	private String nomeFantasia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Empresa() {
	}

	public Empresa(Integer id, String razaoSocial, String nomeFantasia) {
		super();
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	public Empresa(String razaoSocial, String nomeFantasia) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

}
