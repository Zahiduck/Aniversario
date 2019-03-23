package com.example.zahiduck.aniversario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cuentos extends AppCompatActivity {

    private Button boton_sopa, boton_palabras, boton_gato, boton_perrito, boton_cerdo, boton_burro, boton_agua, boton_amigos, boton_leon, boton_ogros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos);

        boton_sopa = (Button)findViewById(R.id.btn_sopa);
        boton_sopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),sopa_piedra.class);
                startActivityForResult(intent,0);
            }
        });

        boton_palabras = (Button)findViewById(R.id.btn_palabras);
        boton_palabras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),cuento_palabras.class);
                startActivityForResult(intent,0);
            }
        });

        boton_gato = (Button)findViewById(R.id.btn_gato);
        boton_gato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),cuento_gato.class);
                startActivityForResult(intent,0);
            }
        });

        boton_perrito = (Button)findViewById(R.id.btn_perrito);
        boton_perrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),cuento_perrito.class);
                startActivityForResult(intent,0);
            }
        });

        boton_cerdo = (Button)findViewById(R.id.btn_cerdo);
        boton_cerdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cuento_cerdo.class);
                startActivityForResult(intent,0);
            }
        });

        boton_burro = (Button)findViewById(R.id.btn_burro);
        boton_burro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cuento_burro.class);
                startActivityForResult(intent,0);
            }
        });

        boton_agua = (Button)findViewById(R.id.btn_agua);
        boton_agua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cuento_agua.class);
                startActivityForResult(intent,0);
            }
        });

        boton_amigos = (Button)findViewById(R.id.btn_amigos);
        boton_amigos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cuento_amigos.class);
                startActivityForResult(intent, 0);
            }
        });

        boton_leon = (Button)findViewById(R.id.btn_leon);
        boton_leon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cuento_leon.class);
                startActivityForResult(intent, 0);
            }
        });

        boton_ogros = (Button)findViewById(R.id.btn_ogro);
        boton_ogros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), cuento_ogros.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
