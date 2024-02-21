package src.cacheStore.domain.LLNode;

import java.util.Observable;

public class CacheNode<K,V> extends Observable {

    public K key;

    public V value;
    public CacheNode<K,V> next,prev;

    public CacheNode(K key,V value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
