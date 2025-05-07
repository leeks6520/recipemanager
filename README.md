# Recipe Organizer

## Overview
Recipe Organizer is a Java-based console application that helps users manage their personal recipes. Users can add, view, update, delete, search, and favorite recipes. It also allows generating a shopping list and saving/loading recipes using file-based persistence.

## Features
1. **Add Recipe** - Create new recipes with a title, ingredients, and instructions.
2. **View Recipes** - List all recipes with full details.
3. **Search Recipes** - Search recipes by title.
4. **Delete Recipe** - Remove a recipe by name.
5. **Update Recipe** - Modify an existing recipe's details.
6. **Mark/Unmark Favorite** - Flag recipes as favorites.
7. **View Favorite Recipes** - View all recipes marked as favorite.
8. **Generate Shopping List** - Collect ingredients needed from all recipes.
9. **Save & Load Recipes** - Automatically persists recipes to a local file.

## Technologies Used
- Java (Console-based)
- Java Serialization for persistence
- File-based storage (`recipes.dat`)


## How to Run


STEPS:

mkdir -p backend/bin

find backend/src -name "*.java" > sources.txt

javac -d backend/bin @sources.txt

java -cp backend/bin Main


