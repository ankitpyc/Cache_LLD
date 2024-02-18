package src.cacheStore.domain.LLNode;

import lombok.Builder;
import lombok.Data;

import javax.xml.datatype.Duration;
import java.time.Instant;

@Data
@Builder
public class TTLNode<K,V>  {
 public Instant ingestionTime;
 public K key;
 public V value;

 public TTLNode(Instant ingestionTime, K key, V value) {
  this.ingestionTime = ingestionTime;
  this.key = key;
  this.value = value;
 }
}
