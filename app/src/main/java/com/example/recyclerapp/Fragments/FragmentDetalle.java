package com.example.recyclerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.recyclerapp.R;
import com.example.recyclerapp.databinding.FragmentDetalleBinding;

public class FragmentDetalle extends Fragment {
    private TextView nombreTextView;
    private TextView descripcionTextView;
    private TextView tipoTextView;

    FragmentDetalleBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        nombreTextView = view.findViewById(R.id.nombreViewDetalle);
        descripcionTextView = view.findViewById(R.id.descripViewDetalle);
        tipoTextView = view.findViewById(R.id.tipoViewDetalle);

        // Obtener los argumentos y mostrar los datos
        if (getArguments() != null) {
            String nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            String tipo = getArguments().getString("tipo");

            nombreTextView.setText(nombre);
            descripcionTextView.setText(descripcion);
            tipoTextView.setText(tipo);
        }

        return view;
    }
}
