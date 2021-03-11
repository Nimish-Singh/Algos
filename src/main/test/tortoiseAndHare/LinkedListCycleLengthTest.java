package tortoiseAndHare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListCycleLengthTest {
    private LinkedListCycleLength cycleLength = new LinkedListCycleLength();

    @Test
    public void sampleInput1() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        assertEquals(3, cycleLength.findLength(head));
    }

    @Test
    public void sampleInput2() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        assertEquals(0, cycleLength.findLength(head));
    }
}