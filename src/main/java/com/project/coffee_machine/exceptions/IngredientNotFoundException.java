package com.project.coffee_machine.exceptions;

public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(String name) {
        super("Recipe not found " + name);
    }
}