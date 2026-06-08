package linkedList;

import static linkedList.PalindromeLinkedList.*;

// https://leetcode.com/problems/partition-list/description
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(-1);
        ListNode greater = new ListNode(-1);

        ListNode temp = head;
        ListNode lesserTemp = lesser;
        ListNode greaterTemp = greater;

        while (temp != null) {
            // This can be changed to space O(1) by reusing original nodes instead of creating new node with its value
            if (temp.val < x) {
                lesserTemp.next = new ListNode(temp.val);
                lesserTemp = lesserTemp.next;
            } else {
                greaterTemp.next = new ListNode(temp.val);
                greaterTemp = greaterTemp.next;
            }
            temp = temp.next;
        }

        lesserTemp.next = greater.next;

        return lesser.next;
    }
}
