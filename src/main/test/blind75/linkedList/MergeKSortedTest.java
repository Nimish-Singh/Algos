package blind75.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeKSortedTest {
    private final MergeKSorted merge = new MergeKSorted();

    @Test
    public void sampleInput1() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;

        ListNode sortedList = merge.mergeKLists(lists);

        assertEquals(1, sortedList.val);
        assertEquals(1, sortedList.next.val);
        assertEquals(2, sortedList.next.next.val);
        assertEquals(3, sortedList.next.next.next.val);
        assertEquals(4, sortedList.next.next.next.next.val);
        assertEquals(4, sortedList.next.next.next.next.next.val);
        assertEquals(5, sortedList.next.next.next.next.next.next.val);
        assertEquals(6, sortedList.next.next.next.next.next.next.next.val);
        assertNull(sortedList.next.next.next.next.next.next.next.next);
    }

    @Test
    public void sampleInput2() {
        ListNode[] lists = new ListNode[0];
        ListNode sortedList = merge.mergeKLists(lists);
        assertNull(sortedList);
    }

    @Test
    public void sampleInput3() {
        ListNode head1 = null;
        ListNode[] lists = new ListNode[1];
        lists[0] = head1;
        ListNode sortedList = merge.mergeKLists(lists);
        assertNull(sortedList);
    }
}
