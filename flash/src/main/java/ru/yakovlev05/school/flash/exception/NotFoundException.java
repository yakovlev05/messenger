package ru.yakovlev05.school.flash.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String format, Object... args) {
        super(String.format(format, args));
    }
}
