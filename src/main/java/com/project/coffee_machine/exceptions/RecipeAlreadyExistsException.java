package com.project.coffee_machine.exceptions;

public class RecipeAlreadyExistsException extends RuntimeException{
    public RecipeAlreadyExistsException(String drinkName){
        super("Recipe not found " + drinkName);
    }
}