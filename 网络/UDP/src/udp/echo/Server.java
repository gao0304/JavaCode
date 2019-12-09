//服务端
package udp.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final Map<String,String> dict=new HashMap<>();
    static {
        dict.put("cat","猫");
        dict.put("dog","狗");
        dict.put("pig","猪");
        dict.put("fish","鱼");
    }
    public static void main(String[] args) throws IOException {
        // 1. 新建一个 DatagramSocket
        DatagramSocket udpServerSocket = new DatagramSocket(9898);
        while (true) {
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer,
                    receiveBuffer.length);
            //2. 等着客户端来撩
            udpServerSocket.receive(receivePacket);
            InetAddress clientAddress=receivePacket.getAddress();
            System.out.printf("我从 %s:%d  收到了消息%n",
                    clientAddress.getHostAddress(),
                    receivePacket.getPort());
            System.out.printf("我一共收到了 %d 字节的数据%n", receivePacket.getLength());
            //将字节转换为字符串输出
            String message=new String(receivePacket.getData(),0,receivePacket.getLength(),"UTF-8");
            System.out.println(message);
            String responsemessage =dict.getOrDefault(message,"暂时不知道这个的意思哈");
            byte[] sendBuffer=responsemessage.getBytes("UTF-8");
            //回应一句与对方一模一样的消息
            //byte[] sendBuffer = message.getBytes("UTF-8");
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    clientAddress,
                    receivePacket.getPort()
            );
            udpServerSocket.send(sendPacket);
            //udpServerSocket.close();
        }
    }
}
