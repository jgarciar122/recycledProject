
package com.example.recyclerapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerapp.Adaptador;
import com.example.recyclerapp.ItemComida;
import com.example.recyclerapp.ListaComida;
import com.example.recyclerapp.ViewModelComida;
import com.example.recyclerapp.databinding.FragmentHamburguesaBinding;

import java.util.ArrayList;


public class FragmentHamburguesa extends Fragment {
    FragmentHamburguesaBinding binding;
    ViewModelComida viewModelComida;
    public FragmentHamburguesa() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHamburguesaBinding.inflate(getLayoutInflater());
        return binding.getRoot();    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModelComida = new ViewModelProvider(requireActivity()).get(ViewModelComida.class);
        ListaComida repo = new ListaComida();
        ArrayList<ItemComida> lHamburguesas = repo.get_lHamburguesas();

        Adaptador adaptador = new Adaptador(lHamburguesas, viewModelComida);
        binding.recycMarines.setLayoutManager(new GridLayoutManager(getContext(), 1));
        binding.recycMarines.setAdapter(adaptador);

        // Añadir el divisor entre items en el RecyclerView
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recycMarines.getContext(), LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider));
        binding.recycMarines.addItemDecoration(dividerItemDecoration);


    }
}
