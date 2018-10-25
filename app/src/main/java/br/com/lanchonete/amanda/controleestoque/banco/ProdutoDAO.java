package br.com.lanchonete.amanda.controleestoque.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.lanchonete.amanda.controleestoque.modelo.Produto;

public class ProdutoDAO implements IProdutoDAO {

    private SQLiteDatabase db;
    private CriarBanco criarBanco;

    public ProdutoDAO(Context context){
        criarBanco = new CriarBanco(context);

    }

    @Override
    public boolean salvarProduto(Produto produto) {

        ContentValues values = new ContentValues();
        values.put(criarBanco.PRODUTO_DESCRICAO, produto.getDescricao());
        values.put(criarBanco.PRODUTO_PRECO, produto.getPreco());
        values.put(criarBanco.PRODUTO_UNIDADE, produto.getUnidade());
        try {
            db = criarBanco.getWritableDatabase();
            db.insert(criarBanco.PRODUTO_TABELA, null, values);

        }catch (SQLException e){
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(criarBanco.PRODUTO_DESCRICAO, produto.getDescricao());
        values.put(criarBanco.PRODUTO_PRECO, produto.getPreco());
        values.put(criarBanco.PRODUTO_UNIDADE, produto.getUnidade());

        String where = criarBanco.PRODUTO_ID + " = ?";
        String[] args = {produto.getId().toString()};

        try {
            db = criarBanco.getWritableDatabase();
            db.update(criarBanco.PRODUTO_TABELA, values, where, args);
        }catch (SQLException e){
            return false;
        }

        return true;
    }

    @Override
    public boolean deletarProduto(Produto produto) {
        String where = criarBanco.PRODUTO_ID + " = ?";
        String[] args = {produto.getId().toString()};

        try {
            db = criarBanco.getWritableDatabase();
            db.delete(criarBanco.PRODUTO_TABELA, where, args);

        } catch (SQLException e){
            return  false;
        }
        return true;
    }

    @Override
    public List<Produto> listarProdutos() {
        List<Produto>produtos = new ArrayList<>();
        String sqlConsulta = "SELECT *FROM" + criarBanco.PRODUTO_TABELA+ " ;";
        db = criarBanco.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlConsulta, null);
        while(cursor.moveToNext()){
            Integer id = cursor.getInt(cursor.getColumnIndex(criarBanco.PRODUTO_ID));
            String descricao = cursor.getString(cursor.getColumnIndex(criarBanco.PRODUTO_DESCRICAO));
            Float preco = cursor.getFloat(cursor.getColumnIndex(criarBanco.PRODUTO_PRECO));
            Integer unidade = cursor.getInt(cursor.getColumnIndex(criarBanco.PRODUTO_UNIDADE));
            Produto produto = new Produto(id, descricao, preco, unidade);

            produtos.add(produto);
        }
        return produtos;
    }
}
