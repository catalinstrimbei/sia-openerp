package org.open.erp.services.achizitii.exceptions;



/**
 *
 * @author catalin
 */
public interface Validatable {
    boolean isValid() throws ExceptieValidare;
}
