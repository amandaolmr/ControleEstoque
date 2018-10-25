package br.com.lanchonete.amanda.controleestoque.modelo;

import java.io.Serializable;

public class Produto implements Serializable {

    private Integer id;
    private String descricao;
    private Float preco;
    private Integer unidade;


    public Produto(Integer id, String descricao, Float preço, Integer unidade) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preço;
        this.unidade = unidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preço) {
        this.preco = preço;
    }

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    @Override
    public boolean equals(Object o) { //usando quadno trabalha com coletions do java
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        if (id != null ? !id.equals(produto.id) : produto.id != null) return false;
        if (descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null)
            return false;
        if (preco != null ? !preco.equals(produto.preco) : produto.preco != null) return false;
        return unidade != null ? unidade.equals(produto.unidade) : produto.unidade == null;
    }

    @Override
    public int hashCode() { // gera o codigo hash tipo  um id do objeto
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (preco != null ? preco.hashCode() : 0);
        result = 31 * result + (unidade != null ? unidade.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", preço=" + preco +
                ", unidade=" + unidade +
                '}';
    }
}
