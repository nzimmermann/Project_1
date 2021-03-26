import com.framework.system.ClientBean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;


public class Test {



    public static void main(String[] args) {
        Object cb = null;

        FileInputStream fis;
        try {
            fis = new FileInputStream("ClientBean.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            cb = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }






    }



}
