/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author hn530
 */
public class Toy implements Serializable   {
    public int id;
    public String name;
    public String category;
    public int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Toy(int id, String name, String category, int amount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
    }
    public Toy(String name, String category, int amount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.amount = amount;
    }
    
}
