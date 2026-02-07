package org.ikigaidigital.config;


import java.util.ResourceBundle;

public class TimeDepositConfig {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");

    public static double getRate(String plan) {
        return Double.parseDouble(BUNDLE.getString("deposit." + plan.toLowerCase() + ".rate"));
    }

    public static int getMinDays(String plan) {
        return Integer.parseInt(BUNDLE.getString("deposit." + plan.toLowerCase() + ".minDays"));
    }

    public static int getMaxDays(String plan) {
        return Integer.parseInt(BUNDLE.getString("deposit." + plan.toLowerCase() + ".maxDays"));
    }

    public static int getTerm() {
        return Integer.parseInt(BUNDLE.getString("deposit.default.term"));
    }

    public static int getDefaultDays() {
        return Integer.parseInt(BUNDLE.getString("deposit.default.days"));
    }

    public static int getTerminationDays(String plan) {
        return Integer.parseInt(BUNDLE.getString("deposit." + plan.toLowerCase() + ".terminateDays"));
    }


}
