package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private final Node head = new Node(), tail = new Node();
    private Map<Integer, Node> nodeMap;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>(this.capacity);
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            addAtHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            addAtHead(node);
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            nodeMap.put(key, newNode);
            addAtHead(newNode);
        }
    }

    private void addAtHead(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }
}

class Node {
    int key, value;
    Node next, prev;
}
