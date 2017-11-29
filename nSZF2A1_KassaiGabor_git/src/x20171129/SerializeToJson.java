package x20171129;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Tanulo
 */
public class SerializeToJson {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student();
        s1.setName("A B");
        s1.setAge(21);
        
        Gson gson = new Gson();
        String json = gson.toJson(s1);
        
        BufferedWriter br = new BufferedWriter(new FileWriter("src/x20171129/student.json"));
        br.write(json);
        br.close();
    }
}
