package com.example.zahiduck.aniversario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnContinuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnContinuar=(Button) findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ETX = (EditText) findViewById(R.id.txtContraseña);
                String Texto = ETX.getText().toString();
                String opcion = "";


                if(Texto.equals("Te amo SDM")) {
                   // Toast.makeText(getApplicationContext(),radioButton.getText(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (v.getContext(), inicio.class);
                    startActivityForResult(intent, 0);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Contraseña Equivocada >:v" , Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
