package cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheConstantTimeLinkedHashMap<K, V> implements Cache<K, V> {
    private final Map<K, V> cache = new LinkedHashMap<>();
    private final int maxCacheSize;

    public LRUCacheConstantTimeLinkedHashMap(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        cache.remove(key);
        cache.put(key, value);
        if (cache.size() > maxCacheSize) {
            K oldestKey = cache.keySet().iterator().next();
            System.out.println("Removing : " + oldestKey);
            cache.remove(oldestKey);
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
        LRUCacheConstantTimeLinkedHashMap<Integer, String> cache = new LRUCacheConstantTimeLinkedHashMap<>(2);
        cache.put(0, "zero");
        cache.put(1, "one");
        cache.put(0, "zero");
        cache.put(2, "two");
    }
}
