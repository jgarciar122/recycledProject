package com.example.recyclerapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerapp.databinding.MoldeItemsBinding;

import java.util.ArrayList;

public class AdaptadorFavoritos extends RecyclerView.Adapter<AdaptadorFavoritos.FavoritoViewHolder> {

    public ArrayList<ItemComida> listaFavoritos;
    private ViewModelComida viewModelComida;

    public AdaptadorFavoritos(ArrayList<ItemComida> listaFavoritos, ViewModelComida viewModelComida) {
        this.listaFavoritos = listaFavoritos;
        this.viewModelComida = viewModelComida;
    }

    @NonNull
    @Override
    public AdaptadorFavoritos.FavoritoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritoViewHolder(MoldeItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFavoritos.FavoritoViewHolder holder, int position) {
        ItemComida itemComida = listaFavoritos.get(position);
        holder.binding.nombre.setText(itemComida.getNombre());
        holder.binding.descrip.setText(itemComida.getDescripcion());
        holder.binding.tipo.setText(itemComida.getTipo());
        holder.binding.imagen.setImageResource(itemComida.getImage());


    }

    @Override
    public int getItemCount() {
        return listaFavoritos.size();
    }

    public void setListaFavoritos(ArrayList<ItemComida> nuevosFavoritos) {
        this.listaFavoritos = nuevosFavoritos;
        notifyDataSetChanged();
    }

    public void eliminarFavorito(int position) {
        listaFavoritos.remove(position);
        notifyItemRemoved(position);
    }


    //VIEWHOLDER DE CADA ITEM

    public static class FavoritoViewHolder extends RecyclerView.ViewHolder {
        MoldeItemsBinding binding;

        public FavoritoViewHolder(@NonNull MoldeItemsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}