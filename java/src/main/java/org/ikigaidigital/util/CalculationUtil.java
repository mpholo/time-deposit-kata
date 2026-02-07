package org.ikigaidigital.util;


public final class CalculationUtil {

    public static double calculateInterest(double balance, double rate, int term) {
        return balance * rate / term;

    }
}
