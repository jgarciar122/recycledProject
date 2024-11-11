
package com.example.recyclerapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ViewComida extends ViewModel {
    private final MutableLiveData<ItemComida> selectedItem = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<ItemComida>> listFavoritos = new MutableLiveData<>(new ArrayList<>());


    public void getSelectedItem(ItemComida itemComida) {
        selectedItem.setValue(itemComida);
    }



   /* public void toggleFavorito(Item item) {
        ArrayList<Item> favoritos = listFavoritos.getValue();
        if (favoritos != null) {
            if (favoritos.contains(item)) {
                favoritos.remove(item);

            } else {
                favoritos.add(item);
            }
            listFavoritos.setValue(favoritos); // Actualiza la lista
        }
    }*/


    public LiveData<ItemComida>getSelectedItem(){
        return selectedItem;
    }

   /* public void limpiarSeleccion() {
        selectedItem.setValue(null); // Limpia la selección
    }

    public LiveData<ArrayList<Item>> getListFavoritos() {
        return listFavoritos;
    }*/
}
