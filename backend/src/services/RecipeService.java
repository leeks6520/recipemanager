package services;

import models.*;

import java.util.*;

public class RecipeService {
    private final List<Recipe> recipes = new ArrayList<>();
    private final List<FavoriteRecipe> favoriteRecipes = new ArrayList<>();

    public void addRecipe(Recipe r) { recipes.add(r); }

    public List<Recipe> getAllRecipes() { return recipes; }

    public List<FavoriteRecipe> getFavoriteRecipes() { return favoriteRecipes; }

    public Recipe findRecipeByTitle(String title) {
        return recipes.stream().filter(r -> r.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }

    public void deleteRecipe(String title) {
        recipes.removeIf(r -> r.getTitle().equalsIgnoreCase(title));
    }

    public void markAsFavorite(String title) {
        Recipe r = findRecipeByTitle(title);
        if (r != null) {
            FavoriteRecipe fav = new FavoriteRecipe(r.getTitle(), r.getInstructions());
            r.getIngredients().forEach(fav::addIngredient);
            favoriteRecipes.add(fav);
        }
    }

    public List<String> generateShoppingList() {
        List<String> list = new ArrayList<>();
        for (Recipe r : recipes) {
            for (Ingredient ing : r.getIngredients()) {
                list.add(ing.toString());
            }
        }
        return list;
    }

    public List<Recipe> searchRecipe(String keyword) {
        List<Recipe> results = new ArrayList<>();
        for (Recipe r : recipes) {
            if (r.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(r);
            }
        }
        return results;
    }
}
