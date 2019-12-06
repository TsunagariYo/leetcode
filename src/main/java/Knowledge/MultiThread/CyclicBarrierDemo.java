package Knowledge.MultiThread;

import java.util.Set;
import java.util.concurrent.*;


/**
 * 线程屏障demo
 * CyclicBarrier
 *
 */
public class CyclicBarrierDemo implements Runnable {
    private ExecutorService threadPool = Executors.newFixedThreadPool(3);
    private  CyclicBarrier cb = new CyclicBarrier(3,this);
    private ConcurrentHashMap<String,Double> map = new ConcurrentHashMap<String,Double>();

    public void count(){
        for (int i = 0;i <3;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    double score = Math.random() * 40 + 60;
                    System.out.println(score);
                    map.put(Thread.currentThread().getName(),score);
                    System.out.println(Thread.currentThread().getName()+"同学的平均成绩为"+score);
                    try {
                        cb.await();
                    } catch (InterruptedException  | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }
    @Override
    public void run() {
        int result = 0;
        Set<String> set = map.keySet();
        for (String s : set) {
            result+=map.get(s);
        }
        System.out.println("三人平均成绩为:"+(result/3)+"分");
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        demo.count();
        demo.threadPool.shutdown();
    }
}
