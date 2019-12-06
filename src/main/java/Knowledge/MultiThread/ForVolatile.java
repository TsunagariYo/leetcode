package Knowledge.MultiThread;

import java.util.ArrayList;

/**
 * 线程之间的通信
 *
 * 通过Volatile关键子实现线程之间的通信
 */
public class ForVolatile {
    static volatile boolean notice = false;

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        //线程A
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("abc");
                System.out.println("在list集合中加入一个元素");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (list.size() == 5){
                    notice = true;
                }
            }
        });

        //线程b
        Thread thread1 = new Thread(() ->{
            while (true){
                if (notice){
                    System.out.println("线程B收到通知开始自己的业务");
                    for (int i = 0; i < 10; i++) {
                        list.add("efg");
                        System.out.println("线程b加入添加");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (Object o : list) {
                        System.out.println(o.toString());
                    }
                    break;
                }
            }
        });


        thread1.start();
        thread.start();



    }
}
