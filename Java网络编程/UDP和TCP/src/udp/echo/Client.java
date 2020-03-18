//客户端
package udp.echo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpClientSocket = new DatagramSocket();
        Scanner scanner=new Scanner(System.in);
        while (true) {
            String message=scanner.nextLine();
            //String message="我是高峰峰";
            byte[] sendBuffer = message.getBytes("UTF-8");
            //服务端ip127.168.0.109
            byte[] serverIP = new byte[4];
            serverIP[0] = (byte) 192;
            serverIP[1] = (byte) 168;
            serverIP[2] = (byte) 0;
            serverIP[3] = (byte) 109;
            InetAddress serverAddress = InetAddress.getByAddress(serverIP);
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    serverAddress,
                    9898
            );
            udpClientSocket.send(sendPacket);
            // 接受对方回应的消息
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(
                    receiveBuffer, receiveBuffer.length);
            udpClientSocket.receive(receivePacket);
            String responseMessage = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength(),
                    "UTF-8"
            );
            System.out.println(responseMessage);
            //udpClientSocket.close();
        }
    }
}
