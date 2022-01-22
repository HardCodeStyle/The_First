import InputOutput.*;


public class Handler {
    Input input = new Input();
    choseOutput choseOutput = new choseOutput();
    Output output = new Output();

    public void handlerInput(Handler handler){
        handler.checkInput(input.Input());
    }

    public void checkInput(String readFromConsole){
        if (readFromConsole.equals("/help")){
            output.output(choseOutput.helpMessage());
        }
    }
}
