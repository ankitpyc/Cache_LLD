package src.cacheStore.evictionStrategy;

import src.cacheStore.CacheStore;
import src.cacheStore.domain.CacheKey;

import java.util.concurrent.ConcurrentHashMap;

public interface CacheEvictionStrategy<Key extends CacheKey> {


    void evict();

    Key evict(DoublyLinkedList<Key> list, ConcurrentHashMap<Key, DoublyLinkedListNode<Key>> cacheStorage);
}
