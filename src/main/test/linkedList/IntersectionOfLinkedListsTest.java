package linkedList;

import org.junit.Test;

import static linkedList.PalindromeLinkedList.ListNode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntersectionOfLinkedListsTest {
    private final IntersectionOfLinkedLists intersection = new IntersectionOfLinkedLists();
    private ListNode headA, headB;

    @Test
    public void sampleInput1() {
        headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next; // Intersection point
        headB.next.next.next.next = new ListNode(4);
        headB.next.next.next.next.next = new ListNode(5);

        assertEquals(headA.next.next, intersection.getIntersectionNode(headA, headB));
    }

    @Test
    public void sampleInput2() {
        headA = new ListNode(2);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);

        headB = new ListNode(1);
        headB.next = new ListNode(5);

        assertNull(intersection.getIntersectionNode(headA, headB));
    }
}
