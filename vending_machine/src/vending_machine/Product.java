/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine;

/**
 *
 * @author jose
 */
public class Product {
    
    private String name;
    private double preparingTime;
    
    public Product() {}
    
    public Product(String name, double preparingTime) {
        this.name = name;
        this.preparingTime = preparingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreparingTime() {
        return preparingTime;
    }

    public void setPreparingTime(double preparingTime) {
        this.preparingTime = preparingTime;
    }
    
}
