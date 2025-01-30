package com.project.coffee_machine.exceptions;

import jakarta.validation.constraints.NotBlank;

public class IngredientAlreadyExistsException extends RuntimeException {
    public IngredientAlreadyExistsException(String name) {
        super("Recipe not found " + name);
    }
}
