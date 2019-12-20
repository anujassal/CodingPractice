package com.coding.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Space complexity - O(E + V)
* Time complexity - O(ElogV)
*/

public class PrimMst {
	
	public List<Edge<Integer>> primMst(Graph<Integer> graph){
		Map<Vertex<Integer>,Edge<Integer>> vertexToEdge = new HashMap<>();
		List<Edge<Integer>> mst = new ArrayList<>();
		BinaryMinHeap<Vertex<Integer>> heap = new BinaryMinHeap<>();
		
		/*
		 * get all the vertices of the graph and add them to the minHeap with initial infinity value
		 */
		for(Vertex<Integer> v:graph.getAllVertex()){
			heap.add(v, Integer.MAX_VALUE);
		}
		
		Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
		heap.decrease(startVertex, 0);
		while(!heap.isEmpty()){
			/*
			 * extract min from the heap.
			 * get its adjacent vertices and weight of the edges.
			 * update the vertextoedge map with the edge weight.
			 * get the edge that introduced the vertex/min weight in the heap and add it to the result.
			 */
			Vertex<Integer> minVertex = heap.getMin();
			if(vertexToEdge.get(minVertex)!=null)
				mst.add(vertexToEdge.get(minVertex));
			//get all the vertices of the edge and update the min heap and vertexToEdge map
			for(Edge<Integer> adjEdge:minVertex.getEdges()){
				Vertex<Integer> adjacentVertex = getAdjacentVertex(minVertex,adjEdge);
				if(heap.contains(adjacentVertex) && heap.getWeight(adjacentVertex)!=null&&heap.getWeight(adjacentVertex)>adjEdge.getWeight()){
					//update the heap with lower weight
					heap.decrease(adjacentVertex, adjEdge.getWeight());
					vertexToEdge.put(adjacentVertex, adjEdge);
				}
			}
		}
		return mst;
	}
	
	public Vertex<Integer> getAdjacentVertex(Vertex<Integer> vertex,Edge<Integer> edge){
		return edge.getVertex1().equals(vertex)?edge.getVertex2():edge.getVertex1();	
	}
	public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);
     /* graph.addEdge(0, 1, 4);
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

        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

        PrimMst prims = new PrimMst();
        Collection<Edge<Integer>> edges = prims.primMst(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }

}
