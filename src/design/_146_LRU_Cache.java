package design;

import java.util.HashMap;

/**
 *
 * >  LRU 基本属性 ：head, tail, map, size, capacity
 *    Node: key, value, pre,nexy
 *
 * > addHead, remove 放 int key, int value, instead of Node
 * 因为node毕竟是构造函数
 * > 别忘了map.remove(key)
 * > 在构造时， addHead, remove 进行size++ or size--
 *
 *
 *
 *
 *
 * 4/4
 * --
 *
 * // this.vairable  this.function for the calss property
 * // hashtable  vd hashmap
 *
 * If a thread-safe implementation is not needed, it is recommended to use HashMap in place of Hashtable.
 * If a thread-safe highly-concurrent implementation is desired, recommended to use java.util.concurrent.ConcurrentHashMap in place of Hashtable
 *
 * function variable:
 * capacity, count, hashmap, head, tail
 * DLinkedList: addNode, removeNode, moveToHead(include remove), removeTail
 * 本身 function put, get
 *
 * get - moveToHead
 *
 * put - contains (update) else add & check not overflow
 *
 * T:O(1) S:O(N)
 *
 * 8/9/20.
 */
public class _146_LRU_Cache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;
    int size;
    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(key);
            addHead(key, node.val);
            return node.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
            addHead(key, value);
        } else {
            addHead(key, value);
        }
    }

    private void remove(int key) {
        Node cur = map.get(key);
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
        size--;
        map.remove(key);
    }

    private void addHead(int key, int val) {
        Node node = new Node(key, val);
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        map.put(key, node);
        size++;
        if (size > capacity) {
            Node preTail = tail.prev;
            remove(preTail.key);
        }
    }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}

