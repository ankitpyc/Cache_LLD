package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;


public class DoublyLinkedList<Key extends CacheKey> {

    DLLNode<Key> head, tail;
    CacheEvictionStrategy cacheEvictionStrategy;

    public DoublyLinkedList(int capacity) {
        this.head = null;
        this.tail = null;
    }

    //TODO:Add implementation
    public LRUDoublyLLNode addNodeToList(Key k) {
        return null;
    }

    public LRUDoublyLLNode removeNode(LRUDoublyLLNode node) {
        node.prev.next = null;
        node.next = null;
        node.prev = null;
        return node;
    }

    public void referKey(DLLNode<Key> node) {
        DLLNode temp = null;
        //Remove if node is a tail ref
        if (tail == node && tail.prev != null) {
            temp = node.prev;
            node.prev = null;
            tail = temp;
        }
        //Transfer the node to most referenced to head
        node.prev = head;
        head.next = node;
        head = node;
    }
}
