package org.ikigaidigital;


public class AccountDepositFactory {

    public static AccountDeposit  createAccountDeposit(TimeDeposit timeDeposit) {
       DepositType type = DepositType.resolveType(timeDeposit.getPlanType());
        return switch (type) {
            case  PREMIUM -> new PremiumPlan();
            case BASIC -> new BasicPlan();
            case STUDENT -> new StudentPlan();
        };
    }
}
