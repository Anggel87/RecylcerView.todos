package com.example.recylcerviewperoahoratodos.dinosaurioAdapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import modelos.dinosaurios;
import com.example.recylcerviewperoahoratodos.R;
import com.example.recylcerviewperoahoratodos.dino1;
import com.example.recylcerviewperoahoratodos.dino2;
import com.example.recylcerviewperoahoratodos.dino3;
import com.example.recylcerviewperoahoratodos.dino4;
import com.example.recylcerviewperoahoratodos.dino5;
import com.example.recylcerviewperoahoratodos.dino6;
import com.google.gson.Gson;

import java.util.List;

public class DinosaurioAdapter extends RecyclerView.Adapter<DinosaurioAdapter.DinosaurioViewHolder> {

    private List<dinosaurios> listaDinosaurios;

    public DinosaurioAdapter(List<dinosaurios> listaDinosaurios) {
        this.listaDinosaurios = listaDinosaurios;
    }

    @NonNull
    @Override
    public DinosaurioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dino, parent, false);
        return new DinosaurioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DinosaurioAdapter.DinosaurioViewHolder holder, int position) {

        holder.setData(listaDinosaurios.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDinosaurios.size();
    }

    public static class DinosaurioViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, tipo, descripcion;
        ImageView imagen;
        dinosaurios dino;
        ConstraintLayout itemViewDino;

        public DinosaurioViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtNombre);
            tipo = itemView.findViewById(R.id.txtTipo);
            descripcion = itemView.findViewById(R.id.txtDescripcion);
            imagen = itemView.findViewById(R.id.img);
            itemViewDino = itemView.findViewById(R.id.itemViewDino);
        }

        public void setData(dinosaurios dinosaurios) {
            dino = dinosaurios;
            nombre.setText(dino.getNombre());
            tipo.setText(dino.getTipo());
            descripcion.setText(dino.getDescripcion());
            imagen.setImageResource(dino.getImagen());
            itemViewDino.setBackgroundColor(dino.getColor().toArgb());

            // Asigna un OnClickListener a la imagen

            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = null;

                    Gson gson = new Gson();
                    String dinoJson = gson.toJson(dino);


                    switch (getAdapterPosition()) {
                        case 0:
                            intent = new Intent(v.getContext(), dino1.class);
                            break;
                        case 1:
                            intent = new Intent(v.getContext(), dino2.class);
                            break;
                        case 2:
                            intent = new Intent(v.getContext(), dino3.class);
                            break;
                        case 3:
                            intent = new Intent(v.getContext(), dino4.class);
                            break;
                        case 4:
                            intent = new Intent(v.getContext(), dino5.class);
                            break;
                        case 5:
                            intent = new Intent(v.getContext(), dino6.class);
                            break;
                        default:
                            intent = new Intent(v.getContext(), dino1.class);
                            break;
                    }

                    if (intent != null) {
                        intent.putExtra("dinoData", dinoJson);
                        v.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}