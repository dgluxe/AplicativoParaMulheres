package com.example.sprint2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa o botão
        btSalvar = findViewById(R.id.btSalvar);

        // Define o listener para o botão
        btSalvar.setOnClickListener(this); // 'this' agora está correto porque implementamos OnClickListener
    }

    @Override
    public void onClick(View v) {
        // Verifica qual botão foi clicado (caso tenha mais de um)
        if (v.getId() == R.id.btSalvar) {
            // Ação ao clicar no botão salvar
            Toast.makeText(this, "Botão Salvar clicado!", Toast.LENGTH_SHORT).show();
        }
    }
}
