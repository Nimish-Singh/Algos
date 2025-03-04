package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/all-oone-data-structure/
public class AllOne {
    private Map<String, Node> map;
    private Node head;
    private Node tail;

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.keys.remove(key);

            if (node.next.freq != node.freq + 1) {
                Node newNode = new Node(node.freq + 1);
                newNode.keys.add(key);

                newNode.next = node.next;
                node.next.prev = newNode;
                node.next = newNode;
                newNode.prev = node;

                map.put(key, newNode);
            } else {
                node.next.keys.add(key);
                map.put(key, node.next);
            }

            if (node.keys.isEmpty())
                removeNode(node);

            return;
        }

        if (head.next == tail || head.next.freq != 1) {
            Node node = new Node(1);
            node.keys.add(key);
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;

            map.put(key, node);
        } else {
            head.next.keys.add(key);
            map.put(key, head.next);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key))
            return;

        Node node = map.get(key);
        node.keys.remove(key);

        if (node.freq == 1) {
            map.remove(key);
        } else {
            if (node.prev.freq != node.freq - 1) {
                Node newNode = new Node(node.freq - 1);
                newNode.keys.add(key);

                newNode.next = node;
                newNode.prev = node.prev;
                node.prev.next = newNode;
                node.prev = newNode;

                map.put(key, newNode);
            } else {
                node.prev.keys.add(key);
                map.put(key, node.prev);
            }
        }

        if (node.keys.isEmpty())
            removeNode(node);
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node oldPrev = node.prev;
        Node oldNext = node.next;

        oldNext.prev = oldPrev;
        oldPrev.next = oldNext;

        node.next = node.prev = null;
    }

    class Node {
        Set<String> keys; // because there can be multiple elements with the same frequency
        int freq;
        Node prev;
        Node next;

        public Node(int freq) {
            keys = new HashSet<>();
            this.freq = freq;
            prev = next = null;
        }
    }
}

