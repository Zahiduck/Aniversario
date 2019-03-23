package com.example.zahiduck.aniversario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class inicio extends AppCompatActivity {

    private Button btnContinuar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnContinuar2 = (Button) findViewById(R.id.btnContinuar2);
        btnContinuar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),principal.class);
                startActivityForResult(intent,0);
            }
        });

    }
}
