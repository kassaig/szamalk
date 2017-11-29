package x20171004;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Tanulo
 */
public class SzemelyiSzamGeneraloFajlba {
    public static void main(String[] args) {
        Random random = new Random();

        final int SZAMJEGYEK_SZAMA = 11;

        int[] szamjegyek = new int[SZAMJEGYEK_SZAMA];

        // 1..8 nem - 1-8!
        // 00..99 év - 0-9!
        // 00..99 év 2 - 0-9!
        // 1..12 hónap - 0-1!
        // 1..12 hónap 2 - 0-2!
        // 1..27 nap - 0-3!
        // 1..27 nap 2 - 0-7!
        // 1..999 aznap hányadik - 0-9!
        // 1..999 aznap hányadik - 0-9!
        // 1..999 aznap hányadik - 0-9!
        // kiszámítandó ellenőrzés nem lehet 10 (?)
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kimeneti fájl: ");
        final Path path = Paths.get(scanner.nextLine());
        
        System.out.print("Hány személyi számot generálsz? ");
        final int HANYSZOR = scanner.nextInt();
        
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            System.out.println("Hiba a fájl írása közben.");
        }
        
        for (int h = 0; h < HANYSZOR; h++) {
            do {
                for (int i = 0; i < SZAMJEGYEK_SZAMA; i++) {
                    int szamjegy = -1;
                    if (i == 0) {
                        szamjegy = random.nextInt(8) + 1; // nem: 1..8
                    } else if (i == 1 || i == 2) { // évszám: 0..9
                        szamjegy = random.nextInt(10);
                    } else if (i == 3) { // hónap 1.: 0..1
                        szamjegy = random.nextInt(2);
                    } else if (i == 4) { // hónap 2.: 0..2 ha hónap 1. nem 0, egyébként 1..9
                        if (szamjegyek[i - 1] == 1) {
                            szamjegy = random.nextInt(3);
                        } else {
                            szamjegy = random.nextInt(9) + 1;
                        }
                    } else if (i == 5) { // nap 1.: 0..2 (2, hogy ne kelljen még több ellenőrzés)
                        szamjegy = random.nextInt(3);
                    } else if (i == 6) { // nap 2.: 0..7 (7, hogy ne kelljen még több ellenőrzés)
                        szamjegy = random.nextInt(8);
                    } else if (i == 7 || i == 8 || i == 9) { // aznap hányadik: 0..9
                        szamjegy = random.nextInt(10);
                    } else if (i == 10) { // ellenőrző számjegy
                        int sum = 0;
                        int ee = Integer.parseInt(Integer.toString(szamjegyek[1]) + Integer.toString(szamjegyek[2]));
                        if (ee < 97) {
                            for (int j = 0; j < SZAMJEGYEK_SZAMA; j++) {
                                sum += (j + 1) * szamjegyek[j];
                            }
                        } else {
                            for (int j = SZAMJEGYEK_SZAMA - 1; j > 0; j--) {
                                sum += j * szamjegyek[j - 1];
                            }
                        }
                        int k = sum % 11;
                        if (k == 10) {
                            System.out.println("k 10 !!!");
                        }
                        szamjegy = k;
                    }
                    szamjegyek[i] = szamjegy;
                }
            } while (szamjegyek[10] == 10);
            
            String szemelyiSzam = "";
            for (int j = 0; j < SZAMJEGYEK_SZAMA; j++) {
                szemelyiSzam += szamjegyek[j];
            }
            System.out.println(szemelyiSzam);

            try {
                bufferedWriter.write(szemelyiSzam);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                System.out.println("Hiba a fájl írása közben.");
            }
        }
        
        try {
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Hiba a fájl írása közben.");
        }
    }
}
