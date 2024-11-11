package com.example.recyclerapp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recyclerapp.ItemComida;

import java.util.ArrayList;

public class ViewComida extends ViewModel {
//    private final MutableLiveData<Boolean> hayQueNavegar = new MutableLiveData<>(false);
    private final MutableLiveData<ItemComida> comidaEscogida = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ItemComida>> lFavoritos = new MutableLiveData<>(new ArrayList<>());

    /**
     * Este es el personaje que estamos viendo.
     * @param personaje es el personaje que queremos observar.
     */
    public void escogerComida(ItemComida itemComida) {
        comidaEscogida.setValue(itemComida);
       // hayQueNavegar.setValue(true);
    }

    /**
     * Con este metodo activamos a un personaje como favorito.
     * @param personaje es el personaje que vamos a activar.
     */
    public void activarFavorito(ItemComida itemComida) {
        ArrayList<ItemComida> favoritos = lFavoritos.getValue();
        if(favoritos != null) {
            if(favoritos.contains(itemComida)) {
                favoritos.remove(itemComida);
            } else {
                favoritos.add(itemComida);
            }
            lFavoritos.setValue(favoritos);
        }
    }

    public void eliminarSeleccion() {
        comidaEscogida.setValue(null);
    }

    public MutableLiveData<ItemComida> getComidaEscogida() {
        return comidaEscogida;
    }

    public MutableLiveData<ArrayList<ItemComida>> getlFavoritos() {
        return lFavoritos;
    }
}
