import java.io.*;

public class DataInputStreamEx {
    public static void main(String[] args) throws FileNotFoundException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream("./abc.x"));
        DataInputStream in = new DataInputStream(new FileInputStream("./abc.x"));
        try {
            //out.writeInt(20);
            //out.writeBoolean(true);
            int a = in.readInt();
            boolean b = in.readBoolean();
            System.out.println(a + " " + b);
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
