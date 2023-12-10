package src.cacheStore.evictionStrategy;

import src.cacheStore.CacheStore;
import src.cacheStore.domain.CacheKey;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class LeastRecentlyUsed implements CacheEvictionStrategy {

    DoublyLinkedList doublyLinkedList;

    CacheStore cacheStore;


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
