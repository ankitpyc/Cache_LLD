package src.cacheStore;

import src.cacheStore.domain.Cache;
import src.cacheStore.domain.LLNode.TTLNode;
import src.cacheStore.exceptions.KeyNotExistExceptions;

import javax.xml.datatype.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TTLCache<K, V> implements Cache<K, V> {


    private Map<K, TTLNode<K, V>> cache;

    private Duration ttl;

    public TTLCache() {
        this.cache = new ConcurrentHashMap<>();
    }

    /**
     *
     */
    @Override
    public void evictCache() {

    }

    /**
     * @param key
     * @param val
     */
    @Override
    public void put(K key, V val) {
        TTLNode ttlNode = new TTLNode(Instant.now(), key, val);
        cache.put(key, ttlNode);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        if (cache.containsKey(key)) {
            if (isTTLExpired(cache.get(key), Instant.now())) {
                cache.remove(key);
                throw new KeyNotExistExceptions("Key Not Found");
            }
        }

        return (V) cache.get(key);
    }

    private boolean isTTLExpired(TTLNode<K, V> ttlNode, Instant currentTime) {
        Instant expirationTime = ttlNode.ingestionTime.plus((TemporalAmount) ttl);
        return (currentTime.isAfter(expirationTime));
    }
}
