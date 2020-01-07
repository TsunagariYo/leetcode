package Knowledge.IOConclusion.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TimeServer
 * @Description
 * @Author Administrator
 * @Date 2020/1/6 0006 17:00
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8088;
        if (args != null && args.length != 0) {
            try {
                port = Integer.valueOf(port);
            } catch (NumberFormatException e) {
                port = 8088;
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            while (true){
                 socket = server.accept();
                 new Thread(new TimeServerHanlder(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server != null){
                System.out.println("The time server close");
                server.close();
                server = null;
            }
        }
    }
}
