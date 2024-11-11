package com.example.recyclerapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private List<ItemComida> itemComidas;
    private OnItemClickListener listener;

    // Constructor
    public Adaptador(Context context, List<ItemComida> itemComidas) {
        this.context = context;
        this.itemComidas = itemComidas;
    }

    // Interfaz para manejar los clics en los ítems
    public interface OnItemClickListener {
        void onItemClick(ItemComida itemComida); // Cambié Comida a Item para que coincida con tu lista de items
    }

    // Método para establecer el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.molde_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemComida currentItemComida = itemComidas.get(position);

        // Configura las vistas con los datos del ítem
        holder.nombreView.setText(currentItemComida.getNombre());
        holder.descripView.setText(currentItemComida.getDescripcion());
        holder.imagenView.setImageResource(currentItemComida.getImage());
        holder.tipoView.setText(currentItemComida.getTipo());

        // Cambiar color de fondo según el tipo de comida
        int color;
        switch (currentItemComida.getTipo()) {
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

        // Configura el clic en el elemento
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(currentItemComida);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemComidas.size();
    }
}
