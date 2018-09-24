package br.senac.rn.loja.model;

public class Departamento implements Comparable<Departamento> {
	
	private Integer id;
	private String nome;
	private Float desconto;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", desconto=" + desconto + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int compareTo(Departamento departamento) {
		return id.compareTo(departamento.id);
	}
	
	
}
