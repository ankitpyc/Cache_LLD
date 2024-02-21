package src.cacheStore.CacheFactory;


import src.cacheStore.LFUCache;
import src.cacheStore.LRUCache;
import src.cacheStore.TTLCache;
import src.cacheStore.domain.Cache;
import src.cacheStore.domain.CacheType;

public class CacheFactory {

    public static  <K,V> Cache<K,V>  getCache(CacheType cacheType, int capacity){
        switch (cacheType){
            case LFU:
                 return new LRUCache<K,V>(capacity);
            case LRU:
                return new LFUCache<K,V>(capacity);
            case TTL:
                return new TTLCache<K,V>();
            default:
                throw new RuntimeException();
        }
    }
}
