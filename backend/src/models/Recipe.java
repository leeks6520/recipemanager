package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Serializable {
    private  String title;
    private  List<Ingredient> ingredients = new ArrayList<>();
    private  String instructions;

    public Recipe(String title, String instructions) {
        this.title = title;
        this.instructions = instructions;
    }

    public String getTitle() { return title; }
    public List<Ingredient> getIngredients() { return ingredients; }
    public String getInstructions() { return instructions; }

    public void addIngredient(Ingredient ing) {
        ingredients.add(ing);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Recipe: " + title + "\nIngredients:\n");
        for (Ingredient ing : ingredients) sb.append("- ").append(ing).append("\n");
        sb.append("Instructions: ").append(instructions);
        return sb.toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
