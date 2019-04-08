package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exercicio6.model.Aluno;

public class AlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        Toast.makeText(getApplicationContext(),"AlunoActivity Criada", Toast.LENGTH_SHORT).show();

        Button botaoAlunoConfirmar = findViewById(R.id.button_ConfirmaAluno);
        Bundle bundleExtras = getIntent().getExtras();
        botaoAlunoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNomeAluno = findViewById(R.id.edt_NomeAluno);
                EditText editMatricula = findViewById(R.id.edt_MatriculaAluno);
                String nome = editNomeAluno.getText().toString();
                String matricula = editMatricula.getText().toString();
                Aluno aluno = new Aluno(nome,matricula);
                Intent intent = new Intent();
                intent.putExtra("aluno",aluno);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
