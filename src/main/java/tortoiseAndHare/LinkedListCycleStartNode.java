package tortoiseAndHare;

// Find the first node of cycle in linked list
public class LinkedListCycleStartNode {
    private LinkedListCycleLength cycleLength;

    public LinkedListCycleStartNode() {
        this.cycleLength = new LinkedListCycleLength();
    }

    public Node findCycleStart(Node head) {
        if (head == null)
            return null;
        int length = cycleLength.findLength(head);
        int stepCounter = 1;
        Node firstPointer = head, secondPointer = head;

        while (stepCounter < length++)
            firstPointer = firstPointer.next;

        while (firstPointer != secondPointer) {
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }
        return firstPointer;
    }
}
