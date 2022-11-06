package blind75.graph;

import blind75.graph.CloneGraph;
import blind75.graph.Node;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class CloneGraphTest {
    private final CloneGraph cloner = new CloneGraph();

    @Test
    public void sampleInput1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Node clonedNode1 = cloner.cloneGraph(node1);

        Node clonedNode2 = clonedNode1.neighbors.get(0);
        Node clonedNode3 = clonedNode2.neighbors.get(1);
        Node clonedNode4 = clonedNode1.neighbors.get(1);

        assertNotEquals(node1, clonedNode1);
        assertEquals(1, clonedNode1.val);

        assertNotEquals(node2, clonedNode2);
        assertEquals(2, clonedNode2.val);

        assertNotEquals(node3, clonedNode3);
        assertEquals(3, clonedNode3.val);

        assertEquals(4, clonedNode4.val);
        assertNotEquals(node4, clonedNode4);

        assertEquals(2, clonedNode1.neighbors.size());
        assertEquals(2, clonedNode2.neighbors.size());
        assertEquals(2, clonedNode3.neighbors.size());
        assertEquals(2, clonedNode4.neighbors.size());

        assertEquals(clonedNode2, clonedNode1.neighbors.get(0));
        assertEquals(clonedNode4, clonedNode1.neighbors.get(1));

        assertEquals(clonedNode1, clonedNode2.neighbors.get(0));
        assertEquals(clonedNode3, clonedNode2.neighbors.get(1));

        assertEquals(clonedNode2, clonedNode3.neighbors.get(0));
        assertEquals(clonedNode4, clonedNode3.neighbors.get(1));

        assertEquals(clonedNode1, clonedNode4.neighbors.get(0));
        assertEquals(clonedNode3, clonedNode4.neighbors.get(1));
    }

    @Test
    public void sampleInput2() {
        Node node1 = new Node(1);
        Node clonedNode = cloner.cloneGraph(node1);

        assertNotEquals(node1, clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    public void sampleInput3() {
        Node clonedNode = cloner.cloneGraph(null);
        assertNull(clonedNode);
    }
}
