package src.cacheStore;

import src.cacheStore.domain.CacheKey;
import src.cacheStore.domain.CacheValue;
import src.cacheStore.evictionStrategy.CacheEvictionStrategy;

import java.util.HashMap;
import java.util.Map;

public class CacheStore<Key extends CacheKey, Value extends CacheValue> {
    Map<Key, Value> cacheStore;
    CacheEvictionStrategy cacheEvictionStrategy;

    int cacheCapacity = 5;

    public CacheStore(CacheEvictionStrategy evictionStrategy, int cacheCapacity) {
        this.cacheStore = new HashMap<Key, Value>();
        this.cacheEvictionStrategy = evictionStrategy;
        this.cacheCapacity = cacheCapacity;
    }

}
