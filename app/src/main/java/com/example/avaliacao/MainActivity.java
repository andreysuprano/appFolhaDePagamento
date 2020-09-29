package com.example.avaliacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Button btnNovo;
    ListView lstFuncionarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNovo = findViewById(R.id.btnNovo);
        lstFuncionarios = findViewById(R.id.lstFuncionarios);

        ArrayAdapter<FolhaDePagamento> adapterFolhaPagamento = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                ListaFolhasDePagamento.getLista());

        lstFuncionarios.setAdapter(adapterFolhaPagamento);

        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });

        lstFuncionarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, FolhaDetalhesActivity.class);
                intent.putExtra("index", i);
                startActivity(intent);
            }
        });
    }
}