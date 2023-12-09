package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;
import src.cacheStore.domain.CacheValue;

public class DoublyLinkedListNode<Key extends CacheKey, Value extends CacheValue> {
    DoublyLinkedList next, prev;
    Key key;

    public DoublyLinkedListNode(Key k) {
        this.key = k;
        this.next = null;
        this.prev = null;
    }
}
