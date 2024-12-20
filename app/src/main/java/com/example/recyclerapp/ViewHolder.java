package com.example.recyclerapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imagenView;
    TextView nombreView, descripView, tipoView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imagenView = itemView.findViewById(R.id.imagen);
        nombreView = itemView.findViewById(R.id.nombre);
        descripView = itemView.findViewById(R.id.descrip);
        tipoView = itemView.findViewById(R.id.tipo);
    }
}