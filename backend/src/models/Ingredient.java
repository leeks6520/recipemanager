package models;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String name;
    private String quantity;

    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public String getQuantity() { return quantity; }

    @Override
    public String toString() {
        return name + " - " + quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
