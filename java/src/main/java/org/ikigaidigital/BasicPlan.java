package org.ikigaidigital;


import org.ikigaidigital.config.TimeDepositConfig;
import org.ikigaidigital.util.CalculationUtil;

public class BasicPlan implements AccountDeposit  {

    private  static final double RATE = TimeDepositConfig.getRate(DepositType.BASIC.getType());
    private  static final int TERM = TimeDepositConfig.getTerm();
    private static final int TERMINATION_DAYS = TimeDepositConfig.getTerminationDays(DepositType.BASIC.getType());

    @Override
    public boolean terminatePlan(TimeDeposit td) {
        return td.getDays()>TERMINATION_DAYS;
    }

    @Override
    public double calculateInterest(double balance) {
        return CalculationUtil.calculateInterest(balance, RATE, TERM);
    }
}
