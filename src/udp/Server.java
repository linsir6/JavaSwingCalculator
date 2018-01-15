package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {

    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(9999);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                ds.receive(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(new String(buffer, 0, dp.getLength()));
        }
    }



}
