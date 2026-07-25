package com.example.sprint2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class fotografia extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotografia);

        // Configurar o BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Setar o item selecionado no BottomNavigationView
        bottomNavigationView.setSelectedItemId(R.id.nav_filmadora);

        // Listener para navegação
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_casa) {
                startActivity(new Intent(fotografia.this, Menu.class));
                overridePendingTransition(0, 0); // Remove a animação de transição
                return true;
            } else if (itemId == R.id.nav_filmadora) {
                return true; // Já estamos na página de filmadora
            } else if (itemId == R.id.nav_microfone) {
                startActivity(new Intent(fotografia.this, GravacaoActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_config) {
                startActivity(new Intent(fotografia.this, config.class));
                overridePendingTransition(0, 0);
                return true;
            }
            return false;
        });

        // Ajustar o layout para considerar as barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fotografia), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
