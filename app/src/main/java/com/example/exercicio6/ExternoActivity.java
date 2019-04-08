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

import com.example.exercicio6.model.Externo;

public class ExternoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);
        Toast.makeText(getApplicationContext(),"ExternoActivity Criada", Toast.LENGTH_SHORT).show();

        Button botaoExternoConfirmar = findViewById(R.id.button_ConfirmaExterno);
        Bundle bundleExtras = getIntent().getExtras();
        botaoExternoConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editNome = findViewById(R.id.edt_NomeExterno);
                String nome = editNome.getText().toString();
                EditText editEmail = findViewById(R.id.edt_EmailExterno);
                String email = editEmail.getText().toString();
                Externo externo = new Externo(nome,email);
                Intent intent = new Intent();
                intent.putExtra("externo",externo);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
