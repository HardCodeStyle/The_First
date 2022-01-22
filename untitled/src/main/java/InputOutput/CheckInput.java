package InputOutput;

import DataClasses.Stocks.Data;

public class CheckInput {

    public String CheckInputFromConsole(String readFromConsole, ChoseOutput choseOutput, Data data){
        if (readFromConsole.equals("/help")) {
            return choseOutput.helpMessage();
        }else if(readFromConsole.equals("/stocks")){
            return choseOutput.listSocks(data.getStocks());
        }else{
            return "Please Restart the Application";
        }
    }
}
