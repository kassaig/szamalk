package x20171025;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Vissza {
    
    public static void main(String[] args) {
        File f = new File("src/x20171025/vissza.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f, "UTF-8");
        } catch (FileNotFoundException ex) {
            System.out.println("A fájl nem található!");
            return;
        }
        String line;
        String longestWord = "";
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.length() > longestWord.length()) {
                longestWord = line;
            }
        }
        System.out.println("A leghosszabb szó előre és visszafele:");
        System.out.println(longestWord);
        System.out.println(new StringBuilder().append(longestWord).reverse());
    }
}