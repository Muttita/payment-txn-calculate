import calculator.PaymentTxnCalculator;
import reader.PaymentTxnReader;

import java.util.List;

public class Main {

    public static void main(String[] args){
        String filePath = "data/payments.csv";

        List<Double> paymentAmounts = PaymentTxnReader.readPaymentAmount(filePath);

        if(paymentAmounts.isEmpty()){
            System.out.println("No valid payment transactions data found.");
            return;
        }

        System.out.println("Total records: "+ paymentAmounts.size());
        System.out.println("Minimum payment amount: "+ PaymentTxnCalculator.calculateMin(paymentAmounts));
        System.out.println("Maximum payment amount: "+ PaymentTxnCalculator.calculateMax(paymentAmounts));
        System.out.println("Average payment amount: "+ PaymentTxnCalculator.calculateAvg(paymentAmounts));
    }
}
