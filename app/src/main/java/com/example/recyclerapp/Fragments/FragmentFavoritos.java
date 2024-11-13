package com.example.recyclerapp.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerapp.AdaptadorFavoritos;
import com.example.recyclerapp.ItemComida;
import com.example.recyclerapp.ViewModelComida;
import com.example.recyclerapp.databinding.FragmentFavoritosBinding;

import java.util.ArrayList;


public class FragmentFavoritos extends Fragment {
    FragmentFavoritosBinding binding;
    private ViewModelComida viewModelComida;
    private AdaptadorFavoritos adaptadorFavoritos;

    public FragmentFavoritos() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoritosBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModelComida = new ViewModelProvider(requireActivity()).get(ViewModelComida.class);

        binding.recycFavoritos.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorFavoritos = new AdaptadorFavoritos(new ArrayList<>(), viewModelComida);
        binding.recycFavoritos.setAdapter(adaptadorFavoritos);


        //Divider entre cada Item
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.recycFavoritos.getContext(), LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider));
        binding.recycFavoritos.addItemDecoration(dividerItemDecoration);



        //OBSERVADOR
        viewModelComida.getListaFavoritos().observe(getViewLifecycleOwner(), favoritos -> {
            adaptadorFavoritos.setListaFavoritos(favoritos);
            adaptadorFavoritos.notifyDataSetChanged();
        });

        //ITEM TOUCH
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false; // No se necesita mover elementos
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                ItemComida personajeEliminado = adaptadorFavoritos.listaFavoritos.get(position); //Cogemos el personaje según su posición


                /*
                Se crea un AlertDialog para confirmar la eliminacion de un personaje favorito
                 */
                new AlertDialog.Builder(getContext())

                        .setTitle(getString(R.string.confirmar_eliminacion))
                        .setMessage(getString(R.string.confirmar_eliminacion2) + " " + personajeEliminado.getNombre() + " " + getString(R.string.de_favs))
                        .setPositiveButton(getString(R.string.eliminar), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adaptadorFavoritos.eliminarFavorito(position);


                            }
                        })
                        .setNegativeButton(getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adaptadorFavoritos.notifyItemChanged(position); //Actualización del adaptador para volver a la vista sin cambios
                            }
                        }).show();


            }
        }).attachToRecyclerView(binding.recycFavoritos);








    }
}