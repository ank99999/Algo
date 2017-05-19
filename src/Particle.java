//import java.util.ArrayList;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import org.javatuples.Quartet;

public class Particle {
	List<Integer> currentsolution;
	List<Integer> pbest;
	int cost_current_solution;
	int cost_pbest_solution;
	List<Quartet<Integer,Integer,Integer,Double>> particle_velocity;
	
	public Particle(List<Integer> solution,int cost){
		this.currentsolution = solution;
		this.pbest = solution;
		this.cost_current_solution=cost;
		this.cost_pbest_solution=cost;
		particle_velocity = new ArrayList<Quartet<Integer,Integer,Integer,Double>>();
	}
	
	public List<Integer> getCurrentsolution() {
		return currentsolution;
	}

	public void setCurrentsolution(List<Integer> currentsolution) {
		this.currentsolution = currentsolution;
	}

	public List<Integer> getPbest() {
		return pbest;
	}

	public void setPbest(List<Integer> pbest) {
		this.pbest = pbest;
	}

	public int getCost_current_solution() {
		return cost_current_solution;
	}

	public void setCost_current_solution(int cost_current_solution) {
		this.cost_current_solution = cost_current_solution;
	}

	public int getCost_pbest_solution() {
		return cost_pbest_solution;
	}

	public void setCost_pbest_solution(int cost_pbest_solution) {
		this.cost_pbest_solution = cost_pbest_solution;
	}

	public List<Quartet<Integer, Integer, Integer, Double>> getParticle_velocity() {
		return particle_velocity;
	}

	public void setParticle_velocity(List<Quartet<Integer, Integer, Integer, Double>> particle_velocity) {
		this.particle_velocity = particle_velocity;
	}
	
	public void clearVelocity(Particle p){
		p.particle_velocity.clear();
	}
}