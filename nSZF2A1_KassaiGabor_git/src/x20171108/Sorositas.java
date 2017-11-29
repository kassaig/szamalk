package x20171108;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kassai Gábor
 */

class Diak implements Serializable {
    String nev;
    Integer kor;
}

public class Sorositas {
    private static void make() throws FileNotFoundException, IOException {
        Diak sanyi = new Diak();
        sanyi.nev = "Nagy Sándor";
        sanyi.kor = 32;
        
        Diak eszmeralda = new Diak();
        eszmeralda.nev = "Pityinger Eszmeralda";
        eszmeralda.kor = 42;
        
        FileOutputStream fos = new FileOutputStream("data.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sanyi);
        oos.writeObject(eszmeralda);
        oos.close();
        fos.close();
    }
    
    private static void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("data.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Diak sanyi = (Diak)ois.readObject();
        System.out.println(sanyi.nev + " " + sanyi.kor);
        
        Diak eszmeralda = (Diak)ois.readObject();
        System.out.println(eszmeralda.nev + " " + eszmeralda.kor);
        
        ois.close();
        fis.close();
    }
    
    private static void load2() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("data.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Diak d;
        try {
            while (true) {
                d = (Diak)ois.readObject();
                System.out.println("név: " + d.nev);
                System.out.println("kor: " + d.kor);
            }
        } catch (EOFException ee) {
            
        } finally {
            ois.close();
            fis.close();
        }
    }
    
    public static void main(String[] args) {
        try {
            make();
        } catch (IOException ex) {
            Logger.getLogger(Sorositas.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load2();
        } catch (IOException ex) {
            Logger.getLogger(Sorositas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sorositas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
