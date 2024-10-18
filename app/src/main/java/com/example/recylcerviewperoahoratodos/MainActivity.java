package com.example.recylcerviewperoahoratodos;

import android.graphics.Color;
import android.os.Bundle;
import modelos.dinosaurios;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recylcerviewperoahoratodos.dinosaurioAdapter.DinosaurioAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerDino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerDino=findViewById(R.id.recyclerView);
        List<dinosaurios> dinosauriosList=new ArrayList<>();

        // Aquí crear color y pasarselo en la lista

        Color color1 = Color.valueOf(34, 139, 34);
        Color color2 = Color.valueOf(128, 128, 0);
        Color color3 = Color.valueOf(0, 105, 148);
        Color color4 = Color.valueOf(143, 188, 143);
        Color color5 = Color.valueOf(255, 99, 71);
        Color color6 = Color.valueOf(255, 165, 0);

        dinosauriosList.add(new dinosaurios("Tyrannosaurus rex", "Carnivoro", "El Tyrannosaurus rex se ha considerado el rey de los terribles depredadores, aunque está relegado a un cuarto puesto debido a su tamaño.", color1, R.drawable.dino1));
        dinosauriosList.add(new dinosaurios("Spinosaurus aegyptiacus", "Carnivoro", "El mayor depredador terrestre que se ha coronado como rey indiscutible, desbancando al resto de los grandes carnívoros, es el lagarto de espina.", color2, R.drawable.dino2));
        dinosauriosList.add(new dinosaurios("Kronosaurus", "Carnivoro", "El nombre de este gran lagarto le vino por el dios Kronos y durante el Cretácico medio (es decir hace 110 millones de años) se encontró en los mares de la Tierra.", color3, R.drawable.dino3));
        dinosauriosList.add(new dinosaurios("Apatosaurus", "Herbívoro", "Sus principales rasgos eran su cabeza de pequeñas dimensiones, un cuello grueso, y un rostro achatado que en conjunto medía unos 55 centímetros de largo.", color4, R.drawable.dino4));
        dinosauriosList.add(new dinosaurios("Epidexipteryx", "Carnivoro", "Este dinosaurio medía concretamente veinticinco centímetros y contaba con unas largas plumas que le hacían asemejarse al pavo real.", color5, R.drawable.dino5));
        dinosauriosList.add(new dinosaurios("Ajacingenia", "Omnívero", "El Ajacingenia destacaba por ser un pequeño dinosaurio multicolor el cual destacaba por tener un aspecto muy parecido al de las aves de hoy en día.", color6, R.drawable.dino6));


        DinosaurioAdapter adapter=new DinosaurioAdapter(dinosauriosList);
        recyclerDino.setAdapter(adapter);
        recyclerDino.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerDino.setHasFixedSize(true);
    }
}