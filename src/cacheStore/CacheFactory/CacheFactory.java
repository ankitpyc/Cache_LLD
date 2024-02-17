package src.cacheStore.CacheFactory;


import src.cacheStore.LFUCache;
import src.cacheStore.LRUCache;
import src.cacheStore.domain.Cache;
import src.cacheStore.domain.CacheType;

public class CacheFactory<K,V> {

    public Cache getCache(CacheType cacheType, int capacity){
        switch (cacheType){
            case LFU:
                 return new LRUCache<K,V>(capacity);
            case LRU:
                return new LFUCache<K,V>(capacity);
            default:
                throw new RuntimeException();
        }
    }
}
