package gti310.tp3.solver;

//Classe regroupant les infos d'une arête entre deux sommets.
public class Arete {
	
	private int sourceSummit;
	private int destinationSummit;
	private boolean isTraveled = false;
	
	public Arete(int sourceSummit, int destinationSummit){
		
		this.sourceSummit = sourceSummit;
		this.destinationSummit = destinationSummit;
		
	}
	
	public int getSourceSummit(){
		
		return sourceSummit;
		
	}
	
	public int getDestinationSummit(){
		
		return destinationSummit;
		
	}
	
	public boolean getIsTraveled(){
		
		return isTraveled;
		
	}
	
	public void isTraveled(){
		
		isTraveled = true;
	}

}
