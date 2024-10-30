
package com.example.recyclerapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<View_holder> {
    Context context;
    List<Item> items;

    public Adaptador(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new View_holder(LayoutInflater.from(context).inflate(R.layout.view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {
        holder.nombreView.setText(items.get(position).getNombre());
        holder.descripView.setText(items.get(position).getDescripcion());
        holder.imagenView.setImageResource(items.get(position).getImage());
        holder.tipoView.setText(items.get(position).getTipo());

        // Cambiar color de fondo según el tipo de comida, creando los colores en archivo values/colors.xml
        int color;
        switch (items.get(position).getTipo()) {
            case "Pizza":
                color = context.getResources().getColor(R.color.red);
                break;
            case "Hamburguesa":
                color = context.getResources().getColor(R.color.brown);
                break;
            case "Ensalada":
                color = context.getResources().getColor(R.color.green);
                break;
            default:
                color = context.getResources().getColor(R.color.black);
                break;
        }

        // Cambiar color del fondo redondeado
        Drawable background = holder.tipoView.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(color);
        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }
}
