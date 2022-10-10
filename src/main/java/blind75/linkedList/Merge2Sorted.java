package blind75.linkedList;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class Merge2Sorted {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;

        ListNode iterator1 = list1, iterator2 = list2, result, head;

        if (iterator2 == null || (iterator1 != null && iterator1.val <= iterator2.val)) {
            result = iterator1;
            iterator1 = iterator1.next;
        } else {
            result = iterator2;
            iterator2 = iterator2.next;
        }

        head = result;
        while (iterator1 != null && iterator2 != null) {
            if (iterator2.val < iterator1.val) {
                result.next = iterator2;
                iterator2 = iterator2.next;
            } else {
                result.next = iterator1;
                iterator1 = iterator1.next;
            }
            result = result.next;
        }

        while (iterator1 != null) {
            result.next = iterator1;
            result = result.next;
            iterator1 = iterator1.next;
        }

        while (iterator2 != null) {
            result.next = iterator2;
            result = result.next;
            iterator2 = iterator2.next;
        }

        return head;
    }
}

