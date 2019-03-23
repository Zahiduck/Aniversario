package com.example.zahiduck.aniversario;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.Principal;


public class principal extends AppCompatActivity {

    private ViewPager pager;
    private int [] image = {R.drawable.i1, R.drawable.i2, R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6 };
    private Handler handler = new Handler();

    private Button BtnCuentos, BtnMusica, BtnGaleria;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BtnCuentos = (Button)findViewById(R.id.btnCuentos);
        BtnGaleria = (Button)findViewById(R.id.btnGaleria);
        BtnMusica = (Button)findViewById(R.id.btnMusica);

        BtnCuentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Cuentos.class);
                startActivityForResult(intent,0);
            }
        });

        BtnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Musica.class);
                startActivityForResult(intent,0);

            }
        });

        BtnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(v.getContext(), Galeria.class);
                startActivityForResult(intent,0);*/
                Context context = getApplicationContext();
                Toast toast =  Toast.makeText(context, "Aqui deberia haber una galeria :v. Continuara, solo en cines GGG", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setOffscreenPageLimit(1);
        pager.setAdapter(new InfiniteAdapter(this,image));


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Log.i("Pager",String.valueOf(pager.getCurrentItem() + 1));
                pager.setCurrentItem(pager.getCurrentItem() + 1);
                handler.postDelayed(this, 1500);
            }

        },1500);

    }


}
