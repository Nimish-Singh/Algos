package reverseLinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseSublistTest {
    private ReverseSublist reverseSublist = new ReverseSublist();

    @Test
    public void sampleInput1() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        Node reversedHead = reverseSublist.reverse(head, 2, 5);
        assertEquals(1, reversedHead.value);
        assertEquals(5, reversedHead.next.value);
        assertEquals(4, reversedHead.next.next.value);
        assertEquals(3, reversedHead.next.next.next.value);
        assertEquals(2, reversedHead.next.next.next.next.value);
        assertEquals(6, reversedHead.next.next.next.next.next.value);
        assertNull(reversedHead.next.next.next.next.next.next);
    }
}
