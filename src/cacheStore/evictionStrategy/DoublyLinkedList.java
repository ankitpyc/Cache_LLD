package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;
import src.cacheStore.domain.CacheValue;


public class DoublyLinkedList<Key extends CacheKey, Value extends CacheValue> {

    DoublyLinkedList next,prev;
    Key key;

}
