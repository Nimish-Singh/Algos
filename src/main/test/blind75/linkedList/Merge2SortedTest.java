package blind75.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Merge2SortedTest {
    private final Merge2Sorted merge = new Merge2Sorted();
    private ListNode head1;
    private ListNode head2;

    @Test
    public void sampleInput1() {
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode mergedList = merge.mergeTwoLists(head1, head2);

        assertEquals(1, mergedList.val);
        assertEquals(1, mergedList.next.val);
        assertEquals(2, mergedList.next.next.val);
        assertEquals(3, mergedList.next.next.next.val);
        assertEquals(4, mergedList.next.next.next.next.val);
        assertEquals(4, mergedList.next.next.next.next.next.val);
        assertNull(mergedList.next.next.next.next.next.next);
    }

    @Test
    public void sampleInput2() {
        head1 = null;
        head2 = null;
        ListNode mergedList = merge.mergeTwoLists(head1, head2);
        assertNull(mergedList);
    }

    @Test
    public void sampleInput3() {
        head1 = null;
        head2 = new ListNode(0);
        ListNode mergedList = merge.mergeTwoLists(head1, head2);
        assertEquals(0, mergedList.val);
        assertNull(mergedList.next);
    }
}
