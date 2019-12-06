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
 * 内部方法
 *      hash    计算key的hashcode
 *      comparableClassFor(object o)      当他实现Comparable<O>接口且比较的参数是他本身返回 class O的类型
 *      compareComparables(Class<?> kc, Object k, Object x) 判断x是否是kc类型的,不是的话比较K和x
 *      tableSizeFor(int cap)    将参数转化为其对应的最大的2^n次方数                            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *      resize() 扩容方法   如果开始为空扩容到16 阀值为0.75*16=12,不为空 新阀值为老阀值*2,新容量也为老容量的2倍,如果容量超过2^30 则为设置为int的最大值
 *      treeifyBin(Node<K,V>[] tab, int hash) 当链表的长度大于8时候转化为红黑树   ?????????????????????????
 *
 *
 *
 * 方法
 *      size()判断键值对的数量
 *      isEmpty()判断是否为空
 *      get(Object key) 通过key找Value   通过getNode(int hash,Object key)方法实现
 *      containsKey(Object key)   是否包含key
 *      put(key,value)      通过putVal(int hash, K key, V value, boolean onlyIfAbsent(true是不改变已经存在的key值对应的value值),boolean evict)方法 \
 *                          (n - 1) & hash除法散列法  为了让散列的结果更加的均匀
 *                          讲解链接:https://blog.csdn.net/AJ1101/article/details/79413939
 *
 *
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
