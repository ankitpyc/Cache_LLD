package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;
import src.cacheStore.domain.CacheValue;

import java.security.Key;


public class DoublyLinkedList<Key extends CacheKey, Value extends CacheValue> {

    DoublyLinkedListNode<Key, Value> head, tail;
    CacheEvictionStrategy cacheEvictionStrategy;
    int capacity;

    public DoublyLinkedList(Key k, int capacity) {
        this.head = null;
        this.tail = null;
        this.capacity = capacity;
    }

    public void addNodeToList(Key k) {
        if (cacheEvictionStrategy instanceof LeastFrequentlyUsed) {

        }
    }
}
