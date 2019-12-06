package Knowledge.Conmunication.TCP;

import java.net.ServerSocket;
import java.net.Socket;

public class Service {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8001);
            while (true) {
                Socket s = ss.accept();
                System.out.println("连接成功");
                new Thread(new SendTime(s)).start();
            }
            //ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
