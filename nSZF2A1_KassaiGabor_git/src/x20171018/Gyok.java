package x20171018;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tanulo
 */
public class Gyok {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Szám: ");
        try {
            double a = sc.nextDouble();
            double sqrt = Math.sqrt(a);
            if (Double.isNaN(sqrt)) {
                throw new Exception();
            }
            System.out.println(a + " négyzetgyöke " + String.format("%.3f", sqrt));
        } catch (InputMismatchException ime) {
            System.out.println("Érvénytelen szám.");
        } catch (Exception e) {
            System.out.println("Negatív számból nem lehet négyzetgyököt vonni.");
        }
    }
}
