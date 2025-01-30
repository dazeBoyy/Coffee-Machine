package com.project.coffee_machine.exceptions;

public class NoOrdersFoundException extends RuntimeException {
    public NoOrdersFoundException() {
        super("Нет данных о заказах");
    }
}