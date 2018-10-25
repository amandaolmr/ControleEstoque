package br.com.lanchonete.amanda.controleestoque.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class CriarBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "controle.estoque";
    private static final int VERSAO = 1;

    public static  final String PRODUTO_TABELA ="produto";
    public static  final String PRODUTO_ID ="id";
    public static  final String PRODUTO_DESCRICAO ="descricao";
    public static  final String PRODUTO_PRECO="preco";
    public static  final String PRODUTO_UNIDADE ="unidade";

    public CriarBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlProduto = "CREATE TABLE "+PRODUTO_TABELA+" ( " +
                PRODUTO_ID+" INTEGRER PRIMARY KEY AUTOINCREMENT, " +
                PRODUTO_DESCRICAO+" VARCHAR(100) NOT NULL, " +
                PRODUTO_PRECO+" REAL NOT NULL, " +
                PRODUTO_UNIDADE+" INTEGER NOT NULL " +
                ") ;";

        db.execSQL(sqlProduto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        StringBuilder sqlProdutoDROP = new StringBuilder();
        sqlProdutoDROP.append("DROP TABLE IF EXITS "+ PRODUTO_TABELA+" ;");
        db.execSQL(sqlProdutoDROP.toString());// destroi a tabela
        onCreate(db); // cria denovo a tabela do banco
    }
}
