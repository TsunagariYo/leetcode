package Knowledge.MultiThread;

import java.util.concurrent.*;

/**
 * 线程池的demo
 *
 * 参考:https://blog.csdn.net/chinasxyjwz/article/details/78993574
 */
public class ThreadPoolDemo implements Runnable{
    private int id;
    private String name;

    public ThreadPoolDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+",id:"+this.id);
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayQueue = new ArrayBlockingQueue(10);
        LinkedBlockingQueue<Runnable> linkedQueue = new LinkedBlockingQueue();
        int count = 20;
        ExecutorService threadPool= new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, arrayQueue);
        for (int i = 0; i < count; i++) {
            ThreadPoolDemo demo = new ThreadPoolDemo(i,"name"+i);
            threadPool.execute(demo);
        }

        threadPool.shutdown();



    }
}
