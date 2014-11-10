package gti310.tp3.solver;

//Classe regroupant les infos d'une arête entre deux sommets.
public class Arete {
	
	private int sourceSummit;
	private int destinationSummit;
	private int distance;
	private boolean isTraveled = false;
	
	public Arete(int sourceSummit, int destinationSummit, int distance){
		
		this.sourceSummit = sourceSummit;
		this.destinationSummit = destinationSummit;
		this.distance = distance;
		
	}
	
	public int getSourceSummit(){
		
		return sourceSummit;
		
	}
	
	public int getDestinationSummit(){
		
		return destinationSummit;
		
	}
	
	public int getDistance(){
		
		return distance;
		
	}
	
	public boolean getIsTraveled(){
		
		return isTraveled;
		
	}
	
	public void isTraveled(){
		
		isTraveled = true;
	}
	
	public void isUntraveled(){
		
		isTraveled = false;
		
	}

}
