package ReadPrice;

import java.io.*;
import Price.Prices;
import Writefile.WritePriceFile;

public class ReadPriceFromGoogleFinance {
    String[] fileNames;
    boolean state = true;

    public boolean read_Price_From_Download(String[] stocks) {
        getFileNames();
        for (String fileName : fileNames) {
            String lineOfPriceGoogle = read_Line_Of_Price_From_Download("untitled/src/Files/" + fileName);
            Double price = cut_Price_From_String(lineOfPriceGoogle);
            Prices prices = new Prices();
            prices.setPrice(price);
            WritePriceFile writePriceFile = new WritePriceFile();
            if (fileName.contains(stocks[0])) {
                writePriceFile.SaveMsciAcwi(prices.getPrice(), stocks[0]);
            } else if (fileName.contains(stocks[1])) {
                writePriceFile.SaveMsciAcwi(prices.getPrice(), stocks[1]);
            }
        }

        return state;
    }

    private void getFileNames() {
        File f = new File("untitled/src/Files");
        fileNames = f.list();
    }

    private Double cut_Price_From_String(String lineOfPriceGoogle) {
        String[] result = lineOfPriceGoogle.split("data-last-price");
        String[] result1 = result[1].split(" ");
        String test = result1[0].replace("=", "");
        test = test.replace("\"", "");
        return Double.parseDouble(test);
    }

    public String read_Line_Of_Price_From_Download(String fileName) {
        String lineOfPriceGoogle = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (String line; (line = br.readLine()) != null; ) {
                if (line.contains("data-last-price")) {
                    lineOfPriceGoogle = line;
                }
            }
            // line is not visible here.
        } catch (IOException e) {
            state = false;
            e.printStackTrace();
        }

        File file = new File(fileName);
        file.delete();

        return lineOfPriceGoogle;
    }
}