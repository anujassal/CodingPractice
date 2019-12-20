package com.coding.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	
	private List<Edge<T>> allEdges;
	private Map<Long,Vertex<T>> allVertex;
	boolean isDirected;
	
	public List<Edge<T>> getAllEdges() {
		return allEdges;
	}
	
	public Collection<Vertex<T>> getAllVertex() {
		return allVertex.values();
	}
	
	public Graph(boolean isDirected){
		allEdges = new ArrayList<>();
		allVertex = new HashMap<>();
		this.isDirected = false;
	}
	
	public Vertex<T> getVertex(Integer id){
		return allVertex.get(id);
	}
		
		public void addVertex(Vertex<T> v){
			if(allVertex.containsKey(v.id))
				return;
			allVertex.put(v.id, v);
			for(Edge<T> edge:v.getEdges())
				allEdges.add(edge);
		}
		
		public Vertex<T> addSingleVertex(long id){
			if(allVertex.containsKey(id))
				return allVertex.get(id);
			Vertex<T> v = new Vertex<T>(id);
			allVertex.put(id, v);
			return v;
		}
		
		public void addEdge(long id1, long id2, int weight){
			Vertex<T> v1 = null;
			if(allVertex.containsKey(id1)){
				v1 = allVertex.get(id1);
			}else{
				v1 = new Vertex<>(id1);
				allVertex.put(id1,v1);
			}
			Vertex<T> v2 = null;
			if(allVertex.containsKey(id2)){
				v2 = allVertex.get(id2);
			}else{
				v2 = new Vertex<>(id2);
				allVertex.put(id2,v2);
			}
			
			Edge<T> edge = new Edge(v1,v2,isDirected,weight);
			allEdges.add(edge);
			v1.addAdjacentVertex(edge, v2);
			if(!isDirected)
				v2.addAdjacentVertex(edge, v1);	
		}
}
	
	class Vertex<T>{
		@Override
		public String toString() {
			return "Vertex [id=" + id + "]";
		}

		long id;
		//private T data;
		private List<Edge<T>> edges = new ArrayList<>();
		private List<Vertex<T>> adjacentVertex = new ArrayList<>();
		Vertex(long id){
			this.id = id;
		}
		public void addAdjacentVertex(Edge<T> e,Vertex<T> v){
			edges.add(e);
			adjacentVertex.add(v);
		}
		public List<Vertex<T>> getAdjacentVertexes(){
			return adjacentVertex;
		}
		public List<Edge<T>> getEdges(){
			return edges;
		}
	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (id ^ (id >>> 32));
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Vertex other = (Vertex) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }
		
	}
	
	class Edge<T>{
		private boolean isDirected = false;
		private Vertex<T> vertex1;
		private Vertex<T> vertex2;
		public Vertex<T> getVertex1() {
			return vertex1;
		}

		public void setVertex1(Vertex<T> vertex1) {
			this.vertex1 = vertex1;
		}

		public Vertex<T> getVertex2() {
			return vertex2;
		}

		public void setVertex2(Vertex<T> vertex2) {
			this.vertex2 = vertex2;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		private int weight;
		
		Edge(Vertex<T> v1,Vertex<T> v2){
			this.vertex1 = v1;
			this.vertex2 = v2;
		}
		
		Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected,int weight){
			this.vertex1 = v1;
			this.vertex2 = v2;
			this.isDirected = isDirected;
			this.weight = weight;
		}
		 @Override
		    public int hashCode() {
		        final int prime = 31;
		        int result = 1;
		        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
		        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
		        return result;
		    }

		    @Override
		    public boolean equals(Object obj) {
		        if (this == obj)
		            return true;
		        if (obj == null)
		            return false;
		        if (getClass() != obj.getClass())
		            return false;
		        Edge other = (Edge) obj;
		        if (vertex1 == null) {
		            if (other.vertex1 != null)
		                return false;
		        } else if (!vertex1.equals(other.vertex1))
		            return false;
		        if (vertex2 == null) {
		            if (other.vertex2 != null)
		                return false;
		        } else if (!vertex2.equals(other.vertex2))
		            return false;
		        return true;
		    }

		    @Override
		    public String toString() {
		        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1.id
		                + ", vertex2=" + vertex2.id + ", weight=" + weight + "]";
		    }
		
	}


