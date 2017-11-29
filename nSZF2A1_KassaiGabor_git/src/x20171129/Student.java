package x20171129;

import java.io.Serializable;

/**
 *
 * @author Tanulo
 */
public class Student implements Serializable {
    public String name;
    public int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}