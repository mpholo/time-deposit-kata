package org.ikigaidigital;


import org.ikigaidigital.config.TimeDepositConfig;
import org.ikigaidigital.util.CalculationUtil;

public class PremiumPlan implements AccountDeposit {

    private  static final double RATE = TimeDepositConfig.getRate(DepositType.PREMIUM.getType());
    private  static final int TERM = TimeDepositConfig.getTerm();
    private static final int MIN_DAYS = TimeDepositConfig.getMinDays(DepositType.PREMIUM.getType());

    @Override
    public boolean isApplicable(TimeDeposit td) {
        return td.getDays()>MIN_DAYS;
    }

    @Override
    public double calculateInterest(double balance) {
      return   CalculationUtil.calculateInterest(balance, RATE, TERM);
    }
}
