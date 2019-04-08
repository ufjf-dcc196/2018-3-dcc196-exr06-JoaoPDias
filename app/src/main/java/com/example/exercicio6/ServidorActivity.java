package com.example.exercicio6;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exercicio6.model.Servidor;

public class ServidorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servidor);
        Toast.makeText(getApplicationContext(),"ServidorActivity Criada", Toast.LENGTH_SHORT).show();

        Button botaoProfConfirmar = findViewById(R.id.button_ConfirmaServidor);
        Bundle bundleExtras = getIntent().getExtras();
        TextView mensagemProfessor = findViewById(R.id.txtExternoMensagem);
        if(bundleExtras != null){
            String nome = (String) bundleExtras.get("nome");
            mensagemProfessor.setText("Bem vindo professor " + nome + "!");
        }
        botaoProfConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNomeServidor = findViewById(R.id.edt_NomeServidor);
                EditText editSiape = findViewById(R.id.edt_SiapeServidor);
                String siape = editSiape.getText().toString();
                String nome = editNomeServidor.getText().toString();
                Servidor servidor = new Servidor(nome,siape);
                Intent intent = new Intent();
                intent.putExtra("servidor",servidor);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
