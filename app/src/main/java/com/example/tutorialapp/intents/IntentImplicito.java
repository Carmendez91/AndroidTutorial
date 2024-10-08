package com.example.tutorialapp.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentImplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_implicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Obtener texto
        TextView textComida = findViewById(R.id.textViewComida);
        TextView textBebida = findViewById(R.id.textViewBebida);

        //Recover data
        //Obtenemos el intento que creamos en el explicito. y con extras recupero los argumentos pasados
        Bundle extras = getIntent().getExtras();

        //Settear en el text el valor obtenido
        textComida.setText(extras.getString("Comida"));
        textBebida.setText(extras.getString("Bebida"));

        String textoPrueba = extras.getString("Prueba");
        Log.d("Prueba",textoPrueba);

        // URL del INTENT -> https://developer.android.com/guide/components/intents-common?hl=es-419#java
        // Abrir una URL
        // Recuperamos el objeto y añadimos un listener
        ImageButton imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent implicito
                    String url = "https://www.flaticon.es/resultados?word=chicken";
                    //Creamos un intent y le pasamos la url
                    //Actionview es informacion que se le pasa al usuario
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    //Ejecutamos la actividad
                    startActivity(intent);

            }
        });

    }
}