package com.project.coffee_machine.exceptions;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException(String name) {
        super("Recipe not found " + name);
    }
}