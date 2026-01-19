package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTxnCalculatorTest {
    List<Double> paymentAmounts = Arrays.asList(100.0, 200.0, 50.0, 300.0);

    @Test
    void testCalculateMin() {
        double result = PaymentTxnCalculator.calculateMin(paymentAmounts);

        assertEquals(50.0, result);
    }

    @Test
    void testCalculateMax() {
        double result = PaymentTxnCalculator.calculateMax(paymentAmounts);

        assertEquals(300.0, result);
    }

    @Test
    void testCalculateAvg(){
        double result = PaymentTxnCalculator.calculateAvg(paymentAmounts);

        assertEquals(162.5, result);
    }

    @Test
    void testCalculateEmptyList(){
        List<Double> paymentAmounts = Collections.emptyList();

        assertEquals(0.0, PaymentTxnCalculator.calculateMin(paymentAmounts));
        assertEquals(0.0, PaymentTxnCalculator.calculateMax(paymentAmounts));
        assertEquals(0.0, PaymentTxnCalculator.calculateAvg(paymentAmounts));
    }

    @Test
    void testCalculateNullList(){
        List<Double> paymentAmounts = null;

        assertEquals(0.0, PaymentTxnCalculator.calculateMin(paymentAmounts));
        assertEquals(0.0, PaymentTxnCalculator.calculateMax(paymentAmounts));
        assertEquals(0.0, PaymentTxnCalculator.calculateAvg(paymentAmounts));
    }
}
