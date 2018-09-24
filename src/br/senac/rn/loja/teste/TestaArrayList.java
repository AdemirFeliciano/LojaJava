package br.senac.rn.loja.teste;


import br.senac.rn.loja.dao.DepartamentoDAO;
import br.senac.rn.loja.dao.ProdutoDAO;
import br.senac.rn.loja.dao.SexoDAO;
import br.senac.rn.loja.model.Departamento;
import br.senac.rn.loja.model.Produto;

public class TestaArrayList {

	public static void main(String[] args) {
		
//		SexoDAO dao = new SexoDAO();
//		dao.buscarTodos().forEach(sexo -> System.out.println(sexo));
//		
//		System.out.println(dao.buscarPorId(4));
//		
		Departamento dep = new DepartamentoDAO().buscarPorId(1);
//		
//		
//		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
//		System.out.println(departamentoDAO.buscarPorId(5));
		Produto produto = new ProdutoDAO().buscarPorId(2);
                produto.setQntEstoque(5);
//                produto.setPreco(10f);
		ProdutoDAO proDAO = new ProdutoDAO();
                produto.venderUnidade(produto);
                System.out.println(proDAO.buscarPorId(2));
		//proDAO.buscarTodos().forEach(pro -> System.out.println(pro));

                        
	}
}
