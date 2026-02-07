package org.ikigaidigital;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TimeDepositCalculatorTest {

    @DisplayName("Calculates monthly interest and terminates plans after 1 year except premium")
    @Test
    public void calculateInterest_Test() {
        TimeDepositCalculator calc = new TimeDepositCalculator();
        List<TimeDeposit> plans = Arrays.asList(
                new TimeDeposit(DepositType.BASIC.getType(), 1234567.00, 45),
                new TimeDeposit(DepositType.STUDENT.getType(), 1234567.00, 45),
                new TimeDeposit(DepositType.PREMIUM.getType(), 1234567.00, 46),
                new TimeDeposit(DepositType.BASIC.getType(), 1234567.00, 367),
                new TimeDeposit(DepositType.STUDENT.getType(), 1234567.00, 367),
                new TimeDeposit(DepositType.PREMIUM.getType(), 1234567.00, 367)

        );
        calc.calculateInterest(plans);

        assertThat(plans.get(0).getBalance()).isEqualTo(1235595.81);
        assertThat(plans.get(1).getBalance()).isEqualTo(1237653.42);
        assertThat(plans.get(2).getBalance()).isEqualTo(1239711.03);
        assertThat(plans.get(3).getBalance()).isEqualTo(0.0);
        assertThat(plans.get(4).getBalance()).isEqualTo(0.0);
        assertThat(plans.get(5).getBalance()).isEqualTo(1239711.03);
    }
}
