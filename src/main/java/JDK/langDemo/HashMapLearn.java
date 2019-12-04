package JDK.langDemo;

import java.util.HashMap;

/**
 * hashMap继承AbstractMap(抽象类) ---->Map(接口)
 *静态变量
 *      DEFAULT_INITIAL_CAPACITY  初始的容量16
 *      MAXIMUM_CAPACITY        最大的容量   2^30
 *      DEFAULT_LOAD_FACTOR     负载因子    0.75
 *      TREEIFY_THRESHOLD       链表转成红黑树的阈值，当链表长度> 该值时，则将链表转换成红黑树8
 *      UNTREEIFY_THRESHOLD     当原有的红黑树内节点数量 < 6时，则将 红黑树转换成链表6
 *      MIN_TREEIFY_CAPACITY    当哈希表中的容量 > 64时，才允许链表转化为红黑树,否则进行扩容risize()
 *
 *
 */
public class HashMapLearn {
    HashMap hashMap;
}
