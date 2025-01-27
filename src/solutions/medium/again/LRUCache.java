package solutions.medium.again;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // https://leetcode.com/problems/lru-cache/description/
    // https://www.youtube.com/watch?v=z9bJUPxzFOw&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=18
    // https://leetcode.com/problems/lru-cache/solutions/3780815/dll-map-c-java-python-beginner-friendly-excrm/
    private static class Node{
        int key, value;
        Node prev, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);

            map.remove(key);
            deleteNode(node);

            insertAfterHead(node);
            map.put(key, node);

            return node.value;
        }
        else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.remove(key);
            deleteNode(node);
        }

        // TC: capacity was full and previous block is executed then
        // when key is removed in the previous if block, we have size < capacity
        // so you can remove else
        else if (map.size() == capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }

        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
        map.put(key, newNode);
    }

    private void insertAfterHead(Node newNode){
        Node temp = head.next;

        head.next = newNode;
        newNode.next = temp;

        temp.prev = newNode;
        newNode.prev = head;
    }

    private void deleteNode(Node deleteNode){
        Node prevNode = deleteNode.prev;
        Node nextNode = deleteNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /*
    Q. why do we need to remove key from map if everytime we update the existing key?
    GPT: Now, the confusion seems to arise from the fact that m.put(key, head.next) will effectively update the
    reference to the node at the front (which is head.next). But the key part is: the node that we are trying to move to
    the front might already exist at the front of the list. This means if you don't remove the previous reference from
    the HashMap, you might overwrite the old entry in the HashMap with the same node, which can cause issues.

    Note: I tried this on paper and found that if you omit map.remove(key) then you when you do m.put(key, head.next);
    you will lose the prev pointer of new node next to head, we get temp.prev = newNode
     */
}
