import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.LinkedMap;
//import java.util.Map;
//import java.util.Random;
import org.apache.commons.collections.map.MultiKeyMap;

public class Graph {
	private int numVertices; //number of vertex in graph;
	List<Integer> vertices;
	MultiKeyMap edges;
	
	public Graph(int numVertices){
		this.numVertices = numVertices;
		vertices = new ArrayList<Integer>();
		edges = new MultiKeyMap();	
	}
	
	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public void addEdge(int src,int dest,int cost){
		if(!existsEdge(src,dest))
		{
			edges.put(src,dest,cost);   
		}
	}
	
	public void addVertices(){
		for(int i =0; i<numVertices; i++){   
			vertices.add(i);   
	    }
	}
	
	public boolean existsEdge(int src,int dest)
	{
		if(edges.containsKey(src, dest))
		    return true;
		else 
			return false;
	}
	
	public void showGraph(){
		System.out.println("Show Graph");
		MapIterator it = edges.mapIterator();
		System.out.println("Source"+"  "+"Destination"+"  "+"Cost");
		while(it.hasNext()){
			it.next();
			MultiKey mk = (MultiKey) it.getKey();
			System.out.println(mk.getKey(0) + " " + mk.getKey(1) + " " +it.getValue());
		}
	}
	
	public int getTotalPathCost(List<Integer> path){
		
		int totalPathCost=0;
		for(int i = 0; i < path.size()-1; i++){
			 totalPathCost += (int)edges.get(path.get(i),path.get(i+1));
		}
		     totalPathCost += (int)edges.get(path.get(path.size()-1),path.get(0));
		return totalPathCost;
    }
	
	public List<List<Integer>> getRandomPaths(Graph graph,int max_size){
		
		List<List<Integer>> random_paths = new ArrayList<List<Integer>>();
		List<Integer> list_vertices = new ArrayList<Integer>();
		
		for(Integer vertex : vertices){
			list_vertices.add(vertex);	
		}
		
		Integer initial_vertices = getRandom(list_vertices);
		
		if(!list_vertices.contains(initial_vertices)){
			System.out.println("Error");
		}
		
		list_vertices.remove(initial_vertices);
		list_vertices.add(0,initial_vertices);
		
		for(int i =0;i<max_size;i++){
			List<Integer> list_temp = new ArrayList<Integer>(list_vertices.subList(1,list_vertices.size()));
			Collections.shuffle(list_temp);
			list_temp.add(0,initial_vertices);
            random_paths.add(list_temp);
		}
		return random_paths;
	}
	
	public Integer getRandom(List<Integer> list) {
		Integer index = (int)(Math.random()*list.size());
		return list.get(index);
	}
}