package com.example.recyclerapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ViewModelComida extends ViewModel {

    private MutableLiveData<List<ItemComida>> pizzas = new MutableLiveData<>();
    private MutableLiveData<List<ItemComida>> hamburguesas = new MutableLiveData<>();
    private MutableLiveData<List<ItemComida>> ensaladas = new MutableLiveData<>();

    public ViewModelComida() {
        // Inicializamos las listas con los datos de ListaComida
        pizzas.setValue(ListaComida.pizzas);
        hamburguesas.setValue(ListaComida.hamburguesas);
        ensaladas.setValue(ListaComida.ensaladas);
    }

    // Métodos para obtener las listas como LiveData
    public LiveData<List<ItemComida>> getPizzas() {
        return pizzas;
    }

    public LiveData<List<ItemComida>> getHamburguesas() {
        return hamburguesas;
    }

    public LiveData<List<ItemComida>> getEnsaladas() {
        return ensaladas;
    }

    // Método para actualizar las listas si es necesario (por ejemplo, al modificar la lista)
    public void setPizzas(List<ItemComida> newPizzas) {
        pizzas.setValue(newPizzas);
    }

    public void setHamburguesas(List<ItemComida> newHamburguesas) {
        hamburguesas.setValue(newHamburguesas);
    }

    public void setEnsaladas(List<ItemComida> newEnsaladas) {
        ensaladas.setValue(newEnsaladas);
    }
}
