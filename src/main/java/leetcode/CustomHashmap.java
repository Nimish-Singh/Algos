package leetcode;

import java.util.Optional;

public class CustomHashmap {
    private int capacity;
    private Node[] buckets;
    private int size; // Optional- only for capacity exceed checks

    public CustomHashmap(int capacity) {
        this.capacity = capacity;
        buckets = new Node[this.capacity];
        size = 0;
    }

    public void put(int key, int value) {
        int bucketIndex = getIndex(key);
        Node existingNode = find(key, bucketIndex);
        if (existingNode != null) {
            existingNode.value = value;
            return;
        }

        if (size == capacity) {
            throw new RuntimeException("capacity exceeded");
        }

        if (buckets[bucketIndex] == null) {
            Node node = new Node(key, value);
            buckets[bucketIndex] = node;
            size++;
            return;
        }

        Node newNode = new Node(key, value);
        Node node = buckets[bucketIndex];
        while (node.next != null) {
            node = node.next;
        }
        node.next = newNode;
        size++;
    }

    public Optional<Integer> get(int key) {
        int bucketIndex = getIndex(key);
        Node node = find(key, bucketIndex);
        if (node == null) {
            return Optional.empty();
        }
        return Optional.of(node.value);
    }

    public void remove(int key) {
        int bucketIndex = getIndex(key);
        if (buckets[bucketIndex] == null) {
            return;
        }
        Node previous = null, current = buckets[bucketIndex];

        while (current != null) {
            if (current.key == key) {
                if (previous == null)
                    buckets[bucketIndex] = null;
                else {
                    previous.next = current.next;
                    current.next = null;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    private Node find(int key, int bucketIndex) {
        for (Node temp = buckets[bucketIndex]; temp != null; temp = temp.next) {
            if (temp.key == key) {
                return temp;
            }
        }
        return null;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % capacity;
    }
}

class Node {
    Integer key, value;
    Node next;

    public Node(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
