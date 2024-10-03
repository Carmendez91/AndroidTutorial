package com.example.tutorialapp.intents;

import android.os.Bundle;
import android.util.Log;
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
    }
}