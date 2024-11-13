
package com.example.recyclerapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewModelComida extends ViewModel {
    private final MutableLiveData<ItemComida> comidaSeleccionada = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ItemComida>> listaFavoritos = new MutableLiveData<>(new ArrayList<>());


    /*
    Uso de la lcase ViewModel para menajear el estado de los personaje mostrados
     */
    public void seleccionarComida(ItemComida itemComida) {
        comidaSeleccionada.setValue(itemComida);
    }



    public void toggleFavorito(ItemComida itemComida) {
        ArrayList<ItemComida> favoritos = listaFavoritos.getValue();
        if (favoritos != null) {
            if (favoritos.contains(itemComida)) {
                favoritos.remove(itemComida);

            } else {
                favoritos.add(itemComida);
            }
            listaFavoritos.setValue(favoritos); // Actualiza la lista
        }
    }


    public LiveData<ItemComida>getComidaSeleccionada(){
        return comidaSeleccionada;
    }

    public void limpiarSeleccion() {
        comidaSeleccionada.setValue(null); // Limpia la selección
    }

    public LiveData<ArrayList<ItemComida>> getListaFavoritos() {
        return listaFavoritos;
    }
}
