package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class LeastFrequentlyUsed implements CacheEvictionStrategy {

    public void evict() {

    }

    /**
     * @param list
     * @param cacheStorage
     * @param
     * @return
     */
    public CacheKey evict(DoublyLinkedList list, ConcurrentHashMap cacheStorage, CacheKey key) {
        LFUDoublyLLNode headNode = (LFUDoublyLLNode) list.head;
        if (headNode != null && headNode.nodeList != null) {
            //TODO:Add impl
        }
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
