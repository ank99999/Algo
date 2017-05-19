import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PSODriver {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices for the graph");
		int numVertex = 0;
		boolean flag = true;
		while(flag){
			try{
				numVertex = sc.nextInt();
				if(numVertex < 2 || numVertex > 201){
					System.out.println("Error.Please enter number greater than 1 and less than 201");
				}
				else {
					flag = false;
				}
			}
		    catch(InputMismatchException e){
		    	System.out.println("Error.Please enter number greater than 1 and less than 201");
			}
		}
		
		Graph graph = new Graph(numVertex);
		CompleteGraph completeGraph = new CompleteGraph(graph);
		Graph randomGraph = completeGraph.generates();
		randomGraph.addVertices();
		PSOAlgorithm pso = new PSOAlgorithm(randomGraph,200,10,1,0.9);
		pso.PSO();
		
		
	/*	Graph graph = new Graph(5);
		
		graph.addEdge(0,1,1);
		graph.addEdge(1,0,1);
		graph.addEdge(0,2,3);
		graph.addEdge(2,0,3);
		graph.addEdge(0,3,4);
		graph.addEdge(3,0,4);
		graph.addEdge(0,4,1);
		graph.addEdge(4,0,1);
		graph.addEdge(1,2,1);
		graph.addEdge(2,1,1);
		graph.addEdge(1,3,1);
		graph.addEdge(3,1,1);
		graph.addEdge(1,4,1);
		graph.addEdge(4,1,1);
		graph.addEdge(2,3,2);
	    graph.addEdge(3,2,2);
		graph.addEdge(2,4,1);
		graph.addEdge(4,2,1);
		graph.addEdge(3,4,3);
		graph.addEdge(4,3,3);
		
		graph.addVertices();
		PSOAlgorithm pso = new PSOAlgorithm(graph,200,10,1,0.9);
		pso.PSO();*/
		
		
		
		
		pso.showParticles();
		System.out.println("Global best cost "+ pso.getGbest().getCost_pbest_solution()+" Global best solution "+pso.gbest.getPbest());
	}
}
