package reverseLinkedList;

// Reverse the sublist in a linked list, from index1 to index2
public class ReverseSublist {
    public Node reverse(Node head, int index1, int index2){
        if (head == null || index1 == index2)
            return head;

        Node index1Previous, index2Node, previous, current, next;
        index1Previous = index2Node = head;
        int nodeIndex = 1;

        while(nodeIndex++ < index1 - 1) {
            index1Previous = index1Previous.next;
        }
        nodeIndex = 1;
        while(nodeIndex++ < index2) {
            index2Node = index2Node.next;
        }

        previous = index1Previous.next;
        current = previous.next;
        next = current.next;

        while (current != index2Node) {
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }

        next = index2Node.next;
        current.next = previous;
        current = index1Previous.next;

        index1Previous.next = index2Node;
        current.next = next;

        return head;
    }
}
