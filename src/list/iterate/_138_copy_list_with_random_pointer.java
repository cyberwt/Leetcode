package list.iterate;

import java.util.HashMap;
import java.util.Map;

/**
 * m1: 古老的一对一copy , next,random
 *
 * m2: 直接先走一遍，再动 next ,random
 *
 *  9/3/20.
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class _138_copy_list_with_random_pointer {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while(cur!=null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            if(cur.next != null){
                map.get(cur).next = map.get(cur.next);
            }
            if(cur.random != null){
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }

        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        Map<Node, Node> nodeMap = new HashMap<Node, Node>();
        return copyRandomList(head, nodeMap);
    }

    public Node copyRandomList(Node head, Map<Node, Node> nodeMap) {
        if (head == null) {
            return null;
        }
        if (nodeMap.containsKey(head)) {
            return nodeMap.get(head);
        }

        Node node = new Node(head.label);
        nodeMap.put(head, node);
        node.next = copyRandomList(head.next, nodeMap);
        node.random = copyRandomList(head.random, nodeMap);
        return node;
    }
}
