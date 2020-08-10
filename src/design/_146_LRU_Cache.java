package design;

import java.util.Hashtable;

/**
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

    class LRUCache {

        private class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
        }

        /**
         * Always add the new node right after head;
         */
        private void addNode(DLinkedNode node) {

            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;
        }

        /**
         * Remove an existing node from the linked list.
         */
        private void removeNode(DLinkedNode node){
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;

            pre.post = post;
            post.pre = pre;
        }

        /**
         * Move certain node in between to the head.
         */
        private void moveToHead(DLinkedNode node){
            this.removeNode(node);
            this.addNode(node);
        }

        // pop the current tail.
        private DLinkedNode popTail(){
            DLinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }

        private Hashtable<Integer, DLinkedNode>
                cache = new Hashtable<Integer, DLinkedNode>();
        private int count;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            head.pre = null;

            tail = new DLinkedNode();
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {

            DLinkedNode node = cache.get(key);
            if(node == null){
                return -1; // should raise exception here.
            }

            // move the accessed node to the head;
            this.moveToHead(node);

            return node.value;
        }


        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if(node == null){

                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                this.cache.put(key, newNode);
                this.addNode(newNode);

                ++count;

                if(count > capacity){
                    // pop the tail
                    DLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    --count;
                }
            }else{
                // update the value.
                node.value = value;
                this.moveToHead(node);
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

