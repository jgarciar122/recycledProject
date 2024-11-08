package com.example.recyclerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetalleFragment extends Fragment {

    private TextView nombreView, descripcionView;
    private ImageView imagenView;

    public DetalleFragment() {
        // Constructor vacío
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos el layout del fragmento
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener las vistas
        nombreView = view.findViewById(R.id.textViewNombreDetalle);
        descripcionView = view.findViewById(R.id.textViewDescripcionDetalle);
        imagenView = view.findViewById(R.id.imageViewDetalle);

        // Obtener los datos pasados al fragmento
        if (getArguments() != null) {
            String nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            int imageResId = getArguments().getInt("imageResId");

            // Actualizar las vistas con los datos
            nombreView.setText(nombre);
            descripcionView.setText(descripcion);
            imagenView.setImageResource(imageResId);
        }
    }

    // Método para crear una nueva instancia del fragmento con los datos
    public static DetalleFragment newInstance(String nombre, String descripcion, int imageResId) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle args = new Bundle();
        args.putString("nombre", nombre);
        args.putString("descripcion", descripcion);
        args.putInt("imageResId", imageResId);
        fragment.setArguments(args);
        return fragment;
    }
}
