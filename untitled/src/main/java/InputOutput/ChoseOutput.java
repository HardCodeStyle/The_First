package InputOutput;

import java.util.List;

public class ChoseOutput {
    private String OutPut ;

    public String getOutPut() {
        return OutPut;
    }

    public void setOutPut(String outPut) {
        OutPut = outPut;
    }

    public void ChoseOutputForInit(int state){
        switch(state){
            case 0:
                setOutPut("All data Loaded well!");
                break;
            case 1:
                setOutPut("Only the download worked well but the Value load in the program failed!");
                break;
            case 2:
                setOutPut("Data load failed completely!");
                break;
        }

    }

    public String firstMessageBeforeLoop(){
        return "Welcome and thanks for using this Application ! \n" +
                "Infos for using this App please type \"/help\" ! "
                ;
    }

    public String firstMessageInLoop(){
        return "Input please:";
    }

    public String helpMessage() {
        return "\n/help ----> you get help\n" +
                "/stocks ----> you get an list of all Stocks\n" +
                "/{name of stock} ----> you get am list of all data to this stock\n";
    }

    public String listSocks( List<String> stocks) {
        StringBuilder result= new StringBuilder("\nList of Stocks:\n");
        for (String a:stocks) {
            result.append(a).append("\n");
        }
        return result.toString();
    }
}
