import java.io.*;

public class ReaderWriterEx {
    public static void main(String[] args) {
        //한글 테스트...한글은 유니코드 2Byte...그런데 InputStream으로 하면 1Byte로 핸들링하기때문에 깨짐...
        //Reader와 Writer사용하면 제대로 읽히지~
        //사진 같은 파일을 다룰때는 FileInputStream // 문자열쓸때는 Reader..?
        /*
        try {
            File file = new File("./sample.txt");
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
        /*
        try {
            FileOutputStream out = new FileOutputStream("./sample.txt");
            for(int i = 65; i < 91; i++){
                //System.out.println((char) i);
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        /*
        try {
            FileInputStream in = new FileInputStream("C:\\Users\\qjfjr\\Desktop\\IntelliJ_WorkSpace\\NetworkProgramming\\ReaderWriterEx.java");
            while(in.available() > 0){
                System.out.print((char) in.read());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
        try {
            //CharArrayReader in2 = new CharArrayReader(""); ByteArrayInputStream -> CharArrayReader 왜냐면 Byte는 Char가 아니니까
            FileReader in = new FileReader("C:\\Users\\qjfjr\\Desktop\\IntelliJ_WorkSpace\\NetworkProgramming\\ReaderWriterEx.java");
            int data = 0;
            while ((data = in.read()) != -1){
                System.out.print((char) data);
            }
            in.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
