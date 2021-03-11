package tortoiseAndHare;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListCycleStartNodeTest {
    private LinkedListCycleStartNode cycleStart = new LinkedListCycleStartNode();

    @Test
    public void sampleInput1() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;
        assertEquals(3, cycleStart.findCycleStart(head).value);
    }
}
