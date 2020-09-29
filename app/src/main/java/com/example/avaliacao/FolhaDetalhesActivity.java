package com.example.avaliacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FolhaDetalhesActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtHorasTrabalhadas;
    TextView txtValorHora;
    TextView txtMes;
    TextView txtAno;
    TextView txtIR;
    TextView txtINSS;
    TextView txtFGTS;
    TextView txtSalarioBruto;
    TextView txtSalarioLiqiodo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folha_detalhes);

        txtNome             = findViewById(R.id.txtNome);
        txtHorasTrabalhadas = findViewById(R.id.txtHorasTrabalhadas);
        txtValorHora        = findViewById(R.id.txtValorHora);
        txtMes              = findViewById(R.id.txtMes);
        txtAno              = findViewById(R.id.txtAno);
        txtIR               = findViewById(R.id.txtIR);
        txtINSS             = findViewById(R.id.txtINSS);
        txtFGTS             = findViewById(R.id.txtFGTS);
        txtSalarioLiqiodo   = findViewById(R.id.txtSalarioLiqiodo);
        txtSalarioBruto     = findViewById(R.id.txtSalarioBruto);

        Intent detalhesIntent = getIntent();
        int index = detalhesIntent.getIntExtra("index", -1);

        if(index == -1){
            Toast.makeText(this, "Não foi possivel carregar os dados do funcionario", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(FolhaDetalhesActivity.this, MainActivity.class));
        }else{
            FolhaDePagamento folhaDePagamento = ListaFolhasDePagamento.getFolha(index);

            txtNome.setText(folhaDePagamento.getNome());
            txtHorasTrabalhadas.setText(String.valueOf(folhaDePagamento.getNumeroDeHorasTrabalhadas()));
            txtValorHora.setText(String.valueOf(folhaDePagamento.getValorDaHora()));
            txtMes.setText(String.valueOf(folhaDePagamento.getMes()));
            txtAno.setText(String.valueOf(folhaDePagamento.getAno()));
            txtSalarioBruto.setText(String.valueOf(folhaDePagamento.getSalBruto()));
            txtIR.setText(String.valueOf(folhaDePagamento.getIr()));
            txtINSS.setText(String.valueOf(folhaDePagamento.getInss()));
            txtFGTS.setText(String.valueOf(folhaDePagamento.getFgts()));
            txtSalarioLiqiodo.setText(String.valueOf(folhaDePagamento.getSalLiq()));
        }

    }
}