package calculator;

import java.util.List;

public class PaymentTxnCalculator {

    public static boolean isValid(List<Double> paymentAmounts){
        return paymentAmounts == null || paymentAmounts.isEmpty();
    }
    public static double calculateMin(List<Double> paymentAmounts) {
        if (isValid(paymentAmounts)) {
            return 0.0;
        }

        double min = paymentAmounts.get(0);
        for (double amount : paymentAmounts) {
            if (amount < min) {
                min = amount;
            }
        }
        return min;
    }

    public static double calculateMax(List<Double> paymentAmounts){
        if (isValid(paymentAmounts)){
            return 0.0;
        }

        double max = paymentAmounts.get(0);
        for (double amount : paymentAmounts){
            if(amount > max){
                max = amount;
            }
        }
        return max;
    }

    public static double calculateAvg(List<Double> paymentAmounts){
        if (isValid(paymentAmounts)){
            return 0.0;
        }

        double sum = 0.0;
        for (double amount : paymentAmounts){
            sum += amount;
        }

        return sum / paymentAmounts.size();
    }


}
