import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class bytearray {
    public static void main(String[] args) {
        byte[] temp = new byte[3];
        byte[] original = new byte[]{0,1,2,3,4,5,6,7,8,9};
        ByteArrayInputStream in = new ByteArrayInputStream(original);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.out.println("[Before]");
        System.out.println(Arrays.toString(out.toByteArray()));
        /*
        int data = 0;
        while((data = in.read()) != -1 ){
            out.write(data);
        }
         */
        while(in.available() > 0){
            try {
                int count = in.read(temp); // read의 리턴값은 몇 개를 읽어왔는지를 반환함
                System.out.println(count);
                System.out.println("[TEMP] " + Arrays.toString(temp));
                out.write(temp, 0, count); //그냥 write보단 offset, length를 파악해서 쓰는것이 옳다
                //out.flush(); 버퍼를 일일이 비워주는건 많은 오버헤드가 발생하므로 권장하지 않고
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("[After]");
        System.out.println(Arrays.toString(out.toByteArray()));
    }
}
