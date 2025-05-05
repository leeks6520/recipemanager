import java.util.List;
import models.*;
import services.RecipeService;
import utils.*;

public class Main {
    private static final String FILE_NAME = "recipes.dat";

    public static void main(String[] args) {
        RecipeService service = new RecipeService();
        List<Recipe> loaded = FileManager.loadFromFile(FILE_NAME);
        loaded.forEach(service::addRecipe);

        while (true) {
            System.out.println("\n--- Recipe Organizer ---");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Search Recipe");
            System.out.println("4. Delete Recipe");
            System.out.println("5. Generate Shopping List");
            System.out.println("6. Mark Favorite");
            System.out.println("7. View Favorites");
            System.out.println("8. Exit");

            switch (InputHelper.readLine("Choice: ")) {
                case "1" -> {
                    String title = InputHelper.readLine("Title: ");
                    String instructions = InputHelper.readLine("Instructions: ");
                    Recipe r = new Recipe(title, instructions);
                    while (true) {
                        String ing = InputHelper.readLine("Ingredient name (or 'done'): ");
                        if (ing.equalsIgnoreCase("done")) break;
                        String qty = InputHelper.readLine("Quantity: ");
                        r.addIngredient(new Ingredient(ing, qty));
                    }
                    service.addRecipe(r);
                    FileManager.saveToFile(service.getAllRecipes(), FILE_NAME);
                }
                case "2" -> service.getAllRecipes().forEach(System.out::println);
                case "3" -> {
                    String key = InputHelper.readLine("Keyword: ");
                    service.searchRecipe(key).forEach(System.out::println);
                }
                case "4" -> {
                    String del = InputHelper.readLine("Title to delete: ");
                    service.deleteRecipe(del);
                    FileManager.saveToFile(service.getAllRecipes(), FILE_NAME);
                }
                case "5" -> service.generateShoppingList().forEach(System.out::println);
                case "6" -> {
                    String fav = InputHelper.readLine("Recipe title to favorite: ");
                    service.markAsFavorite(fav);
                }
                case "7" -> service.getFavoriteRecipes().forEach(System.out::println);
                case "8" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }
}
