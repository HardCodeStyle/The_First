package Init;

import Download.Download;
import ReadPrice.ReadPriceFromGoogleFinance;

public class InitNewValues {
    ReadPriceFromGoogleFinance readPriceFromGoogleFinance = new ReadPriceFromGoogleFinance();
    Download download = new Download();

    public void getInfo(){
        String[] stocks = {"SSAC:AMS","CCC3:ETR"};
        String[] stocksFolder = {"SSAC_AMS","CCC3_ETR"};
        downloadAndSave(stocks,stocksFolder);
    }

    private void downloadAndSave(String[] stocks, String[] stocksFolder) {
        download.download(stocks);
        readPriceFromGoogleFinance.read_Price_From_Download(stocksFolder);
    }
}
