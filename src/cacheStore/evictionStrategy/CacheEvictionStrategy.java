package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;

import java.util.concurrent.ConcurrentHashMap;

public interface CacheEvictionStrategy<Key extends CacheKey> {


    void evict();

    Key evict(DoublyLinkedList<Key> list, ConcurrentHashMap<Key, LRUDoublyLLNode<Key>> cacheStorage, Key k);
}
