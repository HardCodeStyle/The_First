import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WritePriceFile {
    public void test (double price){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("SavedPricesInTXTFromMSCI_ACWI_Ishare.txt", true)));
            out.println(price+"==="+java.time.LocalDate.now());
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
