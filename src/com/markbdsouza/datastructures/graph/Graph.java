package com.markbdsouza.datastructures.graph;

import java.util.ArrayList;
import java.util.List;

// Vertices - similar to nodes in other DS. One vertex is connected to any number of other vertices
// Edges -> connections between vertices.
// Path -> Way of traversing between vertices in a graph
// Degree -> Number of edges connected to a vertex. Outgoing degree, edges going outward. Incoming degree, edges inward.
// Adjacency Matrix -> a nxn matrix showing which vertex is connected to which vertex
// Adjacency List -> A list is created with all the edges. Just a representation format.
// 0th vertex outward connections will be kept in 0th index. 1st outward in 1st index etc.

public class Graph {
    private int vCount; // number of vertices
    private int eCount; // Number of edges

    private List<Integer>[] adjacents; // array of integer lists

    public Graph(int vCount) {
        this.vCount = vCount;
        this.eCount = 0;
        adjacents = new ArrayList[vCount];

        for (int i = 0; i < vCount; i++) {
            adjacents[i] = new ArrayList<>();
        }
    }

    public int getVertexCount() {
        return vCount;
    }

    public int getEdgeCount() {
        return eCount;
    }

    public void addEdge(int src, int dest) {
        adjacents[src].add(dest);
        eCount++;
    }

    public Object[] adj(int src) {
        return adjacents[src].toArray();
    }

}