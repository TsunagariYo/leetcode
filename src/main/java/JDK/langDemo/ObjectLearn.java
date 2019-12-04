package JDK.langDemo;

/**
 * object类的实现
 * private static native void registerNatives();                                                                ????????????????????(JNI)
 * hashcode  获得hash值  方法
 * clone();浅拷贝
 * notify(); 唤醒线程
 * notifyAll():唤醒对象正在监听的所有线程
 * wait(long timeout);线程等待时间
 * getClass方法     非java语言写的方法
 *
 *
 * equals 方法  利用  == 实现
 * toString()  类名称+@+Integer.toHexString(hashCode()) --->toHexString(int i) --->toUnsignedString0(i, 4);--->   ????????????????
 *wait(long timeout, int nanos);
 *finalize()  已过时的方法  替代方法  AutoCloseable 接口 PhantomReference 虚引用
 *
 */
public class ObjectLearn {
    private Object object;

    public static void main(String[] args) {
    }
}
