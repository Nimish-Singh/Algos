package reverseLinkedList;

// Reverse a linked list in-place
public class ReverseInPlace {
    public Node reverse(Node head) {
        if (head == null)
            return null;
        Node previous, current, next;
        previous = null;
        current = head;
        next = head.next;

        while (current.next != null) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }
        current.next = previous;
        return current;
    }
}
