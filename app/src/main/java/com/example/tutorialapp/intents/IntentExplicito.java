package com.example.tutorialapp.intents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentExplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_explicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Buscar boton comprar
        Button buttonComprar = findViewById(R.id.buttonComprar);

        //Recuperar texto
        EditText editTextComida = findViewById(R.id.editTextComida);
        EditText editTextBebida = findViewById(R.id.editTextBebida);


        //Añadir listener
        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Crear intent explicito
                //En los parametros, primero la clase en la que estamos, segundo la clase a la que queremos ir
                Intent intentExplicito = new Intent(IntentExplicito.this, IntentImplicito.class);
                //Pasamos datos
                intentExplicito.putExtra("Prueba","Ensalada");
                intentExplicito.putExtra("Comida", editTextComida.getText().toString());
                intentExplicito.putExtra("Bebida", editTextBebida.getText().toString());
                //Lanzar el intent
                startActivity(intentExplicito);
            }
        });
    }
}