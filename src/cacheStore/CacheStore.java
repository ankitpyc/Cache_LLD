package src.cacheStore;

import src.cacheStore.domain.CacheKey;
import src.cacheStore.evictionStrategy.CacheEvictionStrategy;
import src.cacheStore.evictionStrategy.DoublyLinkedList;
import src.cacheStore.evictionStrategy.DoublyLinkedListNode;
import src.cacheStore.exceptions.DuplicateKeyExceptions;

import java.util.HashMap;
import java.util.Map;

public class CacheStore<Key extends CacheKey> {
    Map<Key, DoublyLinkedListNode<Key>> cacheStore;
    CacheEvictionStrategy cacheEvictionStrategy;

    DoublyLinkedList<Key> list;

    int cacheCapacity = 5;

    public CacheStore(CacheEvictionStrategy evictionStrategy, int cacheCapacity) {
        this.cacheStore = new HashMap<Key, DoublyLinkedListNode<Key>>();
        this.cacheEvictionStrategy = evictionStrategy;
        this.cacheCapacity = cacheCapacity;
        this.list = new DoublyLinkedList<Key>(cacheCapacity);
    }

    public Boolean putKey(Key key) {
        //TODO:Add implement for inserting key
        if (!cacheStore.containsKey(key)) {
            if (cacheCapacity == cacheStore.size()) {
                cacheEvictionStrategy.evict(list);
                cacheStore.remove(key);
            }
            DoublyLinkedListNode newNode = list.addNodeToList(key);
            cacheStore.put(key, newNode);
        }
        throw new DuplicateKeyExceptions("The Key Already exsists in the cache");
    }


    public Key getKey(Key key) {
        //TODO:Add implement for inserting key
        if (!cacheStore.containsKey(key)) {

        }
        throw new DuplicateKeyExceptions("The Key Already Exsist in the cache");
    }

}
