package linkedList;

import org.junit.Test;

import static linkedList.PalindromeLinkedList.ListNode;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeLinkedListTest {
    private final PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    private ListNode head;

    @Test
    public void sampleInput1() {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        assertTrue(palindromeLinkedList.isPalindrome(head));
    }

    @Test
    public void sampleInput2() {
        head = new ListNode(1);
        head.next = new ListNode(2);

        assertFalse(palindromeLinkedList.isPalindrome(head));
    }
}
