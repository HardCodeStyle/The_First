package InputOutput;

public class CheckInput {

    public String CheckInputFromConsole(String readFromConsole, ChoseOutput choseOutput){
        if (readFromConsole.equals("/help")) {
            return choseOutput.helpMessage();
        }else if(readFromConsole.equals("/stocks")){
            return null;
        }else{
            return "Please Restart the Application";
        }
    }
}
