package src.cacheStore.domain.LLNode;

public class LFUCacheNode<K,V> extends CacheNode<K,V>{
    public int freq;
    public LFUCacheNode(K key,V val,int freq) {
        super(key,val);
        this.freq = freq;
    }
}
