package com.persistence.beans;

import com.persistence.beans.Topping;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 */
@XmlRootElement(name = "Pizza")
public class Pizza {

    private String id;
    private String name;
    private String description;
    List<Topping> toppings;
    private Integer price;

    public Pizza(){

    }

    public Pizza(String id, String name, String description, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.toppings= new ArrayList<Topping>();
    }

    public void addTopping(Topping topping){
        this.price += topping.getPrice();
        toppings.add(topping);
    }

    @XmlElement
    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
