package linkedList;

import linkedList.DesignLinkedList.MyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DesignLinkedListTest {
    private MyLinkedList list;

    @Test
    public void sampleInput1() {
        list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);

        assertEquals(2, list.get(1));

        list.deleteAtIndex(1);
        assertEquals(3, list.get(1));
    }
}
