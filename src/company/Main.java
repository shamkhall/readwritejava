
// write, read, read byte
package company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args)  {
        // call methods
    }

    // Write byte
    public static void writeByte(byte[] data, String filename) throws IOException {
        Path filePath = Paths.get(filename);
        Files.write(filePath, data);
    }

    // Read byte
    public static byte[] readByte (String filename) throws IOException {
        Path filePath = Paths.get(filename);
        byte[] byteArray = Files.readAllBytes(filePath);
        return byteArray;
    }

    // Write object
    public static void writeObjectToFile(Serializable object, String filename) throws Exception{
        try(FileOutputStream fout = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
                ){
            oos.writeObject(object);
        }
    }

    // Read object
    public static Object readFileDeserialize(String filename)throws Exception{
        Object obj = null;
        FileInputStream fi = new FileInputStream(filename);
        try(ObjectInputStream in = new ObjectInputStream(fi)){
            obj = in.readObject();
        }
        finally {
            return obj;
        }
    }



}
