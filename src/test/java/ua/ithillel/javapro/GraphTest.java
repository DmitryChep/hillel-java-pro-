package ua.ithillel.javapro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

class GraphTest {
    private static PrintStream old;
    private ByteArrayOutputStream output;
    private Graph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new Graph<>() ;
        old = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));// swapping the console output stream for your own
    }

    @AfterEach
    void cleanUpStreams() {
        System.setOut(old);
    }

    @Test
    void addVertex_shouldAddVertex_whenVertexNotNull() {
        graph.addVertex(1);
        assertTrue( graph.hasVertex(1));
    }
    @Test
    void addVertex_shouldThrowNullPointerException_whenVertexIsNull() {
        assertThrows(NullPointerException.class, () -> graph.addVertex(null));
    }

    @Test
    void addUndirectedEdge_shouldAddUndirectedEdge_whenSourceAndDestinationNotNull() {
        graph.addVertex(1);
        graph.addUndirectedEdge(1, 2);
        assertTrue( graph.hasEdge(1, 2));
    }

    @Test
    void addUndirectedEdge_shouldThrow_whenSourceIsNullDestinationNotNull() {
        assertThrows(NullPointerException.class , () -> graph.addUndirectedEdge(null, 2));
    }

    @Test
    void addUndirectedEdge_shouldThrow_whenDestinationIsNullSourceNotNull() {
        graph.addVertex(1);
        assertThrows(NullPointerException.class, () -> graph.addUndirectedEdge(1 , null));
    }

    @Test
    void addBidirectionalEdge_shouldAddUndirectedEdge_whenSourceAndDestinationNotNull() {
        graph.addVertex(1);
        graph.addUndirectedEdge(1, 2);
        assertTrue( graph.hasEdge(1, 2));
    }

    @Test
    void addBidirectionalEdge_shouldThrowNullPointerException_whenSourceIsNullDestinationNotNull() {
        assertThrows(NullPointerException.class, () -> graph.addUndirectedEdge(null, 2));
    }

    @Test
    void addBidirectionalEdge_shouldThrowNullPointerException_whenDestinationIsNullSourceNotNull() {
        graph.addVertex(1);
        assertThrows(NullPointerException.class, () -> graph.addUndirectedEdge(1 , null));
    }

    @Test
    void removeVertex_shouldRemoveVertex_whenVertexNotNull() {
        graph.addVertex(1);
        graph.removeVertex(1);
        assertFalse( graph.hasVertex(1));
    }
    @Test
    void removeVertex_shouldThrowNullPointerException_whenvertexIsNull() {
        assertThrows(NullPointerException.class, () -> graph.removeVertex(null));
    }

    @Test
    void removeEdge_shouldRemoveEdge_whenSourceAndDestinationNotNull() {
        graph.addVertex(1);
        graph.addUndirectedEdge(1, 2);
        graph.removeEdge(1, 2);
        assertFalse( graph.hasEdge(1, 2));
    }

    @Test
    void removeEdge_shouldThrowNullPointerException_whenSourceIsNullDestinationNotNull() {
        assertThrows(NullPointerException.class, () -> graph.removeEdge(null, 2));
    }

    @Test
    void removeEdge_shouldThrowNullPointerException_whenDestinationIsNullSourceNotNull() {
        assertThrows(NullPointerException.class, () -> graph.removeEdge(1 , null));
    }

    @Test
    void hasVertex_shouldReturnTrue_whenVertexNotNull() {
        graph.addVertex(1);
        assertTrue( graph.hasVertex(1));
    }

    @Test
    void hasVertex_shouldThrowNullPointerException_whenVertexIsNull() {
        assertThrows(NullPointerException.class, () -> graph.hasVertex(null));
    }

    @Test
    void hasEdge_shouldReturnTrue_whenSourceAndDestinationNotNull() {
        graph.addVertex(1);
        graph.addUndirectedEdge(1, 2);
        assertTrue( graph.hasEdge(1, 2));
    }

    @Test
    void hasEdge_shouldThrowNullPointerException_whenSourceIsNullDestinationNotNull() {
        assertThrows(NullPointerException.class, () -> graph.hasEdge(null, 2));
    }

    @Test
    void hasEdge_shouldThrowNullPointerException_whenDestinationIsNullSourceNotNull() {
        assertThrows(NullPointerException.class, () -> graph.hasEdge(1 , null));
    }

    @Test
    void printGraph() {
        graph.addVertex(1);
        graph.addUndirectedEdge(1, 2);
        graph.printGraph();
        assertEquals("1 -> [2]\n", output.toString());
    }
}


