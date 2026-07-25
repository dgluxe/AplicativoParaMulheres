package com.example.sprint2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GravacaoActivity extends BaseActivity {

    private ImageButton btGravar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravacao);

        // Configurar o BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_microfone);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_casa) {
                startActivity(new Intent(GravacaoActivity.this, Menu.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_filmadora) {
                startActivity(new Intent(GravacaoActivity.this, fotografia.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_microfone) {
                return true; // Já estamos nesta página
            } else if (itemId == R.id.nav_config) {
                startActivity(new Intent(GravacaoActivity.this, config.class));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });

        // Configuração do botão de gravação
        btGravar = findViewById(R.id.btPlay1);
        btGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarGravacao();
            }
        });
    }

    private void iniciarGravacao() {
        Toast.makeText(this, "Gravação iniciada...", Toast.LENGTH_SHORT).show();

        new Thread(() -> {
            try {
                // Simula a gravação de áudio
                Thread.sleep(10000);
                runOnUiThread(() -> {
                    Toast.makeText(GravacaoActivity.this, "Gravação Completa", Toast.LENGTH_SHORT).show();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
                runOnUiThread(() -> {
                    Toast.makeText(GravacaoActivity.this, "Erro na gravação", Toast.LENGTH_SHORT).show();
                });
            }
        }).start();
    }
}
