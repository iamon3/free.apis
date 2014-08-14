package com.persistence.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 */
@XmlRootElement(name = "Topping")
public class Topping {

    private String id;
    private String name;
    private String price;

    public Topping(String id, String name, String price){
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
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
