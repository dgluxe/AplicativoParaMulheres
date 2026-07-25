package com.example.sprint2;

import android.os.Bundle;

public class config extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        // Configurar BottomNavigationView
        setupBottomNavigation(R.id.nav_config);
    }
}
