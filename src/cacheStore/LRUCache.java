package src.cacheStore;


import src.cacheStore.domain.Cache;
import src.cacheStore.domain.LLNode.CacheNode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> implements Cache<K, V> {

    private int capacity;

    private Map<K, CacheNode<K,V>> cache;

    private CacheNode<K,V> head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<K, CacheNode<K,V>>();
        this.head = null;
        this.tail = null;
    }

    private void addNode(CacheNode node) {
        node.prev = head;
        node.next = head.next;
        head.prev.prev = node;
        head.next = node;
    }

    private void removeNode(CacheNode node) {
        CacheNode pre = node.prev;
        CacheNode post = node.next;

        pre.next = post;
        post.prev = pre;
    }

    public void evictCache() {

    }

    /**
     * @param key
     * @param val
     */
    public void put(K key, V val) {

    }

    /**
     * @param key
     */
    public V get(K key) {
        return null;
    }
}
