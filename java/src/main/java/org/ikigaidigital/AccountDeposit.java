package org.ikigaidigital;


import org.ikigaidigital.config.TimeDepositConfig;

public  interface  AccountDeposit  {

    default boolean isApplicable(TimeDeposit td) {
        return td.getDays()> TimeDepositConfig.getDefaultDays();
    }

    default boolean terminatePlan(TimeDeposit td) {
       return false;
    }

    double calculateInterest(double balance);
}
