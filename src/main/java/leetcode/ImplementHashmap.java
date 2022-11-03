package leetcode;

// https://leetcode.com/problems/design-hashmap/
public class ImplementHashmap {
    private static final int SIZE = 10000;
    private final ListNode[] dataStore;

    public ImplementHashmap() {
        dataStore = new ListNode[SIZE];
    }

    public void put(int key, int value) {
        int keyIndex = getIndex(key);
        ListNode temp = dataStore[keyIndex];

        ListNode newNode = new ListNode(key, value);
        if (temp == null) {
            dataStore[keyIndex] = newNode;
            return;
        }

        ListNode keyNode = getKeyNode(key);
        if (keyNode != null) {
            keyNode.value = value;
            return;
        }

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.previous = temp;
    }

    public int get(int key) {
        ListNode keyNode = getKeyNode(key);
        if (keyNode == null)
            return -1;
        return keyNode.value;
    }

    public void remove(int key) {
        ListNode keyNode = getKeyNode(key);
        if (keyNode != null) {
            ListNode previous = keyNode.previous;
            ListNode next = keyNode.next;

            if (previous == null)
                dataStore[getIndex(key)] = next;
            else
                previous.next = next;
            if (next != null)
                next.previous = previous;
        }
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    private ListNode getKeyNode(int key) {
        int keyIndex = getIndex(key);
        if (dataStore[keyIndex] == null)
            return null;

        ListNode temp = dataStore[keyIndex];
        while (temp != null) {
            if (temp.key == key)
                return temp;
            temp = temp.next;
        }
        return null;
    }
}

class ListNode {
    int key, value;
    ListNode previous, next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
