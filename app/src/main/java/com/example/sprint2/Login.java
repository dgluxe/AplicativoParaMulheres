package com.example.sprint2;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btLOGAcessar, btLOGCadastre_se;
    EditText txtLOGEmail, txtLOGSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btLOGCadastre_se = (Button) findViewById(R.id.btLOGCadastre_se);
        btLOGAcessar     = (Button) findViewById(R.id.btLOGAcessar);
        txtLOGEmail      = (EditText) findViewById(R.id.txtLOGEmail);
        txtLOGSenha      = (EditText) findViewById(R.id.txtLOGSenha);


        btLOGCadastre_se.setOnClickListener(this);
        btLOGAcessar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btLOGCadastre_se){
            // ir para a tela de Cadastre_se
            Intent telaCad = new Intent(this, Cadastre_se.class);
            startActivity(telaCad);
        }
        if (v.getId()==R.id.btLOGAcessar){
            if (VerificaDados()) {
                // ir para tela de menu
                Intent telaMenu = new Intent(this, Menu.class);
                startActivity(telaMenu);
            }
        }
    }
    public boolean VerificaDados() {
        String email = txtLOGEmail.getText().toString();
        String senha = txtLOGSenha.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(getApplicationContext(), "O campo E-mail deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        if (senha.isEmpty()){
            Toast.makeText(getApplicationContext(), "O campo Senha deve ser preenchido!",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        // consultar a senha e email
        BancoController bd = new BancoController(getBaseContext());


        Cursor dados = bd.ProcuraDadosLogin(email, senha) ;


        if(dados.moveToFirst()){
            return true;
        }else{
            Toast.makeText(getApplicationContext(), "Usuário e senha não cadastrado!", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
