package Knowledge.Lambda;

import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;

/**
 * @ClassName LambdaDemo
 * @Description
 * @Author Administrator
 * @Date 2020/1/6 0006 10:33
 */

class MyRunable implements Runnable{

    @Override
    public void run() {
        System.out.println("多线程程序启动");
    }
}
public class LambdaDemo {
    @Test
    public void test(){
        new Thread(()-> System.out.println("多线程程序启动")).start();
    }
}
