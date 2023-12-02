package J2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1 {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("./src/J2/data.txt");
        BufferedReader bin = new BufferedReader(in); 
        int total = 0; int game_nb = 1;
        while(bin.ready()) {
            String line = bin.readLine();
            String[] tokens = line.split(":");
            String[] tokens_1 = tokens[1].split(";");
            boolean possible = true;
            for(int i = 0; i<tokens_1.length; i++) {
                int b = 0; int r = 0; int v = 0;
                String[] colors = tokens_1[i].split(",");
                for(int j = 0; j<colors.length; j++) {
                    int nb = Integer.parseInt(colors[j].split(" ")[1].trim());
                    String c = colors[j].split(" ")[2].trim();
                    if (c.equals("blue")) {
                        b=nb;
                    } else if (c.equals("red")) {
                        r=nb;
                    } else if (c.equals("green")) {
                        v=nb;
                    }
                }
                if (b>14 || r>12 || v>13) {
                    possible = false;
                }
            }
            if(possible) {total+=game_nb;}
            game_nb+=1;
        }
        System.out.println(total);
        bin.close();
    }
}
