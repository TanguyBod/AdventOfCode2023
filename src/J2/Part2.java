package J2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("./src/J2/data.txt");
        BufferedReader bin = new BufferedReader(in); 
        int total = 0;
        while(bin.ready()) {
            String line = bin.readLine();
            String[] tokens = line.split(":");
            String[] tokens_1 = tokens[1].split(";");
            int b = 0; int r = 0; int v = 0;
            for(int i = 0; i<tokens_1.length; i++) {
                String[] colors = tokens_1[i].split(",");
                for(int j = 0; j<colors.length; j++) {
                    int nb = Integer.parseInt(colors[j].split(" ")[1].trim());
                    String c = colors[j].split(" ")[2].trim();
                    if (c.equals("blue") && nb>b) {
                        b=nb;
                    } else if (c.equals("red") && nb>r) {
                        r=nb;
                    } else if (c.equals("green") && nb>v) {
                        v=nb;
                    }
                }
            }
            total += b*r*v;
        }
        System.out.println(total);
        bin.close();
    }
}
