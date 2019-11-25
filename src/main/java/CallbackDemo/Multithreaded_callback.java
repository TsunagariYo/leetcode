package CallbackDemo;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 多线程的回调
 */
public class Multithreaded_callback {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call");
                TimeUnit.SECONDS.sleep(1);
                return "str";
            }
        });

        //手动阻塞调用get通过call方法获得返回值
        System.out.println(future.get());
        //手动关闭,不然线程池的线程会继续执行
        executorService.shutdown();
        //使用futuretask同时作为线程执行单元和数据请求单元
        FutureTask<Integer> futureTake = new FutureTask(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("futureTake");
                return new Random().nextInt();
            }
        });
        new Thread(futureTake).start();
        //阻塞返回值
        System.out.println(futureTake.get());
    }


    @Test
    public void test () {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
        FutureTask futureTask = new FutureTask(callable);

    }

}
