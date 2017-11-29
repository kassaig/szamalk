package x20171129;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Tanulo
 */


public class SerializeToXML {
    public static void main(String[] args) throws FileNotFoundException {
        Student s1 = new Student();
        s1.setName("A B");
        s1.setAge(21);
        Student s2 = new Student();
        s1.setName("B C");
        s1.setAge(22);
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("src/x20171129/students.xml")));
        encoder.writeObject(s1);
        encoder.writeObject(s2);
        encoder.close();
    }
}
