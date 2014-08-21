package com.persistence.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 */
@XmlRootElement(name = "Topping")
public class Topping {

    private String id;
    private String name;
    private Integer price;

    public Topping(String id, String name, Integer price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Topping(){

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
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
