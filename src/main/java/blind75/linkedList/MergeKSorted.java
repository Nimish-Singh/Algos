package blind75.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode list : lists) {
            if (list != null)
                minHeap.offer(list);
        }

        ListNode result = null, head = null;
        while (!minHeap.isEmpty()) {
            ListNode smallestElement = minHeap.poll();

            if (result != null) {
                result.next = smallestElement;
                result = result.next;
            } else {
                result = smallestElement;
                head = result;
            }

            if (smallestElement.next != null)
                minHeap.offer(smallestElement.next);
        }

        return head;
    }
}
