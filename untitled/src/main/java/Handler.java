import DataClasses.Stocks.Data;
import InputOutput.*;
import ReadDataFile.ReadDataFiles;


public class Handler {
    private final Input input;
    private final ChoseOutput choseOutput;
    private final Output output;
    private final CheckInput checkInput ;
    private final Data data;


        public Handler(Data data, Output output, ChoseOutput choseOutput){
            this.input = new Input() ;
            this.checkInput = new CheckInput();
            this.choseOutput = choseOutput;
            this.output = output;
            this.data= data;
        }
    public void handlerInput(Handler handler){
        handler.checkInput(input.Input());
    }

    public void checkInput(String readFromConsole){
       output.output(checkInput.CheckInputFromConsole(readFromConsole,choseOutput,data,checkInput));
    }
}
