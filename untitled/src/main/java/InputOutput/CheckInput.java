package InputOutput;

import DataClasses.Stocks.Data;

public class CheckInput {


    public String CheckInputFromConsole(String readFromConsole, ChoseOutput choseOutput, Data data, CheckInput checkInput){
        if (readFromConsole.equals("/help")) {
            return choseOutput.helpMessage();
        }else if(readFromConsole.equals("/stocks")){
            return choseOutput.listSocks(data.getStocks());
        }else if(checkInput.containsDataFromFile(readFromConsole,data)){
            return choseOutput.listSocks(data.getStocks());
        } else{
            return "Please Restart the Application";
        }
    }

    private boolean containsDataFromFile(String readFromConsole, Data data) {
        for (String a: data.getStocks()) {
            if(readFromConsole.contains(a)){
                return true;
            }
        }
        return false;
    }
}
