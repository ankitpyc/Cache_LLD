package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class LeastRecentlyUsed implements CacheEvictionStrategy {

    public void evict() {

    }

    /**
     * @param list
     * @param cacheStorage
     * @param
     * @return
     */
    public CacheKey evict(DoublyLinkedList list, ConcurrentHashMap cacheStorage, CacheKey key) {
        LRUDoublyLLNode node = (LRUDoublyLLNode) cacheStorage.get(key);
        removeNodeFromCache(list, node);
        return key;
    }

    private void removeNodeFromCache(DoublyLinkedList list, LRUDoublyLLNode node) {
        DLLNode prevNode, nextNode;
        prevNode = node.prev;
        nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        node = null;
    }

}
