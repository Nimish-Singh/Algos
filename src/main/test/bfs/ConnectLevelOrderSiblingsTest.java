package bfs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConnectLevelOrderSiblingsTest {
    private ConnectLevelOrderSiblings connector = new ConnectLevelOrderSiblings();

    @Test
    public void sampleInput1() {
        NodeWithConnection root = new NodeWithConnection(12);
        root.left = new NodeWithConnection(7);
        root.right = new NodeWithConnection(1);
        root.left.left = new NodeWithConnection(9);
        root.right.left = new NodeWithConnection(10);
        root.right.right = new NodeWithConnection(5);
        connector.connect(root);

        assertNull(root.next);
        assertEquals(1, root.left.next.value);
        assertNull(root.left.next.next);
        assertEquals(10, root.left.left.next.value);
        assertEquals(5, root.left.left.next.next.value);
        assertNull(root.left.left.next.next.next);
    }
}
