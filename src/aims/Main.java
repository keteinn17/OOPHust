package aims;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws IOException {
        String everything;
        BufferedReader br = new BufferedReader(new FileReader("D:\\Tai lieu\\Ki_20222\\OOP\\Lab\\AimsProject\\src\\aims\\a.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            br.close();
        }
        int dot = everything.indexOf(",");
        System.out.println(dot);
        System.out.println(everything.substring(dot+1));
        String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";

    }
}
