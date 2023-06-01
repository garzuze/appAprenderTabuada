package com.example.aprendertabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtNumero1, txtNumero2, txtResposta;
    Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero1    = findViewById(R.id.txtNumero1);
        txtNumero2    = findViewById(R.id.txtNumero2);
        txtResposta   = findViewById(R.id.txtResposta);
        btnVerificar  = findViewById(R.id.btnVerificar);

        // Chamada do método que gera os números aleatórios
        gerar_numeros();

        // Ação do botão que verifica se o usuário acertou
        btnVerificar.setOnClickListener(view -> {
            // Pega os dois números mostrados na tela
            int numero1 = Integer.parseInt(String.valueOf(txtNumero1.getText()));
            int numero2 = Integer.parseInt(String.valueOf(txtNumero2.getText()));

            // Cria uma variável com o resultado da multiplicação
            // Depois passa a variável para string
            int resultadoInt = numero1 * numero2;
            String resultado = String.valueOf(resultadoInt);

            // Cria uma variável com a resposta do usuário
            String resposta = String.valueOf(txtResposta.getText());

            // Intent que leva para a próxima tela
            Intent in = new Intent(MainActivity.this, resultado.class);

            // Salva os valores de resultado e resposta para serem utilizados na próxima tela
            in.putExtra("resultado", resultado);
            in.putExtra("resposta", resposta);

            // Chama o método de gerar números, para que quando o usuário volte, sejam gerados novos números
            gerar_numeros();

            // Limpar o campo de resposta
            txtResposta.setText("");
            startActivity(in);
        });

    }

    // Método que gera os números aleatórios e os coloca na tela
    public void gerar_numeros() {
        Random rand = new Random();

        int numero1 = rand.nextInt(10);
        txtNumero1.setText(String.valueOf(numero1));

        int numero2 = rand.nextInt(10);
        txtNumero2.setText(String.valueOf(numero2));
    }

}