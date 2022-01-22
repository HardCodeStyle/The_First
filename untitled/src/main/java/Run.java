import Init.InitNewValues;
import InputOutput.Output;
import InputOutput.choseOutput;

public class Run {
    boolean state = true;
    choseOutput choseOutput = new choseOutput();
    Output output = new Output();
    Handler handler = new Handler();

    public void preRun(){
        InitNewValues initNewValues = new InitNewValues();
        choseOutput.ChoseOutputForInit(initNewValues.getInfo());
        output.output(choseOutput.getOutPut());
        output.output(choseOutput.firstMessageBeforeLoop());

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
