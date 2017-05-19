
public class Edge {
	
	private Integer src;
	private Integer dest;
	
	public Edge(int src,int dest){
		this.src=src;
		this.dest=dest;
	}
	
	@Override
	public boolean equals(Object object) {
	    boolean equals = false;
	    if (((Edge) object).src == null && ((Edge) object).dest == null) {
	        equals = true;
	    }
	    if (((Edge) object).src.equals(this.src) && ((Edge) object).dest.equals(this.dest)) {
	        equals = true;
	    }
	    if (((Edge) object).src == null && ((Edge) object).dest.equals(this.dest)) {
	        equals = true;
	    }
	    if (((Edge) object).src.equals(this.src) && ((Edge) object).dest == null) {
	        equals = true;
	    }
	    return equals;

	}
	
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}
	
	
	

}
