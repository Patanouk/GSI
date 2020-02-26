package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstInFirstOutCache<K, V> implements Cache<K, V> {
    private final int maxCacheSize;
    private final Map<K, V> cache = new LinkedHashMap<>();

    public FirstInFirstOutCache(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
        if (cache.size() > maxCacheSize) {
            K next = cache.keySet().iterator().next();
            System.out.println("Removing : " + next);
            cache.remove(cache.keySet().iterator().next());
        }
    }

    @Override
    public V remove(K key) {
        return cache.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    public static void main(String[] args) {
        FirstInFirstOutCache<Integer, String> cache = new FirstInFirstOutCache<>(1);
        cache.put(0, "zero");
        cache.put(1, "one");
        cache.put(0, "zero");
        cache.put(2, "two");
    }
}
