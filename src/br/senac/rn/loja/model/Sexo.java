package br.senac.rn.loja.model;

public class Sexo implements Comparable<Sexo>{

	private Integer id;
	private String nome;
	private String sigla;
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Override
	public boolean equals(Object obj) {
		return((Sexo) obj).id == this.id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Sexo [id=" + id + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	
	@Override
	public int compareTo(Sexo sexo) {
		int id= sexo.id;
		if(this.id < id) {
			return -1;
		}else if(this.id > id) {
			return +1;
		}
		return 0;
		
		//return this.nome.compareTo(sexo.nome);
	}
	
	
}
