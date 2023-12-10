package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;

public class DoublyLinkedListNode<Key extends CacheKey> {
    DoublyLinkedListNode<Key> next, prev;
    Key key;

    public DoublyLinkedListNode(Key k) {
        this.key = k;
        this.next = null;
        this.prev = null;
    }
}
