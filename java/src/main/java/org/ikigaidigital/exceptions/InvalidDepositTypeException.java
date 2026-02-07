package org.ikigaidigital.exceptions;


public class InvalidDepositTypeException extends RuntimeException {
    public InvalidDepositTypeException(String value) {
        super(value + " is not a valid deposit type");
    }
}
