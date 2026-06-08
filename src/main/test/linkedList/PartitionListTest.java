package linkedList;

import org.junit.Test;

import static linkedList.PalindromeLinkedList.ListNode;
import static org.junit.Assert.assertEquals;

public class PartitionListTest {
    private final PartitionList partitionList = new PartitionList();
    private ListNode head;

    @Test
    public void sampleInput1() {
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode answer = partitionList.partition(head, 3);

        assertEquals(1, answer.val);
        assertEquals(2, answer.next.val);
        assertEquals(2, answer.next.next.val);
        assertEquals(4, answer.next.next.next.val);
        assertEquals(3, answer.next.next.next.next.val);
        assertEquals(5, answer.next.next.next.next.next.val);
    }

    @Test
    public void sampleInput2() {
        head = new ListNode(2);
        head.next = new ListNode(1);

        ListNode answer = partitionList.partition(head, 2);

        assertEquals(1, answer.val);
        assertEquals(2, answer.next.val);
    }
}
