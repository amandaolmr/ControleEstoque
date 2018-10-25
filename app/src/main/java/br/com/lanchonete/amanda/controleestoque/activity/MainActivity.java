package br.com.lanchonete.amanda.controleestoque.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.lanchonete.amanda.controleestoque.R;
import br.com.lanchonete.amanda.controleestoque.banco.ProdutoDAO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProdutoDAO produtoDAO = new ProdutoDAO(this);
        //produtoDAO.salvarProduto();
    }
}
