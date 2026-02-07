package org.ikigaidigital;


import org.ikigaidigital.exceptions.InvalidDepositTypeException;

import java.util.Arrays;

public enum DepositType {
    BASIC("basic"),
    STUDENT("student"),
    PREMIUM("premium");

    private final String type;

    DepositType(String plan) {
        this.type = plan;
    }

    public String getType() {
        return type;
    }

    public static DepositType resolveType(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Deposit type cannot be null");
        }

       return Arrays.stream(values())
                .filter(type -> type.type.equalsIgnoreCase(value))
                .findFirst().orElseThrow(()-> new InvalidDepositTypeException(value + " is not a valid deposit type"));

    }
}
