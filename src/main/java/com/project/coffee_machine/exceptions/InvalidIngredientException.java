package com.project.coffee_machine.exceptions;

public class InvalidIngredientException extends RuntimeException {
    public InvalidIngredientException(String ingredientName) {
        super("Ингредиент '" + ingredientName + "' не существует");
    }
}