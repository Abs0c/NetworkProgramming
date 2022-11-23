package serialization;

import java.io.*;

public class SerializationMain {
    public static void main(String[] args) {
        User user = new User(1L, "사용자 1", "abcd1234");
        writeObject(user);
        readObject();
    }

    public static void readObject() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("./user.obj"));){
            User user = (User)in.readObject();
            System.out.println(user.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeObject(User user){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./user.obj"));){
            out.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

