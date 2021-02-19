/*

Sample Input:
put India 135
put Australia 5
put Canada 3
display
get China
remove Australia
get Australia
containsKey USA
put USA 10
put UK 20
remove USA
containsKey USA
put Spain 80
display
put Nigeria 3
put India 138
display
quit

Sample Output:
Display Begins
Bucket0 Australia@5 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 Spain@80 .
Bucket2 Canada@3 UK@20 .
Bucket3 India@135 .
Display Ends
Display Begins
Bucket0 .
Bucket1 Spain@80 .
Bucket2 Canada@3 UK@20 .
Bucket3 India@138 Nigeria@3 .
Display Ends

*/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

class HashMap<K, V> {

  /* HashMap Node */

  private class HashMapNode {
    K key;
    V value;

    HashMapNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  /* Data Members: */

  private LinkedList<HashMapNode> buckets[]; // use ArrayList for better type-safety
  private int size;

  /* Constructor: */

  public HashMap() {
    initBuckets(4);
    size = 0;
  }

  /* Utils: */

  @SuppressWarnings("unchecked") // ignore unchecked warnings
  private void initBuckets(int capacity) {
    buckets = new LinkedList[capacity]; // this will give a type-safety warning
    for (int i = 0; i < capacity; i++) {
      buckets[i] = new LinkedList<>();
    }
  }

  // to generate & fetch bucket index
  private int hashFunction(K key) {
    int hashCode = key.hashCode(); // in-built function in Java
    int bucketIndex = Math.abs(hashCode) % buckets.length; // bucket index should lie in range: 0 - buckets.length
    return bucketIndex;
  }

  // find the data index of value in bucket
  private int findKeyInGivenBucket(K key, int bucketIndex) {
    int dataIndex = 0;

    for (HashMapNode node : buckets[bucketIndex]) {
      if (node.key.equals(key)) {
        return dataIndex;
      }
      dataIndex++;
    }

    return -1;
  }

  private void rehashing() {
    // store the old bucket in an array
    LinkedList<HashMapNode>[] oldBuckets = buckets;

    // create a new bucket of size double than the old bucket
    initBuckets(2 * oldBuckets.length);
    size = 0;

    // store the value of oldbucket in the new bucket
    for (LinkedList<HashMapNode> bucket : oldBuckets) {
      for (HashMapNode node : bucket) {
        put(node.key, node.value);
      }
    }
  }

  /* HashMap Methods: */

  public int size() {
    return size;
  }

  public void put(K key, V value) {
    int bucketIndex = hashFunction(key);
    int dataIndex = findKeyInGivenBucket(key, bucketIndex);

    if (dataIndex != -1) {
      // if key exists, update the value
      HashMapNode node = buckets[bucketIndex].get(dataIndex);
      node.value = value;
    } else {
      // if key doesn't exists, insert the value
      HashMapNode node = new HashMapNode(key, value);
      buckets[bucketIndex].addLast(node);
      size++;
    }

    double lambda = (size * 1.0) / buckets.length; // λ = noOfElements / noOfBuckets
    if (lambda > 2.0) {
      rehashing();
    }
  }

  public V get(K key) {
    int bucketIndex = hashFunction(key);
    int dataIndex = findKeyInGivenBucket(key, bucketIndex);

    if (dataIndex != -1) {
      HashMapNode node = buckets[bucketIndex].get(dataIndex);
      return node.value;
    } else {
      return null;
    }
  }

  public boolean containsKey(K key) {
    int bucketIndex = hashFunction(key);
    int dataIndex = findKeyInGivenBucket(key, bucketIndex);

    if (dataIndex != -1) {
      return true;
    } else {
      return false;
    }
  }

  public V remove(K key) {
    int bucketIndex = hashFunction(key);
    int dataIndex = findKeyInGivenBucket(key, bucketIndex);

    if (dataIndex != -1) {
      HashMapNode node = buckets[bucketIndex].remove(dataIndex);
      size--;
      return node.value;
    } else {
      return null;
    }
  }

  public ArrayList<K> keyset() {
    ArrayList<K> keys = new ArrayList<>();

    for (LinkedList<HashMapNode> bucket : buckets) {
      for (HashMapNode node : bucket) {
        keys.add(node.key);
      }
    }

    return keys;
  }

  public void display() {
    System.out.println("Display Begins");

    for (int bi = 0; bi < buckets.length; bi++) {
      System.out.print("Bucket" + bi + " ");

      for (HashMapNode node : buckets[bi]) {
        System.out.print(node.key + "@" + node.value + " ");
      }
      System.out.println(".");
    }

    System.out.println("Display Ends");
  }
}

public class Main {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    HashMap<String, Integer> map = new HashMap<>();

    String str = s.nextLine();
    while (!str.equals("quit")) {
      if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = s.nextLine();
    }
  }

}
