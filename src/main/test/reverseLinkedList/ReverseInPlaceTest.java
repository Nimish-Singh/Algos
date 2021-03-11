package reverseLinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReverseInPlaceTest {
    private ReverseInPlace reverseInPlace = new ReverseInPlace();

    @Test
    public void sampleInput1() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node reversedList = reverseInPlace.reverse(head);
        assertEquals(5, reversedList.value);
        assertEquals(4, reversedList.next.value);
        assertEquals(3, reversedList.next.next.value);
        assertEquals(2, reversedList.next.next.next.value);
        assertEquals(1, reversedList.next.next.next.next.value);
        assertNull(reversedList.next.next.next.next.next);
    }
}
