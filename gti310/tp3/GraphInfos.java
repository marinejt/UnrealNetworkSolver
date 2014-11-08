package gti310.tp3;

public class GraphInfos {
	
	private int nbSummit;
	private int infiniteValue;
	private int startingSummit;
	private int [][] graphMatrix;
	
	public GraphInfos(int nbSummit,int infiniteValue,int startingSummit,int[][] graphMatrix){
		
		nbSummit = this.nbSummit;
		infiniteValue = this.infiniteValue;
		startingSummit = this.startingSummit;
		graphMatrix = this.graphMatrix;
		
	}
	
	public int getNbSummit(){
		
		return nbSummit;
		
	}
	
	public int getInfiniteValue(){
		
		return infiniteValue;
		
	}
	
	public int getStartingSummit(){
		
		return startingSummit;
		
	}
	
	public int[][] getGraphMatrix(){
		
		return graphMatrix;
		
	}
	
}
