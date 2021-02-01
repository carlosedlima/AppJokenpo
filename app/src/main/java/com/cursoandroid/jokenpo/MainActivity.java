package com.cursoandroid.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View v){
        this.opSelecionada("pedra");
    }

    public void selecionadoPapel(View v){
        this.opSelecionada("papel");
    }

    public void selecionadoTesoura(View v){
        this.opSelecionada("tesoura");
    }

    public void opSelecionada(String opSelecionada){
        ImageView imageResultado = findViewById(R.id.imgResultado);
        TextView txtResultado = findViewById(R.id.txtResultado);
        int numero = new Random().nextInt(3);//0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp= opcoes[ numero ];
        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((opcaoApp =="tesoura" && opSelecionada == "papel") ||
                    (opcaoApp =="papel" && opSelecionada == "pedra") ||
                        (opcaoApp =="pedra" && opSelecionada == "tesoura"))
        {//App vencedor
            txtResultado.setText("O APP GANHOU!!!");
        }
        else if ((opcaoApp =="pedra" && opSelecionada == "papel") ||
                        (opcaoApp =="tesoura" && opSelecionada == "pedra") ||
                            (opcaoApp =="papel" && opSelecionada == "tesoura"))
        {//Usuario Vencedor
            txtResultado.setText("O JOGADOR GANHOU!!!");
        }
        else{//Empates
            txtResultado.setText("EMPATE!!!");
        }

    }
}