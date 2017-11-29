package x20170906;

import java.util.Scanner;

public class SzemelyiSzam {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Személyi szám: ");
        
        String szemelyiSzam = scanner.nextLine();
        
        System.out.println(ervenyes(szemelyiSzam) ? "Érvényes" : "Érvénytelen");
    }
    
    private static boolean ervenyes(String szemelyiSzam) {
        if (szemelyiSzam.length() != 11) {
            return false;
        }
        
        int m = Integer.parseInt(szemelyiSzam.substring(0, 1));
        int ee = Integer.parseInt(szemelyiSzam.substring(1, 5));
        int hh = Integer.parseInt(szemelyiSzam.substring(5, 7));
        int nn = Integer.parseInt(szemelyiSzam.substring(7, 9));
        
        
        if (m < 2 && ee >= 96) {
            
        }
        
        int sum = 0;
        if (sum % 11 == 10) {
            return false;
        }
        
        return false;
    }
}
