package J1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calcul {
    public static void main(String[] args) throws IOException {
        FileReader in = new FileReader("./src/J1/data.txt");
        BufferedReader bin = new BufferedReader(in); 
        double total = 0;
        while(bin.ready()) {
            String line = bin.readLine();
            String[] tokens = line.split("");
            int length = tokens.length;
            int nb_dizaine = -1;
            int nb_unite = -1;
            for (int i = 0; i<length; i++) {
                if (estEntier(tokens[i])) {
                    if (nb_dizaine == -1) {
                        nb_dizaine = Integer.parseInt(tokens[i]);
                    } else {
                        nb_unite = Integer.parseInt(tokens[i]);
                    }
                } else {
                    int nb_char = charNumber(tokens, i, length);
                    if (nb_char!=0) {
                        if(nb_dizaine ==-1) {
                            nb_dizaine = nb_char;
                        } else {
                            nb_unite = nb_char;
                        }
                    }
                }
            }
            if (nb_unite == -1) {
                nb_unite = nb_dizaine;
            }
            int nb = 10*nb_dizaine+nb_unite;
            total += nb;
        }
        System.out.println(total);
        bin.close();
    }

    public static boolean estEntier(String txt) {
        try {
            Integer.parseInt(txt);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int charNumber(String[] txt, int indice, int totalLength) {
        if (totalLength-indice>=3) {
            String l3 = txt[indice] + txt[indice+1] + txt[indice+2];
            if(l3.equals("one")) {
                return 1;
            } else if (l3.equals("two")) {
                return 2;
            } else if (l3.equals("six")) {
                return 6;
            }
        }
        if (totalLength-indice>=4) {
            String l4 = txt[indice] + txt[indice+1] + txt[indice+2] + txt[indice+3];
            if(l4.equals("four")) {
                return 4;
            } else if (l4.equals("five")) {
                return 5;
            } else if (l4.equals("nine")) {
                return 9;
            }
        }
        if (totalLength-indice>=5) {
            String l5 = txt[indice] + txt[indice+1] + txt[indice+2] + txt[indice+3] + txt[indice+4];
            if(l5.equals("three")) {
                return 3;
            } else if (l5.equals("seven")) {
                return 7;
            } else if (l5.equals("eight")) {
                return 8;
            }
        } 
        return 0;
    }
}
