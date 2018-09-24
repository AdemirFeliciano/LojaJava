package br.senac.rn.loja.model;

import br.senac.rn.loja.dao.ProdutoDAO;

public class Produto implements Comparable<Produto>{

	private Integer id;
	private String nome;
	private String descricao;
	private Float preco;
	private Departamento departamento;
	private Integer qntMinima;
	private Integer qntEstoque;

    public Produto() {
        departamento = new Departamento();
    }



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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public Integer getQntMinima() {
		return qntMinima;
	}
	public void setQntMinima(Integer qntMinima) {
		this.qntMinima = qntMinima;
	}
	public Integer getQntEstoque() {
		return qntEstoque;
	}
	public void setQntEstoque(Integer qntEstoque) {
		this.qntEstoque = qntEstoque;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", departamento=" + departamento + ", qntMinima=" + qntMinima + ", qntEstoque=" + qntEstoque + "]";
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public int compareTo(Produto produto) {
		return id.compareTo(produto.id);
	}

	public void venderUnidade(Produto produto) {
            Produto pro = new ProdutoDAO().buscarPorId(produto.getId());
            if (pro.getQntEstoque() > 0) {
                pro.setQntEstoque(pro.getQntEstoque() - 1);
                ProdutoDAO dao = new ProdutoDAO();
                dao.editar(pro);
            }else{
                System.out.println("Estoque Insuficiente");
            }
    }



}
