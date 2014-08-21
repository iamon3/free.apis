package com.persistence.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.persistence.beans.Topping;
import com.persistence.dao.ToppingDao;
/**
 */
public class ToppingService {

    private ToppingDao toppingDao = new ToppingDao();

    public Collection<Topping> getToppings(){
        return getToppingDao().getToppings();
    }

    public Topping getTopping(Integer id){
        return getToppingDao().getTopping(id);
    }

    public Topping addTopping(Topping topping){
        return getToppingDao().addTopping(topping);
    }

    private ToppingDao getToppingDao(){
        return  toppingDao;
    }
}
