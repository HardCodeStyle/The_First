import InputOutput.*;


public class Handler {
    Input input = new Input();
    ChoseOutput choseOutput = new ChoseOutput();
    Output output = new Output();
    CheckInput checkInput = new CheckInput();

    public void handlerInput(Handler handler){
        handler.checkInput(input.Input());
    }

    public void checkInput(String readFromConsole){
       output.output(checkInput.CheckInputFromConsole(readFromConsole,choseOutput));
    }
}
