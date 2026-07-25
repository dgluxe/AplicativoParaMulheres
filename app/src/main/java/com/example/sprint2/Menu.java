package com.example.sprint2;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;

public class Menu extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Configurar BottomNavigationView
        setupBottomNavigation(R.id.nav_casa);

        // Botão de socorro
        FrameLayout btnSocorroContainer = findViewById(R.id.btnSocorroContainer);
        btnSocorroContainer.setOnClickListener(v -> ligarParaEmergencia());
    }

    private void ligarParaEmergencia() {
        String numeroEmergencia = "tel:190";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(numeroEmergencia));

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE}, 1);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            ligarParaEmergencia();
        } else {
            Toast.makeText(this, "Permissão negada para realizar chamadas", Toast.LENGTH_SHORT).show();
        }
    }
}
