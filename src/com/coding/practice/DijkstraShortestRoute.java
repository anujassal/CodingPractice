package com.coding.practice;

import java.util.HashMap;
import java.util.Map;

public class DijkstraShortestRoute {
	
	public Map<Vertex<Integer>,Integer> shortestPath(Graph<Integer> graph,Vertex<Integer> srcVertex){
		Map<Vertex<Integer>,Integer> vertexDistFromSrc = new HashMap<>();
		Map<Vertex<Integer>,Vertex<Integer>> vertexParent = new HashMap<>();
		BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();
		
		for(Vertex<Integer> vertex:graph.getAllVertex()){
			minHeap.add(vertex, Integer.MAX_VALUE);
		}
		Vertex<Integer> currVertex = graph.getAllVertex().iterator().next();
		minHeap.decrease(currVertex, 0);
		//vertexDistFromSrc.put(currVertex, 0);
		vertexParent.put(currVertex, null);
		
		while(!minHeap.isEmpty()){
			BinaryMinHeap<Vertex<Integer>>.Node minVertex = minHeap.extractMin();
			vertexDistFromSrc.put(minVertex.key, minVertex.weight);
			
			for(Edge<Integer> edge:minVertex.key.getEdges()){
				Vertex<Integer> adjVertex = getAdjacentVertex(edge,minVertex.key);
				int distFromSrc = vertexDistFromSrc.get(minVertex.key)!=null?vertexDistFromSrc.get(minVertex.key):0;
				int newDist = distFromSrc+edge.getWeight();
				if(minHeap.contains(adjVertex)&&newDist<minHeap.getWeight(adjVertex)){
					minHeap.decrease(adjVertex, newDist);
					vertexParent.put(adjVertex,minVertex.key);
				}
			}
		}
		return vertexDistFromSrc;
	}
	
	public Vertex<Integer> getAdjacentVertex(Edge<Integer> edge,Vertex<Integer> vertex){
		return edge.getVertex1().equals(vertex)?edge.getVertex2():edge.getVertex1();	
	}
	
	/*public getPath(Graph<Integer> graph,Integer src,Integer dst){
        DijkstraShortestRoute dsp = new DijkstraShortestRoute();
		Vertex<Integer> sourceVertex = graph.getVertex(src);
		Map<Vertex<Integer>,Integer> shortestDistFromSrc = dsp.shortestPath(graph, sourceVertex);
		
	}*/
	
	public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);
        /*graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(2, 5, 4);
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8);
        graph.addEdge(2, 8, 2);
        graph.addEdge(3, 5, 14);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 8, 7);*/

        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 2);
        graph.addEdge(1, 4, 9);
        graph.addEdge(1, 5, 3);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 4, 2);
        graph.addEdge(3, 4, 3);

        DijkstraShortestRoute dsp = new DijkstraShortestRoute();
        Vertex<Integer> sourceVertex = graph.getVertex(1);
        Map<Vertex<Integer>,Integer> distance = dsp.shortestPath(graph, sourceVertex);
        System.out.print(distance);
    }

}
