package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;

public class LRUDoublyLLNode<Key extends CacheKey> extends DLLNode {
    DLLNode<Key> next, prev;
    Key key;

    public LRUDoublyLLNode(Key k) {
        this.key = k;
        this.next = null;
        this.prev = null;
    }
}
