package org.ikigaidigital;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TimeDepositCalculator {
    public void calculateInterest(List<TimeDeposit> xs) {
        for (TimeDeposit td: xs) {
            double interest = 0;
           AccountDeposit depositType = AccountDepositFactory.createAccountDeposit(td);

           if(depositType.terminatePlan(td)) {
               td.setBalance(0.0);
               continue;
           }
           if(depositType.isApplicable(td)) {
                    interest =  depositType.calculateInterest(td.getBalance());
                }


            BigDecimal roundedInterest =
                    BigDecimal.valueOf(interest)
                            .setScale(2, RoundingMode.HALF_UP);
            BigDecimal maturityAmount =
                    BigDecimal.valueOf(td.getBalance()).add(roundedInterest);
            td.setBalance(maturityAmount.doubleValue());
        }
    }
}
