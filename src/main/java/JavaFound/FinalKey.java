package JavaFound;

import java.util.Random;

/**
 * final 关键字
 *
 * static final 为不可修改
 * final 修饰对象时 是 不更改对象的引用地址
 * 类中的private方法都隐式的指向final
 *
 *
 * 初始化顺序: 父类静态成员变量 --> 子类的静态成员变量 -- >  (类加载之前完成,可能优先于前一句代码) --> 父类成员变量 --> 父类构造方法 -->子类成员变量  --> 子类成员方法
 */
class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}

public class FinalKey {
    private static Random rand = new Random(47);
    private String id;

    public FinalKey(String id) {
        this.id = id;
    }

    private final int Value_One = 9;
    private static final int Value_TWO = 99;
    public static final int Value_Three = 39;
    private final int Value_Four = rand.nextInt(20);
    static final int Value_Five = rand.nextInt(20);

    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value v3 =new Value(33);

    private final int [] a = {1,2,3,4,5,6};

    @Override
    public String toString() {
        return id + ":  Value_Four = "+Value_Four+","+"Value_Five = "+Value_Five;
    }

    public static void main(String[] args) {
        FinalKey key = new FinalKey("FD1");
        key.v2.i++;
        key.v1 = new Value(9);
        for (int i = 0; i < key.a.length; i++) {
            key.a[i] ++ ;
        }

        System.out.println(key);
        System.out.println("create FinalKey");
        FinalKey key2 = new FinalKey("FD2");
        System.out.println(key);
        System.out.println(key2);
    }
}
