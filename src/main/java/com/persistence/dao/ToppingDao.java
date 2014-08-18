package com.persistence.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.persistence.beans.Topping;

/**
 */
public class ToppingDao {

    private static Integer id = 1;
    // <id, Topping>
    private static Map<Integer, Topping> availableToppings = new HashMap<Integer, Topping>();

    static
    {
        populateToppings();
    }

    public Collection<Topping> getToppings(){

        return availableToppings.values();
    }

    public Topping getTopping(Integer id){
        return availableToppings.get(id);
    }

    public Topping addTopping(Topping topping){
        topping.setId(id.toString());
        availableToppings.put(id, topping);
        id +=1;
        return availableToppings.get(id-1);
    }

    private static void populateToppings(){
        Topping cheese = new Topping(id.toString(), "cheese", "1");
        availableToppings.put(id, cheese);
        id += 1;
        Topping peperones = new Topping(id.toString(), "peperones", "1");
        availableToppings.put(id, peperones);
        id += 1;
        Topping onions = new Topping(id.toString(), "onions", "1");
        availableToppings.put(id, onions);
        id += 1;
        Topping peppers = new Topping(id.toString(), "peppers", "1");
        availableToppings.put(id, peppers);
        id += 1;
        Topping sausages = new Topping(id.toString(), "sausages", "1");
        availableToppings.put(id, sausages);
        id += 1;
        Topping tomato = new Topping(id.toString(), "tomato", "1");
        availableToppings.put(id, tomato);
        id += 1;
    }
}
