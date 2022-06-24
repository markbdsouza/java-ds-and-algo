package com.markbdsouza.datastructures.graph;

// In enhanced graph we allow each vertex to have a String value as well instead of an index
// To support this at each index we store an Object Vertex
// For each Certex we still save the name of the Vertex and a linked list containing all the edges of that vertex
public class EnhancedGraph {
    Vertex[] arrayOfLists;
    int indexCounter = 0;
    boolean undirected = true;

    public EnhancedGraph(int vCount, String graphType) {
        if (graphType.equals("directed")) {
            undirected=false;
        }
        arrayOfLists = new Vertex[vCount];
    }

    class Node {
        public int vertexIndex;
        public Node next;
        public Node(int vertexIndex, Node next) {
            this.vertexIndex = vertexIndex;
            this.next = next;
        }
    }

    class Vertex {
        String name;
        Node adjList;
        Vertex(String name, Node adjList) {
            this.name = name;
            this.adjList = adjList;
        }
    }


    public void addVertex(String name) {
        arrayOfLists[indexCounter] = new Vertex(name, null);
        indexCounter++;
    }

    public void addEdge(String fromVertex, String toVertex) {
        int fromIndex = indexForName(fromVertex);
        int toIndex = indexForName(toVertex);
        arrayOfLists[fromIndex].adjList = new Node(toIndex, arrayOfLists[fromIndex].adjList);
        // If undirected, it is bi directional, so create edges on both sides
        if(undirected){
            arrayOfLists[toIndex].adjList = new Node(fromIndex, arrayOfLists[toIndex].adjList);
        }
    }

    // Method to find the index given the name of the node
    int indexForName(String name){
        for (int i = 0; i < arrayOfLists.length; i++) {
            if(arrayOfLists[i].name.equals(name)){
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println("From Vertex -> All Connected Vertexes");
        for (int v=0; v < arrayOfLists.length; v++) {
            System.out.print(arrayOfLists[v].name);
            for (Node aNode = arrayOfLists[v].adjList; aNode != null; aNode = aNode.next) {
                System.out.print(" --> " + arrayOfLists[aNode.vertexIndex].name);
            }
            System.out.println();
        }
    }

}
