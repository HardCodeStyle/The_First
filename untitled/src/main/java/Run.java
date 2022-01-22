import DataClasses.Stocks.Data;
import Init.InitNewValues;
import InputOutput.Output;
import InputOutput.ChoseOutput;
import ReadDataFile.ReadDataFiles;

public class Run {
    boolean state = true;
    ChoseOutput choseOutput = new ChoseOutput();
    Output output = new Output();
    Handler handler;
    ReadDataFiles readDataFiles = new ReadDataFiles();
    Data data = new Data();

    public void preRun(){
        InitNewValues initNewValues = new InitNewValues();
        choseOutput.ChoseOutputForInit(initNewValues.getInfo());
        readDataFiles.readStocksFromFile(data);
        output.output(choseOutput.getOutPut());
        output.output(choseOutput.firstMessageBeforeLoop());
        this.handler = new Handler(data,output,choseOutput);
    }

    public void run (){
        while (state){
            output.output(choseOutput.firstMessageInLoop());
            handler.handlerInput(handler);
        }
    }

    public void postRun() {

    }
}
