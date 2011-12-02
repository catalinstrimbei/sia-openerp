package org.open.erp.services.achizitii.exceptions;

public abstract class Validator {
    protected String message;

    public Validator(String message) {
        this.message = message;
    }

    public abstract boolean validate(Object valueToValidate) throws ExceptieValidare;
}