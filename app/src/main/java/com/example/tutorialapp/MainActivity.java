package com.example.tutorialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.intents.IntentExplicito;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //Obtener boton de la vista
        //Metodo para buscar un elemento en la vista
        Button buttonIntent = findViewById(R.id.buttonIntent);

        //Añadimos un listener
        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crear intent explicito
                //En los parametros, primero la clase en la que estamos, segundo la clase a la que queremos ir
                Intent intentExplicito = new Intent(MainActivity.this, IntentExplicito.class);
                //Lanzar el intent
                startActivity(intentExplicito);
            }
        });

    }
}