package com.coding.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph2<T> {
	
	Map<Integer,Vertex<T>> vertexMap = new HashMap<>();
	List<Edge<T>> allEdges = new ArrayList<>();
	
	class Vertex<T>{
		boolean wasVisited = false;
		Integer id;
		T data;
		List<Vertex<T>> adjacentVertexList = new ArrayList<>();

		public Vertex(Integer id){
			this.id = id;
		}
		public List<Vertex<T>> getAdjacentVertexList() {
			return adjacentVertexList;
		}
		public void displayVertex(){
			System.out.println(id);
		}
	}
	
	class Edge<T>{
		Vertex<T> v1;
		Vertex<T> v2;
		int weight;
		public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int wtg){
			this.v1 = vertex1;
			this.v2 = vertex2;
			this.weight = wtg;
		}
		
	}
	
	public void addVertex(Integer id){
		Vertex<T> vertex = new Vertex<>(id);
		vertexMap.put(id,vertex);
	}
	
	public void addEdge(int id1,int id2,int weight){
		Vertex<T> vertex1 =  vertexMap.get(id1);
		Vertex<T> vertex2 =  vertexMap.get(id2);
		if(vertex1==null){
			vertex1 = new Vertex<T>(id1);
			vertexMap.put(id1, vertex1);
		}
		if(vertex2==null){
			vertex2 = new Vertex<T>(id2);
			vertexMap.put(id2, vertex2);
		}
		vertex1.adjacentVertexList.add(vertex2);
		vertex2.adjacentVertexList.add(vertex1);
		Edge<T> e = new Edge<>(vertex1,vertex2,weight);	
		allEdges.add(e);
	}
	
	public void dfs(Vertex<T> startVertex){
		/*
		 * start with the source vertex, mark it as visited, display it and then put it on the stack.
		 * Get the adjacent vertices for this vertex and push them on the stack and repeat the process 
		 * till a vertex does not have any adjacent unvisited vertices. In that case pop the vertex off the stack.
		 */
		Stack<Vertex<T>> stk = new Stack<Vertex<T>>();
		startVertex.displayVertex();
		startVertex.wasVisited = true;
		stk.add(startVertex);
		while(!stk.isEmpty()){
			Vertex<T> v = getAdjacentVertex(stk.peek());
			if(v==null){
				stk.pop(); //remove the vertex from the stack if no adjacent vertex is found.
			}else{
				v.displayVertex();
				v.wasVisited = true;
				stk.add(v);
			}
		}
	}
	
	public Vertex<T> getAdjacentVertex(Vertex<T> srcVertex){
		List<Vertex<T>> adjacentVertexList = srcVertex.adjacentVertexList;
		for(int i=0;i<adjacentVertexList.size();i++){
			if(!adjacentVertexList.get(i).wasVisited)
				return adjacentVertexList.get(i);
		}
		return null;
	}
	
	public void bfs(Vertex<T> srcVertex){
		Queue<Vertex<T>> queue = new LinkedList<>();
		queue.add(srcVertex);
		//visit all the adjacent nodes of the vertex
		srcVertex.displayVertex();
		srcVertex.wasVisited = true;
		while(!queue.isEmpty()){
			Vertex<T> v = queue.remove();
			while(getAdjacentVertex(v)!=null){
				Vertex<T> adjVertex = getAdjacentVertex(v);
				adjVertex.displayVertex();
				adjVertex.wasVisited = true;
				queue.add(adjVertex);
			}
		}
	}
	
	public void mst(Vertex<T> srcVertex){
		//mst is essentially dfs only diff is that you display the edge instead of just the vertex.
		Stack<Vertex<T>> stk = new Stack<>();
		stk.add(srcVertex);
		//srcVertex.displayVertex();
		srcVertex.wasVisited = true;
		while(!stk.isEmpty()){
			Vertex<T> v = getAdjacentVertex(srcVertex);
			srcVertex.displayVertex();
			v.displayVertex();
			v.wasVisited = true;
			stk.add(v);
		}
	}

}
