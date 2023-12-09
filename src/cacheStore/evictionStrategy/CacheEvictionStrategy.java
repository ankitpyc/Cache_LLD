package src.cacheStore.evictionStrategy;

public interface CacheEvictionStrategy {
  public void evict(DoublyLinkedList list);

  void evict();
}
