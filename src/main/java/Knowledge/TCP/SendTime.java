package Knowledge.TCP;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendTime implements Runnable {
    private  Socket s;

    public SendTime(Socket s) {
        this.s = s;
    }

    public void run() {
        System.out.println("服务开始");
        try {
            InputStream ips = s.getInputStream();
            OutputStream ops = s.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ips, StandardCharsets.UTF_8));
            PrintStream ps = new PrintStream(ops, true, StandardCharsets.UTF_8.toString());

            while (true) {
                String str = br.readLine();
                System.out.println("客户端:" + str);
                if (str.equalsIgnoreCase("quit"))
                    break;
                else {
                    if (str.equalsIgnoreCase("time")) {
                        Date time = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        ps.println(ft.format(time));

                    } else {
                        String strEcho = str + " 666";
                        ps.println(strEcho);
                    }
                }
            }
            br.close();
            ps.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
