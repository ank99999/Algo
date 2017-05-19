import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.javatuples.Quartet;

public class PSOAlgorithm {
	
	Graph graph;
	int iterations;
	int swarmPopulation;
	List<Particle> particles;
	double beta;
	double alpha;
	List<List<Integer>> solutions;
	Particle gbest;
	Particle gbestParticle ;
	List<Integer> solution_gbest;
	
	public PSOAlgorithm(Graph graph,int iterations, int swarmPopulation, double beta, double alpha){
		
		this.graph=graph;
		this.iterations=iterations;
		this.solutions = graph.getRandomPaths(graph,swarmPopulation);
		this.beta = beta;
		this.alpha = alpha;
		particles = new ArrayList<>();
		
		if(solutions.isEmpty())
			System.out.print("Initial population empty");
		
		
	    for(List<Integer> solution :solutions)
		{
	        
	    	    Particle particle = new Particle(solution,graph.getTotalPathCost(solution));
			    particles.add(particle);
		}
		
		this.swarmPopulation = particles.size();
			
	}
	
	public Particle getGbest() {
		return gbest;
	}

	public void setGbest(Particle gbest) {
		this.gbest = gbest;
	}
	
	public void showParticles(){
		System.out.println("pbest " + " || " + "   pbest cost " + "||"+ " current solution "+" || "+"current solution cost ");
		System.out.println("---------------------------------------------------------------------------------------------");
		for(Particle p : particles){
			System.out.println(p.getPbest()+"   "+p.getCost_pbest_solution()+"     "+p.getCurrentsolution()+"    "+p.getCost_current_solution());
		}	
	}
	
	public void PSO(){
		for(int i = 0 ; i <iterations; i++){
			gbest = Collections.min(particles, new ParticleComparator());
			//List<Particle> p = new ArrayList<>();
			for(Particle particle:particles){
				particle.clearVelocity(particle);
				List<Quartet<Integer,Integer,Integer,Double>> temp_velocity = new ArrayList<Quartet<Integer,Integer,Integer,Double>>();
				List<Integer> solution_particle = new ArrayList<>(particle.getCurrentsolution());
				List<Integer> solution_pbest = new ArrayList<>(particle.getPbest());
			    solution_gbest = new ArrayList<>(gbest.getPbest());
				
				//generate swap operators to calculate (pbest-x(t-1))
				for(int j =0 ; j<graph.getNumVertices();j++){
					if(solution_particle.get(j)!=solution_pbest.get(j)){
						Quartet<Integer,Integer,Integer,Double> swap_operator = new Quartet<Integer,Integer,Integer,Double>(j,solution_pbest.indexOf(solution_particle.get(j)),1,beta);
						temp_velocity.add(swap_operator);
						int aux =  solution_pbest.get(swap_operator.getValue0());
					    int aux2 = solution_pbest.get(swap_operator.getValue1());
					    solution_pbest.set(swap_operator.getValue0(), aux2);
					    solution_pbest.set(swap_operator.getValue1(), aux);			
					}	
				}
				
				for(Integer k =0 ; k<graph.getNumVertices();k++){
					if(solution_particle.get(k)!=solution_gbest.get(k)){
						Quartet<Integer,Integer,Integer,Double> swap_operator = new Quartet<Integer,Integer,Integer,Double>(k,solution_gbest.indexOf(solution_particle.get(k)),1,alpha);
						temp_velocity.add(swap_operator);
						int aux =  solution_gbest.get(swap_operator.getValue0());
					    int aux2 = solution_gbest.get(swap_operator.getValue1());
					    solution_gbest.set(swap_operator.getValue0(), aux2);
					    solution_gbest.set(swap_operator.getValue1(), aux);				
					}	
				}
				
				particle.setParticle_velocity(temp_velocity);
				
				for(Quartet<Integer,Integer,Integer,Double> swap_operator : temp_velocity){
					if(Math.random()<= (int)swap_operator.getValue2()){
						int aux =  solution_particle.get((int) swap_operator.getValue0());
					    int aux2 = solution_particle.get((int) swap_operator.getValue1());
					    solution_particle.set((int) swap_operator.getValue0(), aux2);
					    solution_particle.set((int) swap_operator.getValue1(), aux);
				    }
				}
				
				particle.setCurrentsolution(solution_particle);	
				int cost_current_solution = graph.getTotalPathCost(solution_particle);
				int cost_pbest_solution = graph.getTotalPathCost(solution_pbest);
				particle.setCost_current_solution(cost_current_solution);
				if(cost_current_solution < cost_pbest_solution){
					particle.setPbest(solution_particle);
					particle.setCost_pbest_solution(cost_current_solution);
				}
				else {
					particle.setPbest(solution_pbest);
					particle.setCost_pbest_solution(cost_pbest_solution);	
				}	
			}	
		}	
     }
}

	
