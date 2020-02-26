package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheLinear<K, V> implements Cache<K, V> {
    private final int maxCacheSize;
    private final Map<K, ValueWithInsertionTime<V>> cache = new HashMap<>();

    public LRUCacheLinear(int maxCacheSize) {
        //TODO sanitize input
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public V get(K key) {
        return cache.get(key).getValue();
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, new ValueWithInsertionTime<>(value));
        if (cache.size() > maxCacheSize) {
            long oldestTimestamp = getCurrentTime();
            K keyToRemove = null;
            for (Map.Entry<K, ValueWithInsertionTime<V>> entry : cache.entrySet()) {
                if (entry.getValue().getTimestamp() <= oldestTimestamp) {
                    oldestTimestamp = entry.getValue().getTimestamp();
                    keyToRemove = entry.getKey();
                }
            }
            System.out.println("Removing : " + keyToRemove);
            cache.remove(keyToRemove);
        }
    }

    @Override
    public V remove(K key) {
        return cache.remove(key).getValue();
    }

    @Override
    public void clear() {
        cache.clear();
    }

    private static long getCurrentTime() {
        return System.nanoTime();
    }

    private static class ValueWithInsertionTime<V> {
        private final V value;
        private final long timestamp = getCurrentTime();

        private ValueWithInsertionTime(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }

    public static void main(String[] args) {
        LRUCacheLinear<Integer, String> cache = new LRUCacheLinear<>(2);
        cache.put(0, "zero");
        cache.put(1, "one");
        cache.put(0, "zero");
        cache.put(2, "two");
    }
}
