package com.persistence.service;

import java.util.List;
import java.util.Map;

import com.persistence.beans.Pizza;
import com.persistence.dao.PizzaDao;
/**
 */
public class PizzaService {

    private PizzaDao pizzaDao = new PizzaDao();

    public Map<Integer, Pizza> getCurrentPizzas(){
        return getPizzaDao().getCurrentPizzas();
    }

    public Pizza getPizza(Integer id){
        return getPizzaDao().getPizza(id);
    }

    private PizzaDao getPizzaDao() {
        return pizzaDao;
    }
}
