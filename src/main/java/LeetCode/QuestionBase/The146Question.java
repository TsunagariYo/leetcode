package LeetCode.QuestionBase;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存机制
 */
public class The146Question extends LinkedHashMap<Integer, Integer> {
    //容量
    private int capacity;

    //linkedhashMap的构造方法
    public The146Question(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }



}
