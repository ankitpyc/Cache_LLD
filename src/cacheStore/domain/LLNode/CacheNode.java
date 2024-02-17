package src.cacheStore.domain.LLNode;

public class CacheNode<K,V> {

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
