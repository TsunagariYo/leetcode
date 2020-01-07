package Knowledge.IOConclusion.NIO;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @ClassName CharRoomServer
 * @Description
 * @Author Administrator
 * @Date 2020/1/6 0006 17:44
 */
public class CharRoomServer implements Runnable{

    private ServerSocketChannel serverSocketChannel = null;

    private Selector selector = null;

    public static final int PORT_NUM = 1198;

    private boolean active = true;

    private Charset charset = Charset.forName("UTF-8");

    private List<String> users  = new ArrayList<String>();

    private ByteBuffer byteBuffer = ByteBuffer.allocate(2*1024);

    public static final String protocol = "#user#";

    public CharRoomServer() {
        this.init();
    }

    public void init() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT_NUM));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("开始监听。。。。");
        while (active) {
            try {
                //非阻塞接受连接
//                int s = selector.selectNow();

                //阻塞连接
                int s = selector.select();

                System.out.println("服务端接受到连接总数"+selector.keys().size());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("服务端接受到的选择连接数"+selector.selectedKeys().size());
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey k = keys.next();
                keys.remove();
                //处理逻辑
                doHandler(selector, k);
            }
        }
    }

    private void doHandler(Selector selector, SelectionKey k) {
        try {
            //连接事件
            if (k.isConnectable()) {
                System.out.println("Connectable 连接事件");
            } else if (k.isAcceptable()) {
                ServerSocketChannel ser = (ServerSocketChannel) k.channel();
                if (ser == serverSocketChannel) {
                    System.out.println("同一个连接");
                }
                SocketChannel socketChannel = ser.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
                socketChannel.write(charset.encode("please enter login name:"));

                //设置k为接受事件，准备接受其它请求？

            } else if (k.isReadable()) {
                //获取客户端连接
                SocketChannel socketChannel = (SocketChannel) k.channel();
                StringBuffer content = new StringBuffer();
                int sum = 0;
                try {
                    byteBuffer.clear();
                    while ((sum = socketChannel.read(byteBuffer)) > 0) {
                        byteBuffer.flip();
                        content.append(charset.decode(byteBuffer));
                    }
                    System.out.println(sum);
                    //判断客户端连接关闭
                    if (sum == -1) {
                        socketChannel.close();
                        System.out.println("1--关闭连接");
                    }

                    System.out.println("服务端：监听："+ content.toString());
                } catch (Exception e) {
                    System.out.println("2--关闭连接");
                    k.cancel();
                    if (null != socketChannel) {
                        socketChannel.close();
                    }
                }
                if (content.length() > 0) {
                    //按照协议切分内容
                    String[] contents = content.toString().split(protocol);
                    //登陆用户
                    if (contents != null && contents.length == 1) {
                        String user = contents[0];
                        if (users.contains(user)) {
                            socketChannel.write(charset.encode("登陆用户已存在！"));
                        } else {
                            users.add(user);
                            //获取在线人数
                            int i = onlineCount(selector);
                            //广播登陆消息给当前房间所有人
                            brokerMessage(selector, k, "欢迎"+user+"登陆，当前第"+i+"号");
                        }
                    } else if (contents != null && contents.length > 1) {
                        String message = contents[0] + "say :" + contents[1];
                        brokerMessage(selector, k, message);
                    }
                }
            } else if (k.isWritable()) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 广播消息
     * @param content
     */
    private void brokerMessage(Selector selector, SelectionKey k, String content) {
        for (SelectionKey key : selector.keys()) {
            if (key.channel() instanceof SocketChannel && key != k) {
                try {
                    SocketChannel sc = (SocketChannel) key.channel();
                    sc.write(charset.encode(content));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 统计在线人数
     * @param selector
     * @return
     */
    private int onlineCount(Selector selector) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("开始启动服务");
        new Thread(new CharRoomServer()).start();
        System.out.println("服务启动");
    }
}
