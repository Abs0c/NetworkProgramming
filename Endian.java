import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Endian {
    public static void main(String[] args) {
        //System.out.println(ByteOrder.nativeOrder().toString()); //시스템 디폴트 엔디언 확인
        int data = 0x01020304;

        //ByteBuffer buff = new ByteBuffer(); ByteBuffer에 생성자가 없음..
        ByteBuffer buff = ByteBuffer.allocate(4); // 4바이트
        //buff.order(ByteOrder.BIG_ENDIAN); 출력값 1 2 3 4
        buff.order(ByteOrder.LITTLE_ENDIAN); // 출력값 4 3 2 1
        buff.putInt(data);
        byte[] result = buff.array();
        System.out.println(Arrays.toString(result));
    }
}
