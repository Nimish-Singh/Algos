package linkedList;

import static linkedList.PalindromeLinkedList.ListNode;

public class DesignLinkedList {

    static class MyLinkedList {
        private int size;
        private ListNode head;

        public MyLinkedList() {
            size = 0;
            head = new ListNode();
        }

        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;

            int currentIndex = 0;
            ListNode temp = head.next;
            while (currentIndex < index) {
                temp = temp.next;
                currentIndex++;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            ListNode oldHeadNext = head.next;
            ListNode node = new ListNode(val);
            node.next = oldHeadNext;
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node = new ListNode(val);
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size)
                return;

            if (index == size) {
                addAtTail(val);
                return;
            }

            ListNode current = head.next;
            ListNode previous = head;
            int currentIndex = 0;

            while (currentIndex < index) {
                previous = current;
                current = current.next;
                currentIndex++;
            }

            ListNode node = new ListNode(val);
            node.next = current;
            previous.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;

            int currentIndex = 0;
            ListNode curr = head.next;
            ListNode prev = head;

            while (currentIndex < index) {
                prev = curr;
                curr = curr.next;
                currentIndex++;
            }

            prev.next = curr.next;
            curr.next = null;
            size--;
        }
    }
}
