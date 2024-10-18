package com.example.recylcerviewperoahoratodos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

import modelos.dinosaurios;

public class dino6 extends AppCompatActivity {

    TextView nombre, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino1);

        nombre = findViewById(R.id.txtNombreDino);
        descripcion = findViewById(R.id.txtDescripcionDino);

        String dinoJson = getIntent().getStringExtra("dinoData");

        Gson gson = new Gson();
        dinosaurios dino = gson.fromJson(dinoJson, dinosaurios.class);

        if (dino != null) {
            nombre.setText(dino.getNombre());
            descripcion.setText(dino.getDescripcion());
        }
    }
}