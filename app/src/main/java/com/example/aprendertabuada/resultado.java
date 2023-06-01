package com.example.aprendertabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultado extends AppCompatActivity {
    TextView txtAcertoOuErro, txtRespostaCerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtAcertoOuErro = findViewById(R.id.txtAcertoOuErro);
        txtRespostaCerta = findViewById(R.id.txtRespostaCerta);

        // Recupera os valores de resultado e resposta da outra tela
        Intent it = getIntent();
        String resultado = it.getStringExtra("resultado");
        String resposta = it.getStringExtra("resposta");

        // Se a resposta for igual ao resultado, o usuário acertou
        if (resposta.equalsIgnoreCase(resultado)){
            txtAcertoOuErro.setText("Você acertou! :)");
        } else {
            txtAcertoOuErro.setText("Você errou! :(");
        }

        // Coloca a resposta certa na tela
        txtRespostaCerta.setText("A resposta certa é: " + resultado);
    }
}