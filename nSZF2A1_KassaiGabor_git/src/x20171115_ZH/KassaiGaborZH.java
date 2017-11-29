package x20171115_ZH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kassai Gábor
 */
public class KassaiGaborZH {
    private static class Versenyzo {
        public String azonosito;
        public String valaszok;
        
        @Override
        public String toString() {
            return azonosito + " " + valaszok;
        }
    }
    
    private static final String FILE_NEV = "src/x20171115_ZH/valaszok.txt";
    private static final int KERDESEK_SZAMA = 14;
    private static Versenyzo[] versenyzok;
    private static int hanyVersenyzo;
    private static String helyesValaszok;
    private static int versenyzo;
    private static Scanner sc;
    
    public static void main(String[] args) {
        versenyzok = new Versenyzo[500];
        hanyVersenyzo = 0;
        sc = new Scanner(System.in);
        
        try {
            feladat1();
            //betoltottekKiirasa(); // DEBUG
        } catch (FileNotFoundException ex) {
            System.out.println("Nem található a fájl (" + FILE_NEV + ").");
        }
        
        feladat2();
        System.out.println();
        feladat3();
        System.out.println();
        feladat4();
        System.out.println();
        feladat5();
        System.out.println();
        feladat6();
    }
    
    private static void betoltottekKiirasa() {
        System.out.println(helyesValaszok);
        for (int i = 0; i < hanyVersenyzo; i++) {
            System.out.println(versenyzok[i]);
        }
    }
    
    private static void feladat1() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_NEV));
        try {
            helyesValaszok = br.readLine();
            String sor;
            while (true && (sor = br.readLine()) != null) {
                versenyzok[hanyVersenyzo] = new Versenyzo();
                
                String[] elemek = sor.split(" ");
                versenyzok[hanyVersenyzo].azonosito = elemek[0];
                versenyzok[hanyVersenyzo].valaszok = elemek[1];
                hanyVersenyzo++;
            }
        } catch (IOException ioe) {
            // fájl vége
        }
        try {
            br.close();
        } catch (IOException ex) {
            
        }
    }
    
    private static void feladat2() {
        System.out.print("2. feladat: ");
        System.out.println("A vetélkedőn " + hanyVersenyzo + " versenyző indult.");
    }
    
    private static void feladat3() {
        System.out.print("3. feladat: ");
        System.out.print("A versenyző azonosítója = ");
        String azonosito = sc.nextLine();
        versenyzo = 0;
        while (versenyzo < hanyVersenyzo && !versenyzok[versenyzo].azonosito.equals(azonosito)) {
            versenyzo++;
        }
        //System.out.println("i: " + i); // DEBUG
        System.out.println(versenyzok[versenyzo].valaszok + "\t(a versenyző válasza)");
    }
    
    private static void feladat4() {
        System.out.println("4. feladat: ");
        System.out.println(helyesValaszok + "\t(a helyes megoldás)");
        for (int i = 0; i < KERDESEK_SZAMA; i++) {
            System.out.print((versenyzok[versenyzo].valaszok.charAt(i) == helyesValaszok.charAt(i) ? "+" : " "));
        }
        System.out.println("\t(a versenyző helyes válaszai)");
    }
    
    private static void feladat5() {
        System.out.print("5. feladat: ");
        System.out.print("A feladat sorszáma = ");
        int feladatSorszam = sc.nextInt() - 1;
        char helyesValasz = helyesValaszok.charAt(feladatSorszam);
        int hanyHelyesValasz = 0;
        for (int i = 0; i < hanyVersenyzo; i++) {
            if (versenyzok[i].valaszok.charAt(feladatSorszam) == helyesValasz) {
                hanyHelyesValasz++;
            }
        }
        double helyesSzazalek = (double)hanyHelyesValasz / hanyVersenyzo * 100;
        //System.out.println(helyesSzazalek); // DEBUG
        System.out.println("A feladatra "
                + hanyHelyesValasz
                + " fő, a versenyzők "
                + String.format("%.2f", helyesSzazalek)
                + "%-a adott helyes választ.");
    }
    
    private static void feladat6() {
        File kimenetiFajl = new File("src/x20171115_ZH/pontok.txt");
        try {
            kimenetiFajl.createNewFile();
        } catch (IOException ex) {
            System.out.println("!!! Create");
        }
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(kimenetiFajl));
        } catch (IOException ex) {
            System.out.println("!!! Writer");
            return;
        }
        String sor;
        for (int v = 0; v < hanyVersenyzo; v++) {
            sor = versenyzok[v].azonosito;
            int pontok = 0;
            for (int i = 0; i < KERDESEK_SZAMA; i++) {
                if (versenyzok[v].valaszok.charAt(i) == helyesValaszok.charAt(i)) {
                    if (i < 5) {
                        pontok += 3;
                    } else if (i < 10) {
                        pontok += 4;
                    } else if (i < 13) {
                        pontok += 5;
                    } else {
                        pontok += 6;
                    }
                }
            }
            try {
                sor += " " + pontok;
                bw.write(sor);
                bw.newLine();
            } catch (IOException ex) {
                System.out.println("Hiba íráskor");
                return;
            }
        }
        try {
            bw.close();
        } catch (IOException ex) {
            System.out.println("!!! Close");
            return;
        }
    }
}
