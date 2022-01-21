package ReadPrice;

import java.io.*;
import Price.Prices;
import Writefile.WritePriceFile;

public class ReadPriceFromGoogleFinance {
    String[] fileNames;

    public Prices read_Price_From_Download(String[] stocks) {
        getFileNames();
        for(int i=0 ; i< fileNames.length;i++){
            System.out.println(fileNames[i]);
            System.out.println(i);
            String lineOfPriceGoogle = read_Line_Of_Price_From_Download("untitled/src/Files/"+fileNames[i]);
            Double price = cut_Price_From_String(lineOfPriceGoogle);
            Prices prices = new Prices();
            prices.setPrice(price);
            WritePriceFile writePriceFile = new WritePriceFile();
            if(fileNames[i].contains(stocks[0])){
                writePriceFile.SaveMsciAcwi(prices.getPrice(),stocks[0]);
            }else if (fileNames[i].contains(stocks[1])){
                writePriceFile.SaveMsciAcwi(prices.getPrice(),stocks[1]);
            }
        }

        return null;
    }

    private void getFileNames() {
        File f = new File("untitled/src/Files");
        fileNames = f.list();
        System.out.println(fileNames.length);
    }

    private Double cut_Price_From_String(String lineOfPriceGoogle) {
        String[] result = lineOfPriceGoogle.split("data-last-price");
        String[] result1 = result[1].split(" ");
        String test = result1[0].replace("=", "");
        test = test.replace("\"", "");
        double price = Double.parseDouble(test);
        return price;
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
            e.printStackTrace();
        }

        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully");
        } else {
            System.out.println("Failed to delete the file");
        }
        return lineOfPriceGoogle;
    }

}
