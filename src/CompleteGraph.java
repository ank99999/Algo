import java.util.concurrent.ThreadLocalRandom;

public class CompleteGraph {
	
	private Graph graph;

	public CompleteGraph(Graph graph){
		this.graph = graph;	
     }
	
	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public Graph generates(){
		int cost;
		for(int i =0 ; i<= graph.getNumVertices();i++){
			for(int j=0;j<=graph.getNumVertices();j++){
				if(i!=j){
				    cost = ThreadLocalRandom.current().nextInt(1, 11);
				    graph.addEdge(i,j, cost);
				}	     
			}
		}
		return graph;
	}
}
