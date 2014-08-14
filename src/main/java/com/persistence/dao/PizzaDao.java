package com.persistence.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.persistence.beans.Pizza;

/**
 */
public class PizzaDao {

    private Integer id = 1;
    private Map<Integer, Pizza> availablePizzas = new HashMap<Integer, Pizza>();

    {
        populatePizzas();
    }

    public Map<Integer, Pizza> getCurrentPizzas(){
        return availablePizzas;
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

    private void populatePizzas(){
        Pizza simple = new Pizza(id.toString(), "simple", "",0);
        id += 1;
        Pizza cheese = new Pizza(id.toString(), "cheese", "cheese",9);
        id += 1;
        Pizza peperone = new Pizza(id.toString(), "peperone", "cheese + peperone",10);
        id += 1;
        Pizza veg = new Pizza(id.toString(), "veg", "onion+cheese + peperone",11);
        id += 1;
    }
}
