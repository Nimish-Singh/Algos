package linkedList;

import java.util.HashSet;
import java.util.Set;

import static linkedList.PalindromeLinkedList.*;

// https://leetcode.com/problems/intersection-of-two-linked-lists/description/
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();

        ListNode temp = headA;

        while (temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (nodes.contains(temp))
                return temp;
            temp = temp.next;
        }

        return null;
    }
}
