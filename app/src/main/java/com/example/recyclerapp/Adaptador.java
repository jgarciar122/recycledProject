
package com.example.recyclerapp;


import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerapp.databinding.MoldeItemsBinding;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.InfoViewHolder> {

    private List<ItemComida> listaComida;
    private ViewModelComida viewModelComida;

    public Adaptador(List<ItemComida> listaPersonajes, ViewModelComida viewModelComida) {
        this.listaComida = listaPersonajes;
        this.viewModelComida = viewModelComida;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MoldeItemsBinding binding = MoldeItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new InfoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        ItemComida itemComida = listaComida.get(position);

        holder.binding.nombre.setText(itemComida.getNombre());
        holder.binding.descrip.setText(itemComida.getDescripcion());
        holder.binding.tipo.setText(itemComida.getTipo());
        holder.binding.imagen.setImageResource(itemComida.getImage());



        if (viewModelComida.getListaFavoritos().getValue() != null &&
                viewModelComida.getListaFavoritos().getValue().contains(itemComida)) {
            holder.binding.favoriteButton.setImageResource(R.drawable.fullstar);
        } else {
            holder.binding.favoriteButton.setImageResource(R.drawable.emptystar);
        }

        holder.itemView.setOnClickListener(view -> {
            viewModelComida.seleccionarComida(itemComida);

            // Obtenemos el NavController correcto según la orientación
            NavController navController;
            if (view.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                // En modo vertical, usamos el NavController de vistaLista para navegar
                navController = ((NavHostFragment) ((AppCompatActivity) view.getContext())
                        .getSupportFragmentManager().findFragmentById(R.id.vistaLista)).getNavController();
                navController.navigate(R.id.fragment_detalle);
            } else {
                // En modo horizontal, no navegamos, solo actualizamos la vista
                navController = ((NavHostFragment) ((AppCompatActivity) view.getContext())
                        .getSupportFragmentManager().findFragmentById(R.id.vistaDetalle)).getNavController();
            }
        });



        holder.binding.favoriteButton.setOnClickListener(view -> {
            viewModelComida.toggleFavorito(itemComida); // Añadir o eliminar de favoritos

            if (viewModelComida.getListaFavoritos().getValue().contains(itemComida)) {
                Toast.makeText(view.getContext(), itemComida.getNombre() +  " "+  view.getContext().getString(R.string.addFav), Toast.LENGTH_SHORT).show();
                holder.binding.favoriteButton.setImageResource(R.drawable.fullstar);
            } else {
                Toast.makeText(view.getContext(), personaje.getNombre() +  " "+ view.getContext().getString(R.string.delFav), Toast.LENGTH_SHORT).show();
                holder.binding.favoriteButton.setImageResource(R.drawable.emptystar);
            }
        });

    }



    @Override
    public int getItemCount() {
        return listaComida.size();
    }

    // Setter para actualizar la lista de personajes si es necesario
    public void setListaComida(List<ItemComida> listaComida) {
        this.listaComida = listaComida;
        notifyDataSetChanged();
    }

    // ViewHolder
    public static class InfoViewHolder extends RecyclerView.ViewHolder {
        MoldeItemsBinding binding;

        public InfoViewHolder(@NonNull MoldeItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
