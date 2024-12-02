package ua.ithillel.javapro;

public class Application {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        // add vertices  to the graph
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // add an undirected edge between two vertices
        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,3);
        graph.addUndirectedEdge(3, 2);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(4, 3);
        System.out.println("Graph:");
        graph.printGraph();

        // remove the vortex from the graph
        graph.removeVertex(2);
        System.out.println("Graph after removing vertex: 2");
        graph.printGraph();

        // remove an edge between two vertices
        graph.removeEdge(1, 2);
        System.out.println("Graph after removing edge: 1 -> 2");
        graph.printGraph();

        // checks if a vertex exists in the graph.
        System.out.println("Graph has vertex 1: " + graph.hasVertex(1) );

        // checks if an edge exists between two vertices in the graph
        System.out.println("Graph has edge 1 -> 2: " + graph.hasEdge(1, 2));
    }
}
