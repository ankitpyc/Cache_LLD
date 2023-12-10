package src.cacheStore.evictionStrategy;

import src.cacheStore.domain.CacheKey;
import sun.jvm.hotspot.debugger.windbg.DLL;

public class LFUDoublyLLNode<Key extends CacheKey> extends DLLNode {
    public DLLNode<Key> nodeList;

    public LFUDoublyLLNode(Key k) {
        this.key = k;
        this.next = null;
        this.prev = null;
        this.nodeList = null;
    }
}
