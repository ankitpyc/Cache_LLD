package src;

import src.cacheStore.CacheFactory.CacheFactory;
import src.cacheStore.domain.Cache;
import src.cacheStore.domain.CacheType;

public class Main {
    public static void main(String[] args) {
        Cache cache = CacheFactory.getCache(CacheType.LFU,5);
        cache.put(1,"ANKIT");
    }
}