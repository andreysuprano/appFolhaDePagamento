package com.example.avaliacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtHorasTrabalhadas;
    EditText edtValorDaHora;
    EditText edtMes;
    EditText edtAno;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtHorasTrabalhadas = findViewById(R.id.edtHorasTrabalhadas);
        edtValorDaHora = findViewById(R.id.edtValorDaHora);
        edtMes = findViewById(R.id.edtMes);
        edtAno = findViewById(R.id.edtAno);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtNome.getText().toString().isEmpty() || edtAno.getText().toString().isEmpty() ||
                        edtHorasTrabalhadas.getText().toString().isEmpty() || edtValorDaHora.getText().toString().isEmpty() ||
                        edtMes.getText().toString().isEmpty())
                {
                    Toast.makeText(CadastroActivity.this, "Por favor, preencha todos os dados", Toast.LENGTH_SHORT).show();
                }
                else {
                    String nome = edtNome.getText().toString();
                    int mes = Integer.parseInt(edtMes.getText().toString());
                    int horasTrabalhadas = Integer.parseInt(edtHorasTrabalhadas.getText().toString());
                    int ano = Integer.parseInt(edtAno.getText().toString());
                    float valorDaHora = Float.parseFloat(edtValorDaHora.getText().toString());

                    FolhaDePagamento folhaDePagamento = new FolhaDePagamento(nome, horasTrabalhadas, valorDaHora, mes, ano);

                    ListaFolhasDePagamento.addFolha(folhaDePagamento);

                    Toast.makeText(CadastroActivity.this, "Funcionario adicionado a lista", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(CadastroActivity.this, MainActivity.class));

                }

            }
        });

    }
}