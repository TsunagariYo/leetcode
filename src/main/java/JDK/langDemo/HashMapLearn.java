package JDK.langDemo;

import java.util.HashMap;

/**
 * hashMap继承AbstractMap(抽象类) ---->Map(接口)
 * Node内部类 实现Map.Entry接口   有equals方法和setValue 方法
 *静态变量
 *      DEFAULT_INITIAL_CAPACITY  初始的容量16
 *      MAXIMUM_CAPACITY         最大的容量   2^30
 *      DEFAULT_LOAD_FACTOR     负载因子    0.75
 *      TREEIFY_THRESHOLD       链表转成红黑树的阈值，当链表长度> 该值时，则将链表转换成红黑树8
 *      UNTREEIFY_THRESHOLD     当原有的红黑树内节点数量 < 6时，则将 红黑树转换成链表6
 *      MIN_TREEIFY_CAPACITY    当哈希表中的容量 > 64时，才允许链表转化为红黑树,否则进行扩容risize()
 *
 * 不可序列化的成员变量
 *      transient Node<K,V>[] table;            储存元素的的数组,长度始终是2的幂
 *      transient Set<Map.Entry<K,V>> entrySet;     保存缓存的
 *      transient int size;                键值对的数量
 *      transient int modCount;            HashMap结构修改次数
 * 成员变量
 *      int threshold;           阀值(为初始化的容量)
 *      float loadFactor;        哈希表的负载因子。
 *
 *构造方法:
 *      ①参数(int initialCapacity(注:通过tableSizeFor方法赋值给threshold), float loadFactor)
 *      ②参数(int initialCapacity)  使用默认的DEFAULT_LOAD_FACTOR
 *      ③参数(Map<? extends K, ? extends V> m)  构造一个新的 HashMap具有与指定的相同的映射 Map   通过putMapEntries方法  复制另一个map     ?????????????????
 *
 *
 *
 *
 *
 * 静态方法
 *      hash            计算key的hashcode
 *      comparableClassFor(object o)      当他实现Comparable<O>接口且比较的参数是他本身返回 class O的类型
 *      compareComparables(Class<?> kc, Object k, Object x) 判断x是否是kc类型的,不是的话比较K和x
 *      tableSizeFor(int cap)    将参数转化为其对应的最大的2^n次方数                            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *
 *
 *
 *
 *
 *
 */
public class HashMapLearn {
    static HashMap hashMap;

    public static void main(String[] args) {

    }
}
