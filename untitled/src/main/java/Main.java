public class Main {
    public static void main(String[] args) {
        Main controller = new Main();
        Prices prices = controller.getPrices();
        System.out.println( prices.getPrice());
        WritePriceFile writePriceFile = new WritePriceFile();
        writePriceFile.test(prices.getPrice());
    }

    public Prices getPrices(){

        ReadPriceFromGoogleFinance readPriceFromGoogleFinance = new ReadPriceFromGoogleFinance();
        Prices prices = readPriceFromGoogleFinance.read_Price_From_Download("Download.txt");
        return prices;
    }
}
