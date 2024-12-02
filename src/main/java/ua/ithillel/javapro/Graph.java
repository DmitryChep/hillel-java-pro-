package ua.ithillel.javapro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph <T> {
    private final Map<T, List<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }
    //add a new vertex to the graph
    public void addVertex(T vertex) {
        if (vertex == null) throw new NullPointerException("vertex is null");
        adjacencyList.put(vertex, new ArrayList<>());
    }
    // add an undirected edge between two vertices
    public void addUndirectedEdge(T source, T destination) {
        if (source == null) throw new NullPointerException("source is null");
        if (destination == null) throw new NullPointerException("destination is null");
        adjacencyList.get(source).add(destination);
    }
    // add a bidirectional edge between two vertices
    public void addBidirectionalEdge(T source, T destination) {
        if (source == null) throw new NullPointerException("source is null");
        if (destination == null) throw new NullPointerException("destination is null");
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }
    // remove the vortex from the graph
    public void removeVertex(T vertex) {
        if (vertex == null) throw new NullPointerException("vertex is null");
        adjacencyList.remove(vertex);
    }
    // remove an edge between two vertices
    public void removeEdge(T source, T destination) {
        if (source == null) throw new NullPointerException("source is null");
        if (destination == null) throw new NullPointerException("destination is null");
        adjacencyList.get(source).remove(destination);
    }
    // checks if a vertex exists in the graph.
    public boolean hasVertex(T vertex) {
        if (vertex == null) throw new NullPointerException("vertex is null");
        return adjacencyList.containsKey(vertex);
    }
    // checks if an edge exists between two vertices in the graph
    public boolean hasEdge(T source, T destination) {
        if (source == null) throw new NullPointerException("source is null");
        if (destination == null) throw new NullPointerException("destination is null");
        return adjacencyList.get(source).contains(destination);
    }

    public void printGraph() {
        for(Map.Entry<T, List<T>> entry : adjacencyList.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
