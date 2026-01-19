package reader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTxnReaderTest {

    @Test
    void readPaymentAmountSuccess() throws IOException {
        Path tempFile = Files.createTempFile("payments", ".csv");
        Files.write(tempFile, List.of(
                "transaction_id,payment_amount,currency,created_at",
                "TXN001,100.0,THB,2024-01-01",
                "TXN002,250.5,THB,2024-01-02",
                "TXN003,50.0,THB,2024-01-03"
        ));

        List<Double> result = PaymentTxnReader.readPaymentAmount(tempFile.toString());

        assertEquals(3, result.size());
        assertEquals(100.0, result.get(0));
        assertEquals(250.5, result.get(1));
        assertEquals(50.0, result.get(2));
    }

    @Test
    void readPaymentAmount_ShouldSkipInvalidRecords() throws IOException {
        Path tempFile = Files.createTempFile("payments_invalid", ".csv");
        Files.write(tempFile, List.of(
                "transaction_id,payment_amount,currency,created_at",
                "TXN001,100.0,THB,2024-01-01",
                "TXN002,SKY,THB,2024-01-02",
                "TXN003,50.5,THB,2024-01-03",
                "TXN004"
        ));

        List<Double> result = PaymentTxnReader.readPaymentAmount(tempFile.toString());

        assertEquals(2, result.size());
        assertEquals(100.0, result.get(0));
        assertEquals(50.5, result.get(1));
    }

    @Test
    void readPaymentAmount_fileNotFound_shouldReturnEmptyList() {
        List<Double> result = PaymentTxnReader.readPaymentAmount("dinosaur.csv");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
