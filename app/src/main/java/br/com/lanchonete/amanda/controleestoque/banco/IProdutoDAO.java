package br.com.lanchonete.amanda.controleestoque.banco;

import java.util.List;

import br.com.lanchonete.amanda.controleestoque.modelo.Produto;

public interface IProdutoDAO {

    boolean salvarProduto(Produto produto);
    boolean atualizarProduto(Produto produto);
    boolean deletarProduto(Produto produto);
    List<Produto> listarProdutos();
}
