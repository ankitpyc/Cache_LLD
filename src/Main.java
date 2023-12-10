package src;

import src.cacheStore.CacheStore;
import src.cacheStore.domain.CacheKey;
import src.cacheStore.domain.StringCacheKey;
import src.cacheStore.evictionStrategy.LeastRecentlyUsed;

public class Main {
    public static void main(String[] args) {
        StringCacheKey cacheKey = new StringCacheKey();
        cacheKey.c = "";
        System.out.println("Cache Application Started");
        CacheStore cacheStore = new CacheStore(new LeastRecentlyUsed(), 3);
    }

}