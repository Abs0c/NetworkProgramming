import java.io.*;
import java.nio.Buffer;

public class BigFileTest {
    public static void main(String[] args) {
        try {
            System.out.println("File Read Start");
            FileInputStream in = new FileInputStream("./Myfile");
            BufferedInputStream br = new BufferedInputStream(in);
            int data = 0;

            while((data = br.read()) != -1){
                //System.out.println(data);
            }

            System.out.println("File Read Finish");
            br.close();
            /*
            FileInputStream in = new FileInputStream("./Myfile");

            // 읽는데 한 세월 걸려...하나씩 읽으니까..
            while ((data = in.read()) != -1){
                //System.out.println(data);
            }
            */

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createFile() {
        RandomAccessFile file = null;
        long fileSize = 1024 * 1024 * 1024 * 3L; // 3GB
        try {
            file = new RandomAccessFile("./Myfile", "rw");
            file.setLength(fileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
