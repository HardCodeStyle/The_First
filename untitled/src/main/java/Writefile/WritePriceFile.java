package Writefile;

import java.io.*;
import java.util.Date;

public class WritePriceFile {
    public void SaveMsciAcwi(double price, String stock){
        PrintWriter out = null;
        Date date = new Date();
        String dateString = String.valueOf(date.getTime());
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("untitled/src/DataFiles/SavedPrice"+stock+".txt", true)));
            out.println(price+"==="+java.time.LocalDate.now()+"==="+dateString);
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
