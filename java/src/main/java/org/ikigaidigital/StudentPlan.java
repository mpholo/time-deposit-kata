package org.ikigaidigital;


import org.ikigaidigital.config.TimeDepositConfig;
import org.ikigaidigital.util.CalculationUtil;

public class StudentPlan  implements AccountDeposit  {

    private  static final double RATE = TimeDepositConfig.getRate(DepositType.STUDENT.getType());
    private  static final int TERM = TimeDepositConfig.getTerm();
    private static final int TERMINATION_DAYS = TimeDepositConfig.getTerminationDays(DepositType.BASIC.getType());

    @Override
    public boolean terminatePlan(TimeDeposit td) {
        return td.getDays()>TERMINATION_DAYS;
    }

    @Override
    public boolean isApplicable(TimeDeposit td) {
        final String type = DepositType.STUDENT.getType();
        int min = TimeDepositConfig.getMinDays(type);
        int max = TimeDepositConfig.getMaxDays(type);
        return td.getDays()>min && td.getDays() <max;
    }

    @Override
    public double calculateInterest(double balance) {
         return CalculationUtil.calculateInterest(balance, RATE, TERM);

    }
}
