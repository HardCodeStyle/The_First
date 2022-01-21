import java.io.*;

public class ReadPriceFromGoogleFinance {
    String[] fileNames;

    public Prices read_Price_From_Download(String fileName){
        getFileNames();
        String lineOfPriceGoogle = read_Line_Of_Price_From_Download(fileName);
        Double price = cut_Price_From_String(lineOfPriceGoogle);
        Prices prices = new Prices();
        prices.setPrice(price);
        return prices;
    }

    private void getFileNames() {
    }

    private Double cut_Price_From_String(String lineOfPriceGoogle) {
        String[] result = lineOfPriceGoogle.split("data-last-price");
        String[] result1 = result[1].split(" ");
        String test = result1[0].replace("=","");
        test =  test.replace("\"","");
        double price = Double.parseDouble(test);
        return price;
    }

    public String read_Line_Of_Price_From_Download(String fileName){
        String lineOfPriceGoogle = "";
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                if (line.contains("data-last-price") ){
                    lineOfPriceGoogle = line;
                }
            }
            // line is not visible here.
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineOfPriceGoogle;
    }

}
