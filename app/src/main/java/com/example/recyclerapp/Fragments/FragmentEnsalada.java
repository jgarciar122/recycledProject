package com.example.recyclerapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerapp.Adaptador;
import com.example.recyclerapp.ListaComida;
import com.example.recyclerapp.databinding.FragmentEnsaladaBinding;

public class FragmentEnsalada extends Fragment {

    private FragmentEnsaladaBinding binding;
    private Adaptador adaptador;

    public FragmentEnsalada() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentEnsaladaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configuración del RecyclerView
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crear el adaptador con la lista de ensaladas
        adaptador = new Adaptador(getContext(), ListaComida.ensaladas);
        binding.recyclerView.setAdapter(adaptador);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
