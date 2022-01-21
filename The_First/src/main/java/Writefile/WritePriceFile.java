package Writefile;

import java.io.*;

public class WritePriceFile {
    public void SaveMsciAcwi(double price, String stock){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("The_First/src/DataFiles/SavedPrice"+stock+".txt", true)));
            out.println(price+"==="+java.time.LocalDate.now());
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
        System.out.println("Saved all Data !");
    }
}
