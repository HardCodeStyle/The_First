package InputOutput;
import java.util.Locale;
import java.util.Scanner;
public class Input {
  Scanner scan = new Scanner(System.in);
    public String Input() {
        String consoleLine = scan.nextLine().toLowerCase(Locale.ROOT).trim();
        return consoleLine;
    }
}
