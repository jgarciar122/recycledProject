package com.example.recyclerapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        List<Item> items = new ArrayList<>();
        // Pizzas
        items.add(new Item("Pizza Margherita", "Pizza con tomate, mozzarella y albahaca", R.drawable.pizza_margarita, "Pizza"));
        items.add(new Item("Pizza Pepperoni", "Pizza con salsa de tomate, mozzarella y pepperoni", R.drawable.pizza_peperoni, "Pizza"));
        items.add(new Item("Pizza Cuatro Quesos", "Pizza con mozzarella, gorgonzola, parmesano y ricotta", R.drawable.pizza_cuatroquesos, "Pizza"));
        items.add(new Item("Pizza Hawaiana", "Pizza con tomate, mozzarella, jamón y piña", R.drawable.pizza_hawaiana, "Pizza"));
        items.add(new Item("Pizza Vegetariana", "Pizza con tomate, mozzarella y verduras frescas", R.drawable.pizza_vegetariana, "Pizza"));
        items.add(new Item("Pizza BBQ", "Pizza con salsa BBQ, pollo y cebolla morada", R.drawable.pizza_barbacoa, "Pizza"));
        items.add(new Item("Pizza Carbonara", "Pizza con crema, bacon, huevo y parmesano", R.drawable.pizza_carbonara, "Pizza"));
        items.add(new Item("Pizza con Anchoas", "Pizza con tomate, mozzarella y anchoas", R.drawable.pizza_anchoas, "Pizza"));
        items.add(new Item("Pizza de Pollo al Pesto", "Pizza con pollo, pesto y mozzarella", R.drawable.pizza_pollo_pesto, "Pizza"));
        items.add(new Item("Pizza de Champiñones", "Pizza con tomate, mozzarella y champiñones", R.drawable.pizza_champiniones, "Pizza"));

        // Hamburguesas
        items.add(new Item("Hamburguesa Clásica", "Carne de res con lechuga, tomate y cebolla", R.drawable.hamburguesa_clasica, "Hamburguesa"));
        items.add(new Item("Hamburguesa BBQ", "Hamburguesa con salsa BBQ, cebolla caramelizada y queso cheddar", R.drawable.hamburguesa_bbq, "Hamburguesa"));
        items.add(new Item("Hamburguesa Vegetariana", "Hamburguesa de garbanzos con lechuga y aguacate", R.drawable.hamburguesa_vegana, "Hamburguesa"));
        items.add(new Item("Hamburguesa con Huevo", "Hamburguesa con carne, huevo frito y queso", R.drawable.hamburguesa_huevo, "Hamburguesa"));
        items.add(new Item("Hamburguesa Picante", "Hamburguesa con jalapeños y salsa picante", R.drawable.hamburguesa_picante, "Hamburguesa"));
        items.add(new Item("Hamburguesa Deluxe", "Hamburguesa con doble carne, queso y bacon", R.drawable.hamburguesa_deluxe, "Hamburguesa"));
        items.add(new Item("Hamburguesa Caprese", "Hamburguesa con mozzarella, albahaca y tomate", R.drawable.hamburguesa_caprese, "Hamburguesa"));
        items.add(new Item("Hamburguesa con Champiñones", "Hamburguesa con champiñones salteados y queso suizo", R.drawable.hamburguesa_champiniones, "Hamburguesa"));
        items.add(new Item("Hamburguesa con Guacamole", "Hamburguesa con guacamole y jalapeños", R.drawable.hamburguesa_guacamole, "Hamburguesa"));
        items.add(new Item("Hamburguesa con Bacon", "Hamburguesa con bacon crujiente y queso cheddar", R.drawable.hamburguesa_bacon, "Hamburguesa"));

        // Ensaladas
        items.add(new Item("Ensalada César", "Lechuga, pollo, crutones y aderezo César", R.drawable.ensalada_cesar, "Ensalada"));
        items.add(new Item("Ensalada Mediterránea", "Tomate, pepino, aceitunas y queso feta", R.drawable.ensalada_mediterranea, "Ensalada"));
        items.add(new Item("Ensalada de Atún", "Lechuga, atún, cebolla y aceitunas", R.drawable.ensalada_atun, "Ensalada"));
        items.add(new Item("Ensalada de Quinoa", "Quinoa, aguacate, tomate y pepino", R.drawable.ensalada_quinoa, "Ensalada"));
        items.add(new Item("Ensalada de Frutas", "Frutas frescas con miel y limón", R.drawable.ensalada_frutas, "Ensalada"));
        items.add(new Item("Ensalada de Pollo", "Pollo a la parrilla, lechuga y aderezo de mostaza", R.drawable.ensalada_pollo, "Ensalada"));
        items.add(new Item("Ensalada de Garbanzos", "Garbanzos, pimientos, cebolla y perejil", R.drawable.ensalada_garbanzos, "Ensalada"));
        items.add(new Item("Ensalada de Espinacas", "Espinacas, fresas y nueces con vinagreta", R.drawable.ensalada_espinacas, "Ensalada"));
        items.add(new Item("Ensalada Oriental", "Lechuga, zanahoria, pollo y salsa de sésamo", R.drawable.ensalada_oriental, "Ensalada"));
        items.add(new Item("Ensalada de Col", "Col, zanahoria y mayonesa", R.drawable.ensalada_col, "Ensalada"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adaptador(this, items));
    }
}
