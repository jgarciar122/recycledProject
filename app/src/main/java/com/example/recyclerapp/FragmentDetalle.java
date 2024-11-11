
package com.example.recyclerapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerapp.databinding.FragmentDetalleBinding;


public class FragmentDetalle extends Fragment {

    FragmentDetalleBinding binding;
    private ViewComida viewComida;

    public FragmentDetalle() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewComida = new ViewModelProvider(requireActivity()).get(com.example.recyclerapp.ViewComida.class);
        viewComida.getSelectedItem().observe(getViewLifecycleOwner(), itemComida -> {
            if (itemComida != null) {
                // Actualizar las vistas con los datos del personaje seleccionado
                binding.textViewNombreDetalle.setText(itemComida.getNombre());
                binding.textViewDescripcionDetalle.setText(itemComida.getDescripcion());
                binding.imageViewDetalle.setImageResource(itemComida.getImage());
            }
        });
    }



    public void uploadDetalle(ItemComida itemComida) {
        if (itemComida != null) {
            binding.textViewNombreDetalle.setText(itemComida.getNombre());
            binding.textViewDescripcionDetalle.setText(itemComida.getDescripcion());
            binding.imageViewDetalle.setImageResource(itemComida.getImage());

        }
    }



}
