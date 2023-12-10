package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;

public class DLLNode<Key extends CacheKey> {
    DLLNode<Key> next, prev;
    Key key;
}
