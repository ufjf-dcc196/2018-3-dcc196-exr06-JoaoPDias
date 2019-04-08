package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.exercicio6.model.Aluno;
import com.example.exercicio6.model.Externo;
import com.example.exercicio6.model.Servidor;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_SIAPE = 1;
    public static final int REQUEST_MATRICULA = 2;
    public static final int REQUEST_EMAIL = 3;
    public List<Aluno> alunos = new ArrayList<>();
    public List<Externo> externos = new ArrayList<>();
    public List<Servidor> servidores = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoServidor = findViewById(R.id.buttonServidor);
        Button botaoAluno = findViewById(R.id.buttonAluno);
        Button botaoExterno = findViewById(R.id.buttonExterno);
        botaoServidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServidorActivity.class);
                startActivityForResult(intent,MainActivity.REQUEST_SIAPE);
            }
        });
        botaoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlunoActivity.class);
                startActivityForResult(intent,MainActivity.REQUEST_MATRICULA);
            }
        });
        botaoExterno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ExternoActivity.class);
                startActivityForResult(intent,MainActivity.REQUEST_EMAIL);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == MainActivity.REQUEST_SIAPE){
            if(resultCode == Activity.RESULT_OK){
                if(data!=null){
                    Bundle bundle = data.getExtras();
                    Servidor servidor = (Servidor) bundle.get("servidor");
                    servidores.add(servidor);
                    TextView textMensagem = findViewById(R.id.textTotalServidores);
                    textMensagem.setText("Total de Servidores: "+servidores.size());
                }
            }
        }
        if(requestCode == MainActivity.REQUEST_MATRICULA){
            if(resultCode == Activity.RESULT_OK){
                if(data!=null){
                    Bundle bundle = data.getExtras();
                    Aluno aluno = (Aluno) bundle.get("aluno");
                    alunos.add(aluno);
                    TextView textMensagem = findViewById(R.id.textTotalAlunos);
                    textMensagem.setText("Total de Alunos: "+alunos.size());
                }
            }
        }
        if(requestCode == MainActivity.REQUEST_EMAIL){
            if(resultCode == Activity.RESULT_OK){
                if(data!=null){
                    Bundle bundle = data.getExtras();
                    Externo externo = (Externo) bundle.get("externo");
                    externos.add(externo);
                    TextView textMensagem = findViewById(R.id.textTotalExternos);
                    textMensagem.setText("Total de Externos: "+externos.size());
                }
            }
        }
    }
}
