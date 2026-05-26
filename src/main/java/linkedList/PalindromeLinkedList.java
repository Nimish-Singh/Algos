package linkedList;

// https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
//        return stringApproach(head);
        return reverseListApproach(head);
    }

    private boolean reverseListApproach(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverse(slow);
        slow.next = null;

        while (secondHalfHead != null) {
            if (head.val != secondHalfHead.val)
                return false;

            head = head.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr, prev;
        curr = head;
        prev = null;

        while (curr != null) {
            ListNode originalNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = originalNext;
        }

        return prev;
    }

    private static boolean stringApproach(ListNode head) {
        if (head == null)
            return true;

        ListNode temp = head;
        StringBuilder listString = new StringBuilder();

        while (temp != null) {
            listString.append(temp.val);
            temp = temp.next;
        }

        for (int start = 0, end = listString.length() - 1; start <= end; start++, end--) {
            if (listString.charAt(start) != listString.charAt(end))
                return false;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
