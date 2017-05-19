import java.util.Comparator;

public class ParticleComparator implements Comparator<Particle>{

	@Override
	public int compare(Particle p1, Particle p2) {
		return p1.getCost_pbest_solution()-p2.getCost_pbest_solution();
	}

}
