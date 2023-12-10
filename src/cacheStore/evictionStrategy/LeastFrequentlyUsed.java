package src.cacheStore.evictionStrategy;

import src.cacheStore.CacheStore;
import src.cacheStore.domain.CacheKey;

import java.security.Key;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class LeastFrequentlyUsed implements CacheEvictionStrategy {

    @Override
    public void evict() {

    }

    /**
     * @param list
     * @param cacheStorage
     * @return
     */
    @Override
    public CacheKey evict(DoublyLinkedList list, ConcurrentHashMap cacheStorage) {
        return null;
    }

}
