package src.cacheStore;

import src.cacheStore.domain.CacheKey;
import src.cacheStore.evictionStrategy.CacheEvictionStrategy;
import src.cacheStore.evictionStrategy.DoublyLinkedList;
import src.cacheStore.evictionStrategy.DoublyLinkedListNode;
import src.cacheStore.exceptions.DuplicateKeyExceptions;
import src.cacheStore.exceptions.KeyNotExistExceptions;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This is the cache Store
 */

public class CacheStore<Key extends CacheKey> {
    ConcurrentHashMap<Key, DoublyLinkedListNode<Key>> cacheStorage;
    CacheEvictionStrategy cacheEvictionStrategy;
    DoublyLinkedList<Key> list;

    int cacheCapacity = 5;

    public CacheStore(CacheEvictionStrategy evictionStrategy, int cacheCapacity) {
        this.cacheStorage = new ConcurrentHashMap<Key, DoublyLinkedListNode<Key>>();
        this.cacheEvictionStrategy = evictionStrategy;
        this.cacheCapacity = cacheCapacity;
        this.list = new DoublyLinkedList<Key>(cacheCapacity);
    }

    public Boolean putKey(Key key) {
        if (!cacheStorage.containsKey(key)) {
            if (cacheCapacity == cacheStorage.size()) {
                evictKey(key);
            }
            DoublyLinkedListNode newNode = list.addNodeToList(key);
            cacheStorage.put(key, newNode);
        }
        throw new DuplicateKeyExceptions("The Key Already exsists in the cache");
    }


    /**
     * This is the cache Store
     */
    public Boolean getKey(Key key) {
        if (!cacheStorage.containsKey(key)) {
            throw new KeyNotExistExceptions("The Key Already Exsist in the cache");
        }
        DoublyLinkedListNode node = cacheStorage.get(key);
        list.referKey(node);
        return cacheStorage.containsKey(key);
    }

    private void evictKey(Key key) {
        cacheEvictionStrategy.evict(list, cacheStorage);
        cacheStorage.remove(key);
    }

}
