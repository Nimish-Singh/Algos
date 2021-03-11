package tortoiseAndHare;

// Detect cucle in linked list
public class CycleInLinkedList {
    public boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }
        return false;
    }
}
