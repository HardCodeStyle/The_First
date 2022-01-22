package ReadDataFile;

import DataClasses.Stocks.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadDataFiles {

    public void readStocksFromFile(Data data) {
        List<String> stocks=new ArrayList<>() ;
        try (BufferedReader br = new BufferedReader(new FileReader("untitled/src/DataFiles/Stocks.txt"))) {
            for (String line; (line = br.readLine()) != null; ) {
                stocks.add(line);
            }
            // line is not visible here.
        } catch (IOException e) {
            e.printStackTrace();
        }
        data.setStocks(stocks);
    }
}
