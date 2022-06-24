package com.markbdsouza.datastructures.graph;

public class GraphApplication {
    public static void main(String[] args) {
        Graph myGraph = new Graph(5);
        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(0,4);
        myGraph.addEdge(1,4);
        myGraph.addEdge(2,3);
        myGraph.addEdge(2,4);

        Object [] values = myGraph.adj(1);
		for(Object val : values){
			System.out.println(val);
		}


        System.out.println("-----------------------------------------------------------------------");
        EnhancedGraph myEnhancedGraph = new EnhancedGraph(5, "undirected");
        myEnhancedGraph.addVertex("State");
        myEnhancedGraph.addVertex("Avenel");
        myEnhancedGraph.addVertex("Elm");
        myEnhancedGraph.addVertex("Pocono");
        myEnhancedGraph.addVertex("William");

        myEnhancedGraph.addEdge("Avenel", "Pocono");
        myEnhancedGraph.addEdge("State", "Elm");
        myEnhancedGraph.addEdge("Elm", "Avenel");
        myEnhancedGraph.addEdge("Elm", "William");
        myEnhancedGraph.addEdge("William", "State");
        myEnhancedGraph.addEdge("William", "Pocono");
        myEnhancedGraph.addEdge("Pocono", "Elm");
        myEnhancedGraph.addEdge("State", "Avenel");

        myEnhancedGraph.print();

    }
}
