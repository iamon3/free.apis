package com.persistence.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.persistence.beans.Pizza;

/**
 */
public class PizzaDao {

    private static Integer id = 1;
    private static Map<Integer, Pizza> availablePizzas = new HashMap<Integer, Pizza>();

    static
    {
        populatePizzas();
    }

    public Collection<Pizza> getCurrentPizzas(){

        Collection<Pizza> pizzas = availablePizzas.values();
        return pizzas;
    }

    public Pizza getPizza(Integer id){
        return availablePizzas.get(id);
    }

    public Pizza addPizza(Pizza pizza){
        pizza.setId(id.toString());
        availablePizzas.put(id, pizza);
        id+=1;
        return availablePizzas.get(id - 1);
    }

    private static void populatePizzas(){
        Pizza simple = new Pizza(id.toString(), "simple", "",0);
        availablePizzas.put(id,simple);
        id += 1;
        Pizza cheese = new Pizza(id.toString(), "cheese", "cheese",9);
        availablePizzas.put(id,cheese);
        id += 1;
        Pizza peperone = new Pizza(id.toString(), "peperone", "cheese + peperone",10);
        availablePizzas.put(id,peperone);
        id += 1;
        Pizza veg = new Pizza(id.toString(), "veg", "onion+cheese + peperone",11);
        availablePizzas.put(id,veg);
        id += 1;
    }
}
