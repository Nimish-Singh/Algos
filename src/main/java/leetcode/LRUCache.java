package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private final CacheNode head = new CacheNode(), tail = new CacheNode();
    private Map<Integer, CacheNode> nodeMap;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        nodeMap = new HashMap<>(this.capacity);
    }

    public int get(int key) {
        CacheNode node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            addAtHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        CacheNode node = nodeMap.get(key);
        if (node != null) {
            remove(node);
            node.value = value;
            addAtHead(node);
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }

            CacheNode newNode = new CacheNode();
            newNode.key = key;
            newNode.value = value;
            nodeMap.put(key, newNode);
            addAtHead(newNode);
        }
    }

    private void addAtHead(CacheNode node) {
        CacheNode headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(CacheNode node) {
        CacheNode previous = node.prev;
        CacheNode next = node.next;

        previous.next = next;
        next.prev = previous;
    }
}

class CacheNode {
    int key, value;
    CacheNode next, prev;
}
