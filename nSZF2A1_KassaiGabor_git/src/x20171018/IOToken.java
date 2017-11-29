package x20171018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Tanulo
 */
public class IOToken {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in,"UTF-8");
        System.out.println("Kérek több egész számot vesszővel elválasztva!");
        String sor = sc.nextLine();
        
        StringTokenizer st = new StringTokenizer(sor, " ");
        int db = st.countTokens();
        List<String> numbers = new ArrayList<>();
        List<String> invalids = new ArrayList<>();
        String token;
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            try {
                sum += Integer.parseInt(token);
                numbers.add(token);
            } catch (NumberFormatException nfe) {
                invalids.add(token);
            }
        }
        System.out.println();
        System.out.println("A beolvasott számok (" + db + " db) összege: " + sum);
        
        String sumString = "";
        for (int i = 0; i < numbers.size(); i++) {
            sumString += numbers.get(i);
            if (i != numbers.size() - 1) {
                sumString += "+";
            }
        }
        sumString += "=" + sum;
        System.out.println(sumString);
        System.out.println();
        System.out.println("Érvénytelen számok:");
        for (String invalid : invalids) {
            System.out.println(invalid + "");
        }
        
    }
}
