package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) {
        byte[] buffer = "pppg!".getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, new InetSocketAddress("192.168.20.14", 9999));
        try {
            DatagramSocket ds = new DatagramSocket(9998);
            ds.send(dp);
            ds.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常");
        }
    }

}
