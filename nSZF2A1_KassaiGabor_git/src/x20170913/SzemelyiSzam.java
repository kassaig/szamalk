package x20170913;

import java.util.Scanner;

public class SzemelyiSzam {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Személyi szám: ");
        
        String szemelyiSzam = scanner.nextLine();
        
        boolean ervenyes = ervenyes(szemelyiSzam);
        System.out.println(ervenyes ? "Érvényes" : "Érvénytelen");
        
        if (ervenyes) {
            System.out.println("---");
            informacioKiiras(szemelyiSzam);
        }
    }
    
    private static boolean ervenyes(String szemelyiSzam) {
        final int HOSSZ = 11;
        if (szemelyiSzam.length() != HOSSZ) {
            return false;
        }
        
        int ee = Integer.parseInt(szemelyiSzam.substring(1, 3));
        
        int sum = 0;
        if (ee < 97) {
            for (int i = 0; i < HOSSZ; i++) {
                sum += (i + 1) * szemelyiSzam.charAt(i);
            }
        } else {
            for (int i = HOSSZ - 1; i > 0; i--) {
                sum += i * szemelyiSzam.charAt(i - 1);
            }
        }
        int k = sum % 11;
        
        if (k == 10) { //10 nem kiosztható
            return false;
        }
        
        if (k == Integer.parseInt(szemelyiSzam.substring(HOSSZ - 1))) { // számított ellenőrző számjegy egyezik a megadottal
            return true;
        }
        
        return false;
    }
    
    private static void informacioKiiras(String szemelyiSzam) {
        int m = Integer.parseInt(szemelyiSzam.substring(0, 1));
        String ee = szemelyiSzam.substring(1, 3);
        int hh = Integer.parseInt(szemelyiSzam.substring(3, 5));
        int nn = Integer.parseInt(szemelyiSzam.substring(5, 7));
        
        System.out.println("Nem: " + (m % 2 == 0 ? "Nő" : "Férfi"));
        
        System.out.print("Születési dátum: ");
        String szuletesiEv = new String();
        if (m == 1 || m == 2 || m == 5 || m == 6) {
            szuletesiEv += "19";
        } else if (m == 3 || m == 4 || m == 7 || m == 8) {
            szuletesiEv += "18";
        }
        szuletesiEv += ee;
        System.out.println(szuletesiEv + "." + padTen(hh) + "." + padTen(nn) + ".");
        
        System.out.print("Állampolgárság: ");
        if (m >= 1 && m <= 4) {
            if (Integer.parseInt(szuletesiEv) < 1997) {
                System.out.println("magyar");
            } else {
                System.out.println("nem tudni");
            }
        } else if (m >= 5 && m <= 8) {
            System.out.println("Eredetileg nem magyar");
        }
    }
    
    private static String padTen(int a) {
        if (a < 10) {
            return '0' + Integer.toString(a);
        }
        return Integer.toString(a);
    }
}
