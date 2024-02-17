package src.cacheStore;


import src.cacheStore.domain.Cache;
import src.cacheStore.domain.LLNode.LFUCacheNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LFUCache<K, V> implements Cache<K, V> {

    private int capacity;
    private Map<K, LFUCacheNode<K,V>> cache;

    private Map<Integer, LFUCacheNode<K,V>> freqCache;
    private int minFre;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<K, LFUCacheNode<K,V>>();
        this.freqCache = new HashMap<Integer, LFUCacheNode<K,V>>();
        this.minFre = 1;
    }

    /**
     *
     */

    public void evictCache() {
        LFUCacheNode tail = freqCache.get(minFre);
        cache.remove(tail.key);
        if (tail.prev == null && tail.next == null){
            freqCache.remove(minFre);
            minFre = minFre + 1;
            return;
        }
        LFUCacheNode prevNode = (LFUCacheNode) tail.prev;
        LFUCacheNode nextNode = (LFUCacheNode) tail.next;
        if (prevNode != null){
            prevNode.next = nextNode;
        }

        if (nextNode != null){
            prevNode.next = nextNode;
        }
    }

    /**
     * @param key
     * @param val
     */
    public void put(K key, V val) {
        if(cache.size() == capacity){
            evictCache();
        }
        if (!cache.containsKey(key)) {
            LFUCacheNode node = cache.get(key);
            node.value = val;
        } else {
            LFUCacheNode node = new LFUCacheNode<K,V>(key,val,1);
            cache.put(key, node);
            freqCache.put(1, node);
        }
    }

    private void addToNode(int i, LFUCacheNode node) {
        LFUCacheNode<K,V> tail = freqCache.get(i);
        tail.next = node;
        node.prev = tail;
        tail = node;
        freqCache.put(i,tail);
    }

    /**
     * @param key
     */
    public V get(K key) {
        LFUCacheNode node = cache.get(key);
        updateFrequency(node);
        return (V) cache.get(node.key);
    }

    private void updateFrequency(LFUCacheNode node) {
         LFUCacheNode prevNode = (LFUCacheNode) node.prev;
         LFUCacheNode nextNode = (LFUCacheNode) node.next;
         if(prevNode != null){
             prevNode.next = nextNode;
         }
        if(nextNode != null){
            nextNode.prev = prevNode;
        }
        node.freq = node.freq+1;
        if(!freqCache.containsKey(node.freq)){
            freqCache.put(node.freq,node);
        } else {
            addToNode(node.freq,node);
        }
        cache.put((K) node.key,node);
    }
}
