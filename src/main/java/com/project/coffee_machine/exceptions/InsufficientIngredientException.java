package com.project.coffee_machine.exceptions;

public class InsufficientIngredientException extends RuntimeException {
    public InsufficientIngredientException(String name) {
        super("Recipe not found " + name);
    }
}
