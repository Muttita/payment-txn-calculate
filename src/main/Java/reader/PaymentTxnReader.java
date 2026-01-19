package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTxnReader {
    public static List<Double> readPaymentAmount(String filepath){
        List<Double> paymentAmounts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null){
                if (isHeader){
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                try {
                    double amount = Double.parseDouble(columns[1]);
                    paymentAmounts.add(amount);
                }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                    System.err.println("Skip invalid record: "+ line);
                }
            }
        } catch (IOException e){
            System.out.println("Error reading file: "+ e.getMessage());

        }
        return paymentAmounts;
    }
}
