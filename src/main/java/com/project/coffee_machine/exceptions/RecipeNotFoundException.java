package com.project.coffee_machine.exceptions;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException(String drinkName){
        super("Recipe not found " + drinkName);
    }
}