package src.cacheStore.domain;

public interface Cache<K,V> {

    void evictCache();

    void put(K key,V val);

    V get(K key);

}
