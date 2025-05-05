package models;

public class FavoriteRecipe extends Recipe {
    public FavoriteRecipe(String title, String instructions) {
        super(title, instructions);
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Favorite]";
    }
}
