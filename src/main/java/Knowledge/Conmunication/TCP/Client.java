package Knowledge.Conmunication.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8001); //主机ip和端口
        //开启输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader brNet = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        //开启输出流
        OutputStream outputStream = socket.getOutputStream();
        PrintStream printStream = new PrintStream(outputStream, true, StandardCharsets.UTF_8.toString());
        BufferedReader brKey = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        while (true) {
            String line = brKey.readLine();
            if (line.equalsIgnoreCase("quit")) {
                printStream.println(line);
                break;
            } else {
                printStream.println(line);
                System.out.println("服务端:" + brNet.readLine());
            }
        }
        brNet.close();
        printStream.close();
        brKey.close();

    }
}
