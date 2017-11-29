package x20171011;

import java.util.Scanner;

/**
 *
 * @author Tanulo
 */
public class osztas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kérem az osztandót!");
        int osztandó = sc.nextInt();
        System.out.println("Kérem az osztót!");
        int osztó = sc.nextInt();
        boolean sikeres = false;
        try {
            double hányados = (double)(osztandó / osztó);
            System.out.println(osztandó + " / " + osztó + " = " + hányados);
            sikeres = true;
        } catch (ArithmeticException ae) {
            System.out.println("Hiba: " + ae.getMessage());
        } finally {
            if (sikeres) {
                System.out.println("Az osztás sikeresen lezajlott.");
            } else {
                System.out.println("Az osztás sikertelen!");
            }
        }
    }
}
