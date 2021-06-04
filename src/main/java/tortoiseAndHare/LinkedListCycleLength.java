package tortoiseAndHare;
// Important
// Find the length of cycle in linked list
public class LinkedListCycleLength {
    public int findLength(Node head) {
        if (head == null)
            return 0;

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return calculateLength(slow);
        }
        return 0;
    }

    private int calculateLength(Node slow) {
        Node current = slow;
        int length = 0;
        do {
            current = current.next;
            ++length;
        }while (current != slow);
        return length;
    }
}
