package Download;

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Date;

public class Download {

        public void download(String[] stocks) {

            for (int i =0; i<=stocks.length-1; i++){
                String webpage = "https://www.google.com/finance/quote/"+stocks[i];
                try {

                    // Create URL object
                    URL url = new URL(webpage);
                    BufferedReader readr =
                            new BufferedReader(new InputStreamReader(url.openStream()));
                    Date date = new Date();
                    String dateString = String.valueOf(date.getTime());
                    String name = stocks [i].replace(":","_");
                    // Enter filename in which you want to download
                    BufferedWriter writer =
                            new BufferedWriter(new FileWriter("The_First/src/Files/Download_"+name+"_"+dateString+"_"+".txt"));

                    // read each line from stream till end
                    String line;
                    while ((line = readr.readLine()) != null) {
                        writer.write(line);
                    }

                    readr.close();
                    writer.close();
                    System.out.println("Successfully Downloaded.");
                }
                // Exceptions
                catch (MalformedURLException mue) {
                    System.out.println("Malformed URL Exception raised");
                }
                catch (IOException ie) {
                    System.out.println(ie);
                }
            }

        }
}
