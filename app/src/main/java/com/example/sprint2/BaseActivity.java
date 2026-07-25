package com.example.sprint2;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// Importe as classes necessárias
import com.example.sprint2.GravacaoActivity;
import com.example.sprint2.MainActivity;
import com.example.sprint2.fotografia;
import com.example.sprint2.config;

/**
 * BaseActivity é uma classe base para Activities que compartilham a lógica de navegação.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Configura o BottomNavigationView para navegar entre as telas do aplicativo.
     *
     * @param selectedItemId O ID do item que deve estar selecionado na navegação.
     */
    protected void setupBottomNavigation(int selectedItemId) {
        // Obtém o BottomNavigationView do layout atual
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(selectedItemId);

        // Configura o listener para detectar cliques nos itens do menu
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            Class<?> targetActivity = null;

            // Define para qual Activity navegar com base no item clicado
            if (itemId == R.id.nav_casa && !(this instanceof Menu)) {
                targetActivity = Menu.class;
            } else if (itemId == R.id.nav_filmadora && !(this instanceof fotografia)) {
                targetActivity = fotografia.class;
            } else if (itemId == R.id.nav_microfone && !(this instanceof GravacaoActivity)) {
                // Aqui pode colocar lógica específica para evitar erros
            targetActivity = GravacaoActivity.class;
            } else if (itemId == R.id.nav_config && !(this instanceof config)) {
                targetActivity = config.class;
            }

            // Se a Activity alvo for definida, inicia a navegação
            if (targetActivity != null) {
                Intent intent = new Intent(this, targetActivity);
                startActivity(intent);

                // Animação suave na transição
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                // Finaliza a Activity atual para evitar sobreposição
                finish();
            }

            return true;
        });
    }
}
