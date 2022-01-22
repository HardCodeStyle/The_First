package Init;

import Download.Download;
import ReadPrice.ReadPriceFromGoogleFinance;

public class InitNewValues {
    ReadPriceFromGoogleFinance readPriceFromGoogleFinance = new ReadPriceFromGoogleFinance();
    Download download = new Download();
    String[] stocks = {"SSAC:AMS","CCC3:ETR"};
    String[] stocksFolder = {"SSAC_AMS","CCC3_ETR"};

    public int getInfo(){
        boolean stateDownload = download(stocks,stocksFolder);
        boolean stateSave = save(stocksFolder);
        if (stateDownload && stateSave ){
            return 0;
        }else if(stateDownload){
            return 1;
        }else{
            return 2;
        }
    }
    private boolean loadDataFromFileForListOfStocks(){

        return false;
    }
    private boolean download(String[] stocks, String[] stocksFolder) {

        return download.download(stocks,stocksFolder);

    }

    private boolean save(String[] stocksFolder){
        return readPriceFromGoogleFinance.read_Price_From_Download(stocksFolder);
    }
}
