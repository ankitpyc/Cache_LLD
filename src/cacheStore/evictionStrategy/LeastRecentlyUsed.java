package src.cacheStore.evictionStrategy;

public class LeastRecentlyUsed implements CacheEvictionStrategy {

    DoublyLinkedList doublyLinkedList;

    @Override
    public void evict(DoublyLinkedList list) {
        list.removeNode(list.tail);
    }

    @Override
    public void evict() {

    }
}
