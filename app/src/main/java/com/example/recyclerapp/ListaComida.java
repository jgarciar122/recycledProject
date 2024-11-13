package com.example.recyclerapp;

import java.util.ArrayList;
import java.util.List;

public class ListaComida {

    public static ArrayList<ItemComida> pizzas = new ArrayList<ItemComida>();
    public static ArrayList<ItemComida> hamburguesas = new ArrayList<ItemComida>();
    public static ArrayList<ItemComida> ensaladas = new ArrayList<ItemComida>();

    static {
        // Pizzas
        pizzas.add(new ItemComida("Pizza Margherita", "Pizza con tomate, mozzarella y albahaca", R.drawable.pizza_margarita, "Pizza"));
        pizzas.add(new ItemComida("Pizza Pepperoni", "Pizza con salsa de tomate, mozzarella y pepperoni", R.drawable.pizza_peperoni, "Pizza"));
        pizzas.add(new ItemComida("Pizza Cuatro Quesos", "Pizza con mozzarella, gorgonzola, parmesano y ricotta", R.drawable.pizza_cuatroquesos, "Pizza"));
        pizzas.add(new ItemComida("Pizza Hawaiana", "Pizza con tomate, mozzarella, jamón y piña", R.drawable.pizza_hawaiana, "Pizza"));
        pizzas.add(new ItemComida("Pizza Vegetariana", "Pizza con tomate, mozzarella y verduras frescas", R.drawable.pizza_vegetariana, "Pizza"));
        pizzas.add(new ItemComida("Pizza BBQ", "Pizza con salsa BBQ, pollo y cebolla morada", R.drawable.pizza_barbacoa, "Pizza"));
        pizzas.add(new ItemComida("Pizza Carbonara", "Pizza con crema, bacon, huevo y parmesano", R.drawable.pizza_carbonara, "Pizza"));
        pizzas.add(new ItemComida("Pizza con Anchoas", "Pizza con tomate, mozzarella y anchoas", R.drawable.pizza_anchoas, "Pizza"));
        pizzas.add(new ItemComida("Pizza de Pollo al Pesto", "Pizza con pollo, pesto y mozzarella", R.drawable.pizza_pollo_pesto, "Pizza"));
        pizzas.add(new ItemComida("Pizza de Champiñones", "Pizza con tomate, mozzarella y champiñones", R.drawable.pizza_champiniones, "Pizza"));

        // Hamburguesas
        hamburguesas.add(new ItemComida("Hamburguesa Clásica", "Carne de res con lechuga, tomate y cebolla", R.drawable.hamburguesa_clasica, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa BBQ", "Hamburguesa con salsa BBQ, cebolla caramelizada y queso cheddar", R.drawable.hamburguesa_bbq, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa Vegetariana", "Hamburguesa de garbanzos con lechuga y aguacate", R.drawable.hamburguesa_vegana, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa con Huevo", "Hamburguesa con carne, huevo frito y queso", R.drawable.hamburguesa_huevo, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa Picante", "Hamburguesa con jalapeños y salsa picante", R.drawable.hamburguesa_picante, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa Deluxe", "Hamburguesa con doble carne, queso y bacon", R.drawable.hamburguesa_deluxe, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa Caprese", "Hamburguesa con mozzarella, albahaca y tomate", R.drawable.hamburguesa_caprese, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa con Champiñones", "Hamburguesa con champiñones salteados y queso suizo", R.drawable.hamburguesa_champiniones, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa con Guacamole", "Hamburguesa con guacamole y jalapeños", R.drawable.hamburguesa_guacamole, "Hamburguesa"));
        hamburguesas.add(new ItemComida("Hamburguesa con Bacon", "Hamburguesa con bacon crujiente y queso cheddar", R.drawable.hamburguesa_bacon, "Hamburguesa"));

        // Ensaladas
        ensaladas.add(new ItemComida("Ensalada César", "Lechuga, pollo, crutones y aderezo César", R.drawable.ensalada_cesar, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada Mediterránea", "Tomate, pepino, aceitunas y queso feta", R.drawable.ensalada_mediterranea, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Atún", "Lechuga, atún, cebolla y aceitunas", R.drawable.ensalada_atun, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Quinoa", "Quinoa, aguacate, tomate y pepino", R.drawable.ensalada_quinoa, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Frutas", "Frutas frescas con miel y limón", R.drawable.ensalada_frutas, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Pollo", "Pollo a la parrilla, lechuga y aderezo de mostaza", R.drawable.ensalada_pollo, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Garbanzos", "Garbanzos, pimientos, cebolla y perejil", R.drawable.ensalada_garbanzos, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Espinacas", "Espinacas, fresas y nueces con vinagreta", R.drawable.ensalada_espinacas, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada Oriental", "Lechuga, zanahoria, pollo y salsa de sésamo", R.drawable.ensalada_oriental, "Ensalada"));
        ensaladas.add(new ItemComida("Ensalada de Col", "Col, zanahoria y mayonesa", R.drawable.ensalada_col, "Ensalada"));
    }

    public static ArrayList<ItemComida> get_lPizza() {
        return pizzas;
    }

    public static void set_lpizza(ArrayList<ItemComida> pizzas) {
        ListaComida.pizzas = pizzas;
    }

    public static ArrayList<ItemComida> get_lHamburguesas() {
        return hamburguesas;
    }

    public static void set_lHamburguesas(ArrayList<ItemComida> hamburguesas) {
        ListaComida.hamburguesas = hamburguesas;
    }

    public static ArrayList<ItemComida> get_lEnsalada() {
        return ensaladas;
    }

    public static void set_lEnsalada(ArrayList<ItemComida> ensaladas) {
        ListaComida.ensaladas = ensaladas;
    }

}
