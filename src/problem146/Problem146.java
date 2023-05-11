package problem146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Shawee
 * @Date 2023/5/11
 */
public class Problem146 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }
}

class LRUCache {

    private Map<Integer, Integer> cache = new LinkedHashMap<>();

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if (cache.size() < capacity) {
            cache.put(key, value);
            return;
        }
        int oldestKey = cache.keySet().iterator().next();
        cache.remove(oldestKey);
        cache.put(key, value);
    }
}
