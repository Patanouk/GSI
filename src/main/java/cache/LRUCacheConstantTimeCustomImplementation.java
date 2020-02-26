package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheConstantTimeCustomImplementation<K, V> implements Cache<K, V> {
    private final Map<K, Node<K, V>> cache = new HashMap<>();
    private final int maxCacheSize;

    private Node<K, V> oldestNode = new Node<>(null, null);
    private Node<K, V> youngestNode = oldestNode;

    public LRUCacheConstantTimeCustomImplementation(int maxCacheSize) {
        this.maxCacheSize = maxCacheSize;
    }

    @Override
    public V get(K key) {
        Node<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        } else if (node == youngestNode) {
            return node.getValue();
        }

        if (node == oldestNode) {
            oldestNode = oldestNode.getNextNode();
            oldestNode.getNextNode().setPreviousNode(null);
        } else {
            node.getPreviousNode().setNextNode(node.getNextNode());
            node.getNextNode().setPreviousNode(node.getPreviousNode());
        }

        node.setPreviousNode(youngestNode);
        node.setNextNode(null);
        youngestNode.setNextNode(node);
        youngestNode = node;

        return node.value;
    }

    @Override
    public void put(K key, V value) {
        Node<K, V> node = cache.get(key);
        if (node == youngestNode) {
            return;
        }

        if (node == null) {
            node = new Node<>(key, value);
            cache.put(key, node);
        } else if (node == oldestNode) {
            oldestNode.getNextNode().setPreviousNode(null);
            oldestNode = oldestNode.getNextNode();
        } else {
            node.getNextNode().setPreviousNode(node.getPreviousNode());
            node.getPreviousNode().setNextNode(node.getNextNode());
        }

        node.setPreviousNode(youngestNode);
        youngestNode.setNextNode(node);
        youngestNode = node;

        if (cache.size() > maxCacheSize) {
            System.out.println("Removing Key : " + oldestNode.getKey());
            cache.remove(oldestNode.getKey());
            oldestNode.getNextNode().setPreviousNode(null);
            oldestNode = oldestNode.getNextNode();
        } else if (cache.size() == 1) {
            oldestNode = node;
        }
    }

    @Override
    public V remove(K key) {
        Node<K, V> removedNode = cache.remove(key);
        if (removedNode == null) {
            return null;
        }

        if (removedNode == youngestNode) {
            removedNode.getPreviousNode().setNextNode(null);
            youngestNode = removedNode.getPreviousNode();
        } else if (removedNode == oldestNode) {
            removedNode.getNextNode().setPreviousNode(null);
            oldestNode = removedNode.getNextNode();
        } else {
            removedNode.getPreviousNode().setNextNode(removedNode.getNextNode());
            removedNode.getNextNode().setPreviousNode(removedNode.getPreviousNode());
        }
        return removedNode.getValue();
    }

    @Override
    public void clear() {
        cache.clear();
        youngestNode = null;
        oldestNode = null;
    }

    private static class Node<K, V> {
        private final K currentKey;
        private final V value;

        private Node<K, V> previousNode;
        private Node<K, V> nextNode;

        public Node(K currentKey, V value) {
            this.currentKey = currentKey;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return currentKey;
        }

        public Node<K, V> getPreviousNode() {
            return previousNode;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setPreviousNode(Node<K, V> previousNode) {
            this.previousNode = previousNode;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }
    }

    public static void main(String[] args) {
        LRUCacheConstantTimeCustomImplementation<Integer, String> cache = new LRUCacheConstantTimeCustomImplementation<>(2);
        cache.put(0, "zero");
        cache.put(1, "one");
        cache.put(0, "zero");
        cache.put(2, "two");
    }
}
