import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IPAddressMain {
    public static void main(String[] args) throws IOException, UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        System.out.println(InetAddress.getLoopbackAddress());
        System.out.println(InetAddress.getByName("www.naver.com"));
        System.out.println(InetAddress.getByName("www.suwon.ac.kr"));
        byte[] address = InetAddress.getByName("www.naver.com").getAddress();
        System.out.println(Arrays.toString(address)); // unsigned byte는 존재하지 않으므로 음수가 나올경우 255를 더해줘야함
        //한 바이트 최대범위 255까지
        for (int i = 0; i < address.length; i++){
            if (address[i] < 0) {
                System.out.println(address[i] + 256);
            }
            else{
                System.out.println(address[i]);
            }
        }

        System.out.println(InetAddress.getByName("www.naver.com").isReachable(100));
        System.out.println(InetAddress.getByName("www.google.com").isReachable(500));
        System.out.println(InetAddress.getByName("www.11st.com").isReachable(500));

        System.out.println(Inet4Address.getByName("127.0.0.1").isReachable(500));

    }
}