package JDK.util;


import javax.xml.transform.Source;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * UUID
 * <p>
 * 成员变量
 * mostSigBits     指定长度最大为64bits
 * leastSigBits    指定长度最大为64bits
 * <p>
 * 构造方法:
 *      ①参数为byte[] data  私有的
 * <p>
 * <p>
 * 内部类
 * Holder:   放入SecureRandom对象
 * 静态方法:
 */
public class UUIDLearn {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        byte[] bytes={};
        Class<UUID> uuidClass = UUID.class;
        Constructor<UUID> c1 = uuidClass.getDeclaredConstructor(byte.class);
        c1.setAccessible(true);
        UUID uuid = c1.newInstance(bytes);

    }

}
